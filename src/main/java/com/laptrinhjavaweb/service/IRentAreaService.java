package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.RentAreaDTO;

import java.util.List;

public interface IRentAreaService {
    List<RentAreaDTO> findRentAreaByBuilding(Long buildingId);
    String getRentAreas(List<RentAreaDTO> rentAreaDTOS);
}
