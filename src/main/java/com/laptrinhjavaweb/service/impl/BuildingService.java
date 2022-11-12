package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.converter.BuildingConverter;
import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingTypesDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
// import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
// import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.repository.RentAreaRepository;
// import com.laptrinhjavaweb.service.IAssignmentBuildingService;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.security.utils.SecurityUtils;
import com.laptrinhjavaweb.service.IBuildingService;
import com.laptrinhjavaweb.utils.NumberUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

import static java.lang.Integer.parseInt;

@Service
public class BuildingService implements IBuildingService {
	
	@Autowired
    private BuildingRepository buildingRepository;

	@Autowired
	private RentAreaRepository rentAreaRepository;

    @Autowired
    private BuildingConverter buildingConverter;

//	@Autowired
//	private AssignmentBuildingRepository assignmentBuildingRepository;

	@Autowired
	private UserRepository userRepository;

	@Override
	public List<BuildingSearchResponseDTO> searchBuilding(Map<String, Object> requestParams) {
		List<BuildingSearchResponseDTO> results = new ArrayList<>();

		if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
			Long staffId = SecurityUtils.getPrincipal().getId();
			requestParams.put("staffId", staffId);
		}

		BuildingSearchBuilder buildingSearchBuilder = buildingConverter.converToBuildingSearchBuilder(requestParams);
		List<BuildingEntity> buildingEntities = buildingRepository.findBuilding(buildingSearchBuilder);

