package com.laptrinhjavaweb.dto;

import java.util.ArrayList;
import java.util.List;

public class AssignmentBuildingDTO extends AbstractDTO<AssignmentBuildingDTO> {
    private Long buildingId;
    private List<Long> staffIds;

    public Long getBuildingId() {
        return buildingId;
    }

    public void setBuildingId(Long buildingId) {
        this.buildingId = buildingId;
    }

    public List<Long> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
}
