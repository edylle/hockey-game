package com.hockey.model.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Answer;

@JsonInclude(Include.NON_EMPTY)
public class AnswerVO implements Serializable {

	private static final long serialVersionUID = 9166792440352243727L;

	private Answer answer;

	public AnswerVO(Answer answer) {
		if (answer == null) {
			throw new IllegalArgumentException();
		}

		this.answer = answer;
	}

	public Long getId() {
		return answer.getId();
	}

	public String getDescription() {
		return answer.getDescription();
	}
}
