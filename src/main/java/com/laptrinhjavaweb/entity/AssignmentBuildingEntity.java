//package com.laptrinhjavaweb.entity;
//
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.Table;
//import java.util.Optional;
//
//@Entity
//@Table(name = "assignmentbuilding")
//public class AssignmentBuildingEntity extends BaseEntity {
//
//    @ManyToOne
//    @JoinColumn(name="buildingid", nullable=false)
//    private BuildingEntity building;
//
//    @ManyToOne
//    @JoinColumn(name="staffid", nullable=false)
//    private UserEntity staff;
//
//    public AssignmentBuildingEntity(BuildingEntity buildingEntity, UserEntity userEntity) {
//        this.building = buildingEntity;
//        this.staff = userEntity;
//    }
//
//    public AssignmentBuildingEntity() {
//
//    }
//
//    public BuildingEntity getBuilding() {
//        return building;
//    }
//
//    public void setBuilding(BuildingEntity building) {
//        this.building = building;
//    }
//
//    public UserEntity getStaff() {
//        return staff;
//    }
//
//    public void setStaff(UserEntity staff) {
//        this.staff = staff;
//    }
//}
