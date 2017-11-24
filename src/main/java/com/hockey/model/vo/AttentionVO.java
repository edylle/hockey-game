package com.hockey.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Attention;

@JsonInclude(Include.NON_EMPTY)
public class AttentionVO implements Serializable {

	private static final long serialVersionUID = -1649136971504269455L;

	private Attention attention;

	public AttentionVO(Attention attention) {
		if (attention == null) {
			throw new IllegalArgumentException();
		}

		this.attention = attention;
	}

	public Long getId() {
		return attention.getId();
	}

	public String getSeatNumber() {
		return attention.getSeat().getUsername();
	}

	public String getSeatFanName() {
		return attention.getSeat().getFanName();
	}

	public String getAttentionType() {
		return attention.getAttentionType().name();
	}

	public String getMessage() {
		return attention.getMessage();
	}

}
