package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.repository.custom.BuildingRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.BuildingEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>, BuildingRepositoryCustom {
}
