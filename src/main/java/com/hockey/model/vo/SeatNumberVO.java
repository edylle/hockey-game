package com.hockey.model.vo;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Seat;

@JsonInclude(Include.NON_EMPTY)
public class SeatNumberVO implements Serializable {

	private static final long serialVersionUID = 6313983904874082591L;

	private Seat seat;

	public SeatNumberVO(Seat seat) {
		if (seat == null) {
			throw new IllegalArgumentException();
		}

		this.seat = seat;
	}

	public String getSeatNumber() {
		return seat.getUsername();
	}

	public boolean isAvailable() {
		return StringUtils.isEmpty(seat.getFanName());
	}
}
