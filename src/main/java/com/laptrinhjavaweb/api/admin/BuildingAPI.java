package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
import com.laptrinhjavaweb.dto.request.BuildingRequestDTO;
import com.laptrinhjavaweb.dto.response.BuildingSearchResponseDTO;
import com.laptrinhjavaweb.dto.response.ResponseDTO;
import com.laptrinhjavaweb.dto.response.StaffResponseDTO;
// import com.laptrinhjavaweb.service.impl.AssignmentBuildingService;
import com.laptrinhjavaweb.service.impl.BuildingService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {
	
	@Autowired
    private BuildingService buildingService;

    @Autowired
    private UserService userService;

//    @Autowired
//    private AssignmentBuildingService assignmentBuildingService;

    @PostMapping("/search")
    public ResponseDTO searchBuilding(@RequestBody Map<String, Object> requestParams) {
        List<BuildingSearchResponseDTO> buildingSearchResponseDTOS = buildingService.searchBuilding(requestParams);
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setData(buildingSearchResponseDTOS);
        if (buildingSearchResponseDTOS != null) {
            responseDTO.setMessage("ok");
        }
        return responseDTO;
    }

    @PostMapping
    public ResponseDTO createBuilding(@RequestBody BuildingRequestDTO newBuilding) {
        ResponseDTO responseDTO = buildingService.save(newBuilding);
        return responseDTO;
    }
    
    @GetMapping("/staffs")
    public ResponseDTO loadStaff(@RequestParam(value = "buildingid") Long buildingId) {
    	ResponseDTO result = new ResponseDTO();
        List<StaffResponseDTO> listBuildingAssignedStaff = userService.getBuildingAssignedStaff(buildingId);
        result.setData(listBuildingAssignedStaff);
        result.setMessage("success");
        return result;
    }

    @PostMapping("/staffs")
    public ResponseDTO assignBuilding(@RequestBody AssignmentBuildingDTO assignmentBuildingDTO) {
        ResponseDTO result = new ResponseDTO();
        // assignmentBuildingService.save(assignmentBuildingDTO);
        buildingService.assignmentBuilding(assignmentBuildingDTO);
        result.setMessage("insert_success");;
        return result;
    }

    @DeleteMapping
    public void deleteBuilding(@RequestBody List<Long> ids) {
        buildingService.deleteBuilding(ids);
    }
}
