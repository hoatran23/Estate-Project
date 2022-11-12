package com.laptrinhjavaweb.enums;

import org.apache.commons.lang.StringUtils;

public enum BuildingTypesEnum {
	TANGTRET("tang-tret", "Tầng Trệt"),
	NGUYENCAN("nguyen-can", "Nguyên Căn"),
	NOITHAT("noi-that", "Nội Thất");
	private String code;
	private String value;
	 
	BuildingTypesEnum(String code, String value) {
        this.code = code;
        this.value = value;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
