package com.laptrinhjavaweb.dto;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class BuildingDTO extends AbstractDTO<BuildingDTO>{

	private static final long serialVersionUID = 1L;
	
	private Long staffId;
	private String name;
	private String districtCode;
	private String ward;
    private String street;
    private String structure;
    private Integer numberOfBasement;
    private Integer floorArea;
    private String direction;
    private String level;
    private Long rentAreaTo;
    private Long rentAreaFrom;
    private String rentAreaDescription;
    private Long rentPriceTo;
    private Long rentPriceFrom;
	private String rentPriceDescription;
	private String serviceFee;
	private String carFee;
	private String motorFee;
	private String overtimeFee;
	// private String waterFee;
	private String electricityFee;
	private String deposit;
	private String payment;
	private String rentTime;
	private String decorationTime;
	private String nameManager;
	private String phoneManager;
	private BigDecimal brokerageFee;
	// private String note;
	// private String linkOfBuilding;
	// private String map;
	// private String image;
	public Long getStaffId() {
		return staffId;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDistrictCode() {
		return districtCode;
	}
	public void setDistrictCode(String districtCode) {
		this.districtCode = districtCode;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public Long getRentAreaTo() {
		return rentAreaTo;
	}
	public void setRentAreaTo(Long rentAreaTo) {
		this.rentAreaTo = rentAreaTo;
	}
	public Long getRentAreaFrom() {
		return rentAreaFrom;
	}
	public void setRentAreaFrom(Long rentAreaFrom) {
		this.rentAreaFrom = rentAreaFrom;
	}
	public String getRentAreaDescription() {
		return rentAreaDescription;
	}
	public void setRentAreaDescription(String rentAreaDescription) {
		this.rentAreaDescription = rentAreaDescription;
	}
	public Long getRentPriceTo() {
		return rentPriceTo;
	}
	public void setRentPriceTo(Long rentPriceTo) {
		this.rentPriceTo = rentPriceTo;
	}
	public Long getRentPriceFrom() {
		return rentPriceFrom;
	}
	public void setRentPriceFrom(Long rentPriceFrom) {
		this.rentPriceFrom = rentPriceFrom;
	}
	public String getRentPriceDescription() {
		return rentPriceDescription;
	}
	public void setRentPriceDescription(String rentPriceDescription) {
		this.rentPriceDescription = rentPriceDescription;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public String getCarFee() {
		return carFee;
	}
	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}
	public String getMotorFee() {
		return motorFee;
	}
	public void setMotorFee(String motorFee) {
		this.motorFee = motorFee;
	}
	public String getOvertimeFee() {
		return overtimeFee;
	}
	public void setOvertimeFee(String overtimeFee) {
		this.overtimeFee = overtimeFee;
	}
	public String getElectricityFee() {
		return electricityFee;
	}
	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public String getRentTime() {
		return rentTime;
	}
	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}
	public String getDecorationTime() {
		return decorationTime;
	}
	public void setDecorationTime(String decorationTime) {
		this.decorationTime = decorationTime;
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
	public BigDecimal getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(BigDecimal brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
}
