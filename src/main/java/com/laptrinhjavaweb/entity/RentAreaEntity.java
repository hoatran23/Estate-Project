package com.laptrinhjavaweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "rentarea")
public class RentAreaEntity extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	@Column
	private Integer value;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="buildingid")
    private BuildingEntity building;

	public RentAreaEntity(Integer value, BuildingEntity building) {
		this.value = value;
		this.building = building;
	}

	public RentAreaEntity() {

	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
