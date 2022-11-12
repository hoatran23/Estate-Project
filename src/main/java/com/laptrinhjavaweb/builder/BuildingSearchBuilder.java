package com.laptrinhjavaweb.builder;

public class BuildingSearchBuilder {
    private String direction;
    private String districtCode;
    private Integer floorArea;
    private String level;
    private String nameManager;
    private String phoneManager;
    private String name;
    private Integer numberOfBasement;
    private Integer rentAreaFrom;
    private Integer rentAreaTo;
    private Integer rentPriceFrom;
    private Integer rentPriceTo;
    private Long staffId;
    private String street;
    private String types;
    private String ward;

    private BuildingSearchBuilder(Builder builder) {
        this.direction = builder.direction;
        this.districtCode = builder.districtCode;
        this.floorArea = builder.floorArea;
        this.level = builder.level;
        this.nameManager = builder.nameManager;
        this.phoneManager = builder.phoneManager;
        this.name = builder.name;
        this.numberOfBasement = builder.numberOfBasement;
        this.rentAreaFrom = builder.rentAreaFrom;
        this.rentAreaTo = builder.rentAreaTo;
        this.rentPriceFrom = builder.rentPriceFrom;
        this.rentPriceTo = builder.rentPriceTo;
        this.staffId = builder.staffId;
        this.street = builder.street;
        this.types = builder.types;
        this.ward = builder.ward;
    }

    public static class Builder {
        private String direction;
        private String districtCode;
        private Integer floorArea;
        private String level;
        private String nameManager;
        private String phoneManager;
        private String name;
        private Integer numberOfBasement;
        private Integer rentAreaFrom;
        private Integer rentAreaTo;
        private Integer rentPriceFrom;
        private Integer rentPriceTo;
        private Long staffId;
        private String street;
        private String types;
        private String ward;

        public Builder setDirection(String direction) {
            this.direction = direction;
            return this;
        }

        public Builder setDistrictCode(String districtCode) {
            this.districtCode = districtCode;
            return this;
        }

        public Builder setFloorArea(Integer floorArea) {
            this.floorArea = floorArea;
            return this;
        }

        public Builder setLevel(String level) {
            this.level = level;
            return this;
        }

        public Builder setManagerName(String nameManager) {
            this.nameManager = nameManager;
            return this;
        }

        public Builder setManagerPhone(String phoneManager) {
            this.phoneManager = phoneManager;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setNumberOfBasement(Integer numberOfBasement) {
            this.numberOfBasement = numberOfBasement;
            return this;
        }

        public Builder setRentAreaFrom(Integer rentAreaFrom) {
            this.rentAreaFrom = rentAreaFrom;
            return this;
        }

        public Builder setRentAreaTo(Integer rentAreaTo) {
            this.rentAreaTo = rentAreaTo;
            return this;
        }

        public Builder setRentPriceFrom(Integer rentPriceFrom) {
            this.rentPriceFrom = rentPriceFrom;
            return this;
        }

        public Builder setRentPriceTo(Integer rentPriceTo) {
            this.rentPriceTo = rentPriceTo;
            return this;
        }

        public Builder setStaffId(Long staffId) {
            this.staffId = staffId;
            return this;
        }

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setTypes(String types) {
            this.types = types;
            return this;
        }

        public Builder setWard(String ward) {
            this.ward = ward;
            return this;
        }

        public BuildingSearchBuilder build() {
            return new BuildingSearchBuilder(this);
        }
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getDistrictCode() {
        return districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public Integer getFloorArea() {
        return floorArea;
    }

    public void setFloorArea(Integer floorArea) {
        this.floorArea = floorArea;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getManagerName() {
        return nameManager;
    }

    public void setManagerName(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getManagerPhone() {
        return phoneManager;
    }

    public void setManagerPhone(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfBasement() {
        return numberOfBasement;
    }

    public void setNumberOfBasement(Integer numberOfBasement) {
        this.numberOfBasement = numberOfBasement;
    }

    public Integer getRentAreaFrom() {
        return rentAreaFrom;
    }

    public void setRentAreaFrom(Integer rentAreaFrom) {
        this.rentAreaFrom = rentAreaFrom;
    }

    public Integer getRentAreaTo() {
        return rentAreaTo;
    }

    public void setRentAreaTo(Integer rentAreaTo) {
        this.rentAreaTo = rentAreaTo;
    }

    public Integer getRentPriceFrom() {
        return rentPriceFrom;
    }

    public void setRentPriceFrom(Integer rentPriceFrom) {
        this.rentPriceFrom = rentPriceFrom;
    }

    public Integer getRentPriceTo() {
        return rentPriceTo;
    }

    public void setRentPriceTo(Integer rentPriceTo) {
        this.rentPriceTo = rentPriceTo;
    }

    public Long getStaffId() {
        return staffId;
    }

    public void setStaffId(Long staffId) {
        this.staffId = staffId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getTypes() {
        return types;
    }

    public void setTypes(String types) {
        this.types = types;
    }

    public String getNameManager() {
        return nameManager;
    }

    public void setNameManager(String nameManager) {
        this.nameManager = nameManager;
    }

    public String getPhoneManager() {
        return phoneManager;
    }

    public void setPhoneManager(String phoneManager) {
        this.phoneManager = phoneManager;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }
}
