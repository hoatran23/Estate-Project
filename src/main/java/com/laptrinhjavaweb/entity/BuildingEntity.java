package com.laptrinhjavaweb.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class BuildingEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;
	
	@Column(name = "name")
    private String name;
	
	@Column(name = "districtcode")
    private String districtCode;
	
	@Column
    private String types;
	
    @Column(name = "numberofbasement")
    private Integer numberOfBasement;

    @Column
    private String street;

    @Column
    private String ward;
    
    @Column
	private String structure;
    
    @Column(name = "floorarea")
	private Integer floorArea;
    
    @Column
	private String direction;
    
    @Column
	private String level;
    
    @Column(name = "rentprice")
	private Integer rentPrice;
    
    @Column(name = "rentpricedescription")
	private String rentPriceDescription;
    
    @Column(name = "servicefee")
	private String serviceFee;
    
    @Column(name = "carfee")
	private String carFee;
    
    @Column(name = "moterbikefee")
	private String motorBikeFee;
    
    @Column(name = "overtimefee")
	private String overtimeFee;
    
    @Column(name = "waterfee")
	private String waterFee;
    
    @Column(name = "electricityfee")
	private String electricityFee;
    
    @Column
	private String deposit;
    
    @Column
	private String payment;
    
    @Column(name = "renttime")
	private String rentTime;
    
    @Column(name = "decorationtime")
	private String decorationTime;
    
    @Column(name = "brokeragefee")
	private BigDecimal brokerageFee;
    
    @Column
	private String note;
    
    @Column(name = "linkofbuilding")
	private String linkOfBuilding;
    
    @Column
	private String map;
    
    @Column
	private String image;
    
    @Column(name = "namemanager")
	private String nameManager;
    
    @Column(name = "phonemanager")
	private String phoneManager;
    
    @OneToMany(mappedBy="building", cascade = CascadeType.ALL)
    private List<RentAreaEntity> rentArea = new ArrayList<>();
    
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "assignmentbuilding",
			joinColumns = @JoinColumn(name = "buildingid", referencedColumnName = "id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "staffid", referencedColumnName = "id", nullable = false))
    private List<UserEntity> users = new ArrayList<>();

//    @OneToMany(mappedBy="building")
//    private List<AssignmentBuildingEntity> staffs = new ArrayList<>();

//	public List<AssignmentBuildingEntity> getStaffs() {
//		return staffs;
//	}
//
//	public void setStaffs(List<AssignmentBuildingEntity> staffs) {
//		this.staffs = staffs;
//	}

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

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}

	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getWard() {
		return ward;
	}

	public void setWard(String ward) {
		this.ward = ward;
	}

	public String getStructure() {
		return structure;
	}

	public void setStructure(String structure) {
		this.structure = structure;
	}

	public Integer getFloorArea() {
		return floorArea;
	}

	public void setFloorArea(Integer floorArea) {
		this.floorArea = floorArea;
	}

	public void setRentPrice(Integer rentPrice) {
		this.rentPrice = rentPrice;
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

	public int getRentPrice() {
		return rentPrice;
	}

	public void setRentPrice(int rentPrice) {
		this.rentPrice = rentPrice;
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

	public String getMotorBikeFee() {
		return motorBikeFee;
	}

	public void setMotorBikeFee(String motorBikeFee) {
		this.motorBikeFee = motorBikeFee;
	}

	public String getOvertimeFee() {
		return overtimeFee;
	}

	public void setOvertimeFee(String overtimeFee) {
		this.overtimeFee = overtimeFee;
	}

	public String getWaterFee() {
		return waterFee;
	}

	public void setWaterFee(String waterFee) {
		this.waterFee = waterFee;
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

	public BigDecimal getBrokerageFee() {
		return brokerageFee;
	}

	public void setBrokerageFee(BigDecimal brokerageFee) {
		this.brokerageFee = brokerageFee;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getLinkOfBuilding() {
		return linkOfBuilding;
	}

	public void setLinkOfBuilding(String linkOfBuilding) {
		this.linkOfBuilding = linkOfBuilding;
	}

	public String getMap() {
		return map;
	}

	public void setMap(String map) {
		this.map = map;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public List<RentAreaEntity> getRentArea() {
		return rentArea;
	}

	public void setRentArea(List<RentAreaEntity> rentArea) {
		this.rentArea = rentArea;
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
