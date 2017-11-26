package com.hockey.service;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.Answer;
import com.hockey.model.vo.QuestionVO;
import com.hockey.repository.AnswerRepository;
import com.hockey.repository.QuestionRepository;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	public QuestionVO getRandomQuestion() {
		Long count = questionRepository.count();

		int randomNum = ThreadLocalRandom.current().nextInt(1, count.intValue() + 1);

		return new QuestionVO(questionRepository.findOne(Long.valueOf(randomNum)));
	}

	public boolean isCorrect(Long idAnswer) {
		Answer answer = answerRepository.findOne(idAnswer);
		return (answer != null && answer.getRightAnswer());
	}
}
