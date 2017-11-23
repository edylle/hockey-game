package com.hockey.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Seat;

@JsonInclude(Include.NON_EMPTY)
public class SeatSimpleVO implements Serializable {

	private static final long serialVersionUID = 6313983904874082591L;

	private Seat seat;

	public SeatSimpleVO(Seat seat) {
		if (seat == null) {
			throw new IllegalArgumentException();
		}

		this.seat = seat;
	}

	public String getSeatNumber() {
		return seat.getUsername();
	}

}
