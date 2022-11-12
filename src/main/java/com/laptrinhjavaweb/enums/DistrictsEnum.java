package com.laptrinhjavaweb.enums;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;

public enum DistrictsEnum {
	QUAN1("Q1", "Quận 1"),
	QUAN2("Q2", "Quận 2"),
	QUAN4("Q4", "Quận 4");
	private String code;
	private String name;
	 
	DistrictsEnum(String code, String name) {
         this.code = code;
         this.name = name;
    }

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static String getDistrictByCode(String districtCode) {
		if (StringUtils.isNotBlank(districtCode)) {
			DistrictsEnum[] list = DistrictsEnum.values();
			for (DistrictsEnum code : list) {
				if (code.getCode().equalsIgnoreCase(districtCode)
						|| code.name().equalsIgnoreCase(districtCode)) {
					return code.getName();
				}
			}
		}
		return null;
	}
}