		for (BuildingEntity buildingEntity : buildingEntities) {
			BuildingSearchResponseDTO buildingSearchResponse = buildingConverter.convertEntityToBuildingSearchResponseDTO(buildingEntity);
			results.add(buildingSearchResponse);
		}
		return results;
	}

	@Override
	public List<BuildingSearchResponseDTO> findAllBuildingSearch() {
		List<BuildingEntity> buildingEntities = new ArrayList<>();
		if (SecurityUtils.getAuthorities().contains("ROLE_MANAGER")) {
			buildingEntities = buildingRepository.findAll();
		} else if (SecurityUtils.getAuthorities().contains("ROLE_STAFF")) {
			Long staffId = SecurityUtils.getPrincipal().getId();
			buildingEntities = buildingRepository.findBuildingByStaffId(staffId);
		}
		// List<BuildingEntity> buildingEntities = buildingRepository.findAll();
		List<BuildingSearchResponseDTO> results = new ArrayList<>();
		for (BuildingEntity item: buildingEntities) {
			BuildingSearchResponseDTO buildingSearchResponseDTO = buildingConverter.convertEntityToBuildingSearchResponseDTO(item);
			results.add(buildingSearchResponseDTO);
		}
		return results;
	}

    @Override
    @Transactional
    public ResponseDTO save(BuildingRequestDTO buildingRequestDTO) {
		ResponseDTO responseDTO = new ResponseDTO();
		BuildingEntity buildingEntity = buildingConverter.convertDTOToEntity(buildingRequestDTO);

		// Split rentArea to array String
		String[] listRentArea = buildingRequestDTO.getRentArea().split(",");

		// Check format rentArea
		if (StringUtils.isNotBlank(listRentArea[0])) {
			if (isCorrectRentAreaFormat(listRentArea) == false) {
				if (buildingRequestDTO.getId() != null) {
					responseDTO = responseStatus(responseDTO, buildingEntity, "error_syntax");
				} else {
					responseDTO = responseStatus(responseDTO, null, "error_syntax");
				}
				return responseDTO;
			}
		}

		// Delete old rentArea when exits in db
		if (buildingRequestDTO.getId() != null) {
			List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findRentAreaByBuildingId(buildingRequestDTO.getId());
			rentAreaRepository.deleteAll(rentAreaEntities);
		}

		// Set assignment building
		if (buildingEntity.getId() != null) {
			Optional<BuildingEntity> building = buildingRepository.findById(buildingEntity.getId());
			List<UserEntity> userEntities = building.get().getUsers();
			buildingEntity.setUsers(userEntities);
		}

		// Set rent area
        if (StringUtils.isNotBlank(listRentArea[0])) {
            for (String rentArea: listRentArea) {
                RentAreaEntity rentAreaEntity = new RentAreaEntity(parseInt(rentArea.trim()), buildingEntity);
				buildingEntity.getRentArea().add(rentAreaEntity);
			}
        }

		// Save building
		BuildingEntity result = buildingRepository.save(buildingEntity);

		// If RentArea existed -> Update new RentArea -> Else Insert new RentArea
//		if (StringUtils.isNotBlank(listRentArea[0])) {
//			for (String rentArea: listRentArea) {
//				RentAreaEntity rentAreaEntity = new RentAreaEntity(parseInt(rentArea.trim()), result);
//				rentAreaRepository.save(rentAreaEntity);
//			}
//		}

		// Set status response
		if (buildingRequestDTO.getId() != null) {
			responseDTO = responseStatus(responseDTO, result, "update_success");
		} else {
			responseDTO = responseStatus(responseDTO, result, "insert_success");
		}

        return responseDTO;
    }

	public boolean isCorrectRentAreaFormat(String[] listRentArea) {
		for (String rentArea: listRentArea) {
			if (NumberUtils.isInteger(rentArea.trim()) == false) {
				return false;
			}
		}
		return true;
	}

	public ResponseDTO responseStatus(ResponseDTO responseDTO,
									  BuildingEntity building,
									  String value) {
		if (building != null) {
			responseDTO.setMessage(value);
			responseDTO.setDetail(building.getId().toString());
		} else {
			responseDTO.setMessage(value);
			responseDTO.setDetail("");
		}
		return responseDTO;
	}

	@Override
	public Map<String, String> getDistricts() {
		Map<String, String> result = new HashMap<>();
        for (DistrictsEnum item: DistrictsEnum.values()) {
        	result.put(item.getCode(), item.getName());
        }
        return result;
	}

	@Override
	public String getDistrictByCode(String districtCode) {
		String name = "";
		if (districtCode.equals("-1")) {
			name = "Quận";
		} else {
			for (DistrictsEnum item: DistrictsEnum.values()) {
				if (districtCode.equals(item.getCode())) {
					name = item.getName();
				}
			}
		}
		return name;
	}

	@Override
	public List<BuildingTypesDTO> getAllBuildingTypes() {
		List<BuildingTypesDTO> buildingTypesDTOS = new ArrayList<>();
		for (BuildingTypesEnum item : BuildingTypesEnum.values()) {
			BuildingTypesDTO buildingTypesDTO = new BuildingTypesDTO();
			buildingTypesDTO.setCode(item.getCode());
			buildingTypesDTO.setValue(item.getValue());
			buildingTypesDTOS.add(buildingTypesDTO);
		}
		return buildingTypesDTOS;
	}

	@Override
	public List<BuildingTypesDTO> getBuildingTypesWithCheck(List<BuildingTypesDTO> buildingTypesDTOS, String types) {
		if (StringUtils.isNotBlank(types)) {
			String[] listType = types.split(", ");
			for (String type: listType) {
				for (BuildingTypesDTO buildingTypesDTO: buildingTypesDTOS) {
					if (type.trim().equals(buildingTypesDTO.getCode())) {
						buildingTypesDTO.setCheck("checked");
					}
				}
			}
		}
		return buildingTypesDTOS;
	}

	@Override
	@Transactional
	public void deleteBuilding(List<Long> ids) {
		buildingRepository.deleteInBatch(buildingRepository.findAllById(ids));
	}

	@Override
	public BuildingRequestDTO findById(long id) {
		BuildingEntity buildingEntity = buildingRepository.findById(id).get();
		BuildingRequestDTO buildingRequestDTO = buildingConverter.convertEntityToDTO(buildingEntity);
		return buildingRequestDTO;
	}

	@Override
	@Transactional
	public void assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO) {
		Optional<BuildingEntity> buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId());
		List<UserEntity> userEntities = userRepository.findAllById(assignmentBuildingDTO.getStaffIds());
		buildingEntity.get().setUsers(userEntities);
		buildingRepository.save(buildingEntity.get());
	}
}
