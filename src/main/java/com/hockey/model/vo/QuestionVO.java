package com.hockey.model.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hockey.model.entity.Question;

@JsonInclude(Include.NON_EMPTY)
public class QuestionVO implements Serializable {

	private static final long serialVersionUID = -1536848070097530987L;

	private Question question;
	private List<AnswerVO> listAnswer;

	public QuestionVO(Question question) {
		if (question == null) {
			throw new IllegalArgumentException();
		}

		listAnswer = new ArrayList<>();

		this.question = question;
		question.getListAnswer().forEach(a -> listAnswer.add(new AnswerVO(a)));
	}

	public Long getId() {
		return question.getId();
	}

	public String getDescription() {
		return question.getDescription();
	}

	public List<AnswerVO> getListAnswer() {
		return listAnswer;
	}

}
