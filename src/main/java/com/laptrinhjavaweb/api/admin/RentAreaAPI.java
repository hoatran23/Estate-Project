package com.laptrinhjavaweb.api.admin;

import com.laptrinhjavaweb.dto.RentAreaDTO;
import com.laptrinhjavaweb.service.impl.RentAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RentAreaAPI {

    @Autowired
    private RentAreaService rentAreaService;

    @GetMapping("/api/rentareas")
    public List<RentAreaDTO> getRentArea(@RequestParam(value = "buildingid", required = false) Long buildingId) {
        return rentAreaService.findRentAreaByBuilding(buildingId);
    }
}
