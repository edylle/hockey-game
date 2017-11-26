package com.hockey.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.HistoryPoints;
import com.hockey.utils.DateUtils;

@JsonInclude(Include.NON_EMPTY)
public class HistoryPointsVO implements Serializable {

	private static final long serialVersionUID = 2237401304632375752L;

	private HistoryPoints history;

	public HistoryPointsVO(HistoryPoints history) {
		if (history == null) {
			throw new IllegalArgumentException();
		}

		this.history = history;
	}

	public Long getId() {
		return history.getId();
	}

	public Long getPoints() {
		return history.getPoints();
	}

	public String getDescription() {
		return history.getDescription();
	}

	public String getHistoryType() {
		return history.getHistoryType().name();
	}

	public String getHistoryDate() {
		return DateUtils.convertDateToString(history.getHistoryDate(), "dd/MM/yyyy - HH:mm");
	}
}
