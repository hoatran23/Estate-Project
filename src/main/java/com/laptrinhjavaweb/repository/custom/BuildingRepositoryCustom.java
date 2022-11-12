package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.builder.BuildingSearchBuilder;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface BuildingRepositoryCustom {
    // List<BuildingEntity> findAll(Map<String, Object> requestParam, List<String> types);
    // List<BuildingEntity> findBuilding(Map<String, Object> requestParam, List<String> types);
    List<BuildingEntity> findBuilding(BuildingSearchBuilder buildingBuilder);
    List<BuildingEntity> findBuildingByStaffId(Long staffId);
}
