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

import com.hockey.model.enumeration.AttentionType;

@Entity
@Table(name = "ATTENTION")
public class Attention implements Serializable {

	private static final long serialVersionUID = 3706452506129983608L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 8)
	private Long id;

	@NotNull(message = "{validation.field.required.seat}")
	@ManyToOne
	@JoinColumn(name = "SEAT_ID", nullable = false)
	private Seat seat;

	@NotNull(message = "{validation.field.required.attention.type}")
	@Enumerated(EnumType.STRING)
	@Column(name = "ATTENTION_TYPE", nullable = false)
	private AttentionType attentionType;

	@Column(name = "MESSAGE")
	private String message;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DATE_CREATED", nullable = false)
	private Date dateCreated;

	public Attention() {
		dateCreated = new Date();
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

}
