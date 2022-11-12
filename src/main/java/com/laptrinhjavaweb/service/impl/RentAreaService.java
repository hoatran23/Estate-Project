package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.RentAreaConverter;
import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.entity.BuildingEntity;
import com.laptrinhjavaweb.entity.RentAreaEntity;
import com.laptrinhjavaweb.repository.BuildingRepository;
import com.laptrinhjavaweb.service.IRentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RentAreaService implements IRentAreaService {
    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private RentAreaConverter rentAreaConverter;

    @Override
    public List<RentAreaDTO> findRentAreaByBuilding(Long buildingId) {
        List<RentAreaDTO> rentAreaDTOS = new ArrayList<>();
        Optional<BuildingEntity> buildingEntity = buildingRepository.findById(buildingId);
        List<RentAreaEntity> rentAreaEntities = buildingEntity.get().getRentArea();
        rentAreaDTOS = rentAreaEntities.stream().map(item ->
                rentAreaConverter.convertEntityToDTO(item)).collect(Collectors.toList());
        return rentAreaDTOS;
    }

    @Override
    public String getRentAreas(List<RentAreaDTO> rentAreaDTOS) {
        List<String> rentArea = new ArrayList<>();
        for (RentAreaDTO ra: rentAreaDTOS) {
            rentArea.add(ra.getValue().toString());
        }
        return String.join(", ", rentArea);
    }
}
