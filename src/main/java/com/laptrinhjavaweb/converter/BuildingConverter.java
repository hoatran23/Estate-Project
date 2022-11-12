package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.enums.BuildingTypesEnum;
import com.laptrinhjavaweb.enums.DistrictsEnum;
import com.laptrinhjavaweb.repository.RentAreaRepository;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.utils.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class BuildingConverter {
	@Autowired
    private ModelMapper modelMapper;

    @Autowired
    private BuildingService buildingService;

    @Autowired
    private RentAreaRepository rentAreaRepository;
    
    public BuildingEntity convertDTOToEntity(BuildingRequestDTO buildingRequestDTO) {
    	BuildingEntity buildingEntity = modelMapper.map(buildingRequestDTO, BuildingEntity.class);
    	return buildingEntity;
    }
    
    public BuildingRequestDTO convertEntityToDTO(BuildingEntity buildingEntity) {
    	BuildingRequestDTO buildingRequestDTO = modelMapper.map(buildingEntity, BuildingRequestDTO.class);
    	return buildingRequestDTO;
    }

    public BuildingEntity convertBuildingSearchResponseDTOToEntity(BuildingSearchResponseDTO buildingSearchResponseDTO) {
        BuildingEntity buildingEntity = modelMapper.map(buildingSearchResponseDTO, BuildingEntity.class);
        return buildingEntity;
    }

    public BuildingSearchResponseDTO convertEntityToBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
        BuildingSearchResponseDTO buildingSearchResponseDTO = modelMapper.map(buildingEntity, BuildingSearchResponseDTO.class);
        Boolean checkAddress = StringUtils.isNotBlank(buildingEntity.getStreet()) ||
                StringUtils.isNotBlank(buildingEntity.getWard()) ||
                StringUtils.isNotBlank(DistrictsEnum.getDistrictByCode(buildingEntity.getDistrictCode()));
        buildingSearchResponseDTO.setAddress(
                checkAddress ?
                buildingEntity.getStreet().concat(" ").concat(buildingEntity.getWard()).concat(" ")
                        .concat(DistrictsEnum.getDistrictByCode(buildingEntity.getDistrictCode()))
                : "");
        List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findRentAreaByBuildingId(buildingEntity.getId());
        List<String> rentArea = new ArrayList<>();
        for (RentAreaEntity rentAreaEntity : rentAreaEntities) {
            rentArea.add(rentAreaEntity.getValue().toString());
        }
        buildingSearchResponseDTO.setRentArea(String.join(", ", rentArea));
        return buildingSearchResponseDTO;
    }

    public BuildingSearchBuilder converToBuildingSearchBuilder(Map<String, Object> requestParams) {
        BuildingSearchBuilder buildingSearchBuilder = new BuildingSearchBuilder.Builder()
                .setDirection(MapUtils.getObject(requestParams, "direction", String.class))
                .setDistrictCode(MapUtils.getObject(requestParams, "districtCode", String.class))
                .setFloorArea(MapUtils.getObject(requestParams, "floorArea", Integer.class))
                .setLevel(MapUtils.getObject(requestParams, "level", String.class))
                .setManagerName(MapUtils.getObject(requestParams, "managerName", String.class))
                .setManagerPhone(MapUtils.getObject(requestParams, "managerPhone", String.class))
                .setName(MapUtils.getObject(requestParams, "name", String.class))
                .setNumberOfBasement(MapUtils.getObject(requestParams, "numberOfBasement", Integer.class))
                .setRentAreaFrom(MapUtils.getObject(requestParams, "rentAreaFrom", Integer.class))
                .setRentAreaTo(MapUtils.getObject(requestParams, "rentAreaTo", Integer.class))
                .setRentPriceFrom(MapUtils.getObject(requestParams, "rentPriceFrom", Integer.class))
                .setRentPriceTo(MapUtils.getObject(requestParams, "rentPriceTo", Integer.class))
                .setStaffId(MapUtils.getObject(requestParams, "staffId", Long.class))
                .setStreet(MapUtils.getObject(requestParams, "street", String.class))
                .setTypes(MapUtils.getObject(requestParams, "types", String.class))
                .setWard(MapUtils.getObject(requestParams, "ward", String.class))
                .build();
        return buildingSearchBuilder;
    }
}
