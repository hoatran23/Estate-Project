package com.laptrinhjavaweb.repository.custom;

import com.laptrinhjavaweb.entity.RentAreaEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RentAreaRepositoryCustom {
    List<RentAreaEntity> findRentAreaByBuildingId(Long buildingId);
}
