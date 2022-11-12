package com.laptrinhjavaweb.dto;

import java.util.List;

public class AssignmentCustomerDTO extends AbstractDTO<AssignmentBuildingDTO> {
    private Long customerId;
    private List<Long> staffIds;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getStaffIds() {
        return staffIds;
    }

    public void setStaffIds(List<Long> staffIds) {
        this.staffIds = staffIds;
    }
}
