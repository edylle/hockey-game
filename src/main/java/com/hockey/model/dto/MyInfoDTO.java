package com.hockey.model.dto;

import java.io.Serializable;

public class MyInfoDTO implements Serializable {

	private static final long serialVersionUID = -4348515539597591303L;

	private String fanName;

	public String getFanName() {
		return fanName;
	}

	public void setFanName(String fanName) {
		this.fanName = fanName;
	}

}
