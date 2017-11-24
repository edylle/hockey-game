package com.hockey.model.dto;

import java.io.Serializable;

import com.hockey.model.enumeration.AttentionType;

public class AttentionNewDto implements Serializable{

	private static final long serialVersionUID = -4956139464759547581L;

	private Long seatId;
	private AttentionType attentionType;
	private String message;
	private String dateCreated;

	public Long getSeatId() {
		return seatId;
	}

	public void setSeatId(Long seatId) {
		this.seatId = seatId;
	}

	public AttentionType getAttentionType() {
		return attentionType;
	}

	public void setAttentionType(AttentionType attentionType) {
		this.attentionType = attentionType;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

}
