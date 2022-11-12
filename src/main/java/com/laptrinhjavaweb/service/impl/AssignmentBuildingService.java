//package com.laptrinhjavaweb.service.impl;
//
//import com.laptrinhjavaweb.dto.AssignmentBuildingDTO;
//import com.laptrinhjavaweb.entity.AssignmentBuildingEntity;
//import com.laptrinhjavaweb.entity.BuildingEntity;
//import com.laptrinhjavaweb.entity.UserEntity;
//import com.laptrinhjavaweb.repository.AssignmentBuildingRepository;
//import com.laptrinhjavaweb.repository.BuildingRepository;
//import com.laptrinhjavaweb.repository.UserRepository;
//import com.laptrinhjavaweb.service.IAssignmentBuildingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class AssignmentBuildingService implements IAssignmentBuildingService {
//
//    @Autowired
//    private AssignmentBuildingRepository assignmentBuildingRepository;
//
//    @Autowired
//    private BuildingRepository buildingRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//
//    @Override
//    public void save(AssignmentBuildingDTO assignmentBuildingDTO) {
//        Optional<BuildingEntity> buildingEntity = buildingRepository.findById(assignmentBuildingDTO.getBuildingId());
//        List<AssignmentBuildingEntity> assignmentBuildingEntities = assignmentBuildingRepository.findAllByBuildingId(assignmentBuildingDTO.getBuildingId());
//
//        assignmentBuildingEntities.stream().forEach(assignmentBuilding -> {
//            assignmentBuildingRepository.delete(assignmentBuilding);
//        });
//
//        assignmentBuildingDTO.getStaffIds().stream().forEach(staffId -> {
//            Optional<UserEntity> userEntity = userRepository.findById(staffId);
//            AssignmentBuildingEntity assignmentBuildingEntity = new AssignmentBuildingEntity(buildingEntity.get(), userEntity.get());
//            assignmentBuildingRepository.save(assignmentBuildingEntity);
//        });
//    }
//}
