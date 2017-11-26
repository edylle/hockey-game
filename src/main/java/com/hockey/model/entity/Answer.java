package com.hockey.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANSWER")
public class Answer implements Serializable {

	private static final long serialVersionUID = -6095036034671330702L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 8)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@ManyToOne
	@JoinColumn(name = "SEAT_ID", nullable = false)
	private Question question;

	@Column(name = "RIGHT_ANSWER", nullable = false)
	private Boolean rightAnswer;

	public Answer() {
		rightAnswer = false;
	}

	// GETTERS AND SETTERS
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Boolean getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(Boolean rightAnswer) {
		this.rightAnswer = rightAnswer;
	}

}
