package com.hockey.model.dto;

import java.io.Serializable;

import com.hockey.model.enumeration.AttentionType;

public class AttentionNewDTO implements Serializable {

	private static final long serialVersionUID = 2745686866429130826L;

	private AttentionType attentionType;
	private String message;

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

}
