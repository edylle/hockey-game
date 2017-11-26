package com.hockey.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "QUESTION")
public class Question implements Serializable {

	private static final long serialVersionUID = 1799196062448305140L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID", length = 8)
	private Long id;

	@Column(name = "DESCRIPTION", nullable = false)
	private String description;

	@OneToMany(mappedBy = "question", fetch = FetchType.EAGER)
	private List<Answer> listAnswer;

	public Question() {

	}

	public Question(String description) {
		this.description = description;
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

	public List<Answer> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<Answer> listAnswer) {
		this.listAnswer = listAnswer;
	}

}
