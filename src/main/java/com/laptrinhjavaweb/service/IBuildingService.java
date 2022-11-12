package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.BuildingTypesDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;

import java.util.List;
import java.util.Map;

public interface IBuildingService {
    Map<String, String> getDistricts();
    List<BuildingTypesDTO> getAllBuildingTypes();
    List<BuildingTypesDTO> getBuildingTypesWithCheck(List<BuildingTypesDTO> buildingTypesDTOS, String types);
    String getDistrictByCode(String districtCode);
    List<BuildingSearchResponseDTO> findAllBuildingSearch();
    BuildingRequestDTO findById(long id);
	ResponseDTO save(BuildingRequestDTO buildingRequestDTO);
    void deleteBuilding(List<Long> ids);
    List<BuildingSearchResponseDTO> searchBuilding(Map<String, Object> requestParams);

    void assignmentBuilding(AssignmentBuildingDTO assignmentBuildingDTO);

}
