package com.hockey.model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import com.hockey.model.enumeration.HistoryType;

@Entity
@Table(name = "HISTORY_POINTS")
public class HistoryPoints implements Serializable {

	private static final long serialVersionUID = 7113221308389706367L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 8)
	private Long id;

	@NotNull(message = "{validation.field.required.seat}")
	@ManyToOne
	@JoinColumn(name = "SEAT_ID", nullable = false)
	private Seat seat;

	@NotNull
	@Column(name = "POINTS", nullable = false)
	private Long points;

	@NotNull
	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@NotNull(message = "{validation.field.required.attention.type}")
	@Enumerated(EnumType.STRING)
	@Column(name = "HISTORY_TYPE", nullable = false)
	private HistoryType historyType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "HISTORY_DATE", nullable = false)
	private Date historyDate;

	public HistoryPoints() {
		historyDate = new Date();
	}

	// GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}

	public Long getPoints() {
		return points;
	}

	public void setPoints(Long points) {
		this.points = points;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public HistoryType getHistoryType() {
		return historyType;
	}

	public void setHistoryType(HistoryType historyType) {
		this.historyType = historyType;
	}

	public Date getHistoryDate() {
		return historyDate;
	}

	public void setHistoryDate(Date historyDate) {
		this.historyDate = historyDate;
	}

}
