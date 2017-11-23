package com.hockey.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Seat;

@JsonInclude(Include.NON_EMPTY)
public class SeatVO implements Serializable {

	private static final long serialVersionUID = -7143644262823894776L;

	private Seat seat;

	public SeatVO(Seat seat) {
		if (seat == null) {
			throw new IllegalArgumentException();
		}

		this.seat = seat;
	}

	public String getSeatNumber() {
		return seat.getUsername();
	}

	public String getFanName() {
		return seat.getFanName();
	}

	public Integer getPoints() {
		return seat.getPoints();
	}
}
