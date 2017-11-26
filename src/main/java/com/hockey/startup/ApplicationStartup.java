package com.hockey.startup;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hockey.model.entity.Answer;
import com.hockey.model.entity.Attention;
import com.hockey.model.entity.HistoryPoints;
import com.hockey.model.entity.Question;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.model.enumeration.HistoryType;
import com.hockey.repository.AnswerRepository;
import com.hockey.repository.AttentionRepository;
import com.hockey.repository.HistoryPointsRepository;
import com.hockey.repository.QuestionRepository;
import com.hockey.repository.SeatRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private AttentionRepository attentionRepository;
	@Autowired
	private HistoryPointsRepository historyPointsRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {

		System.out.println("CREATING MOCK SEATS");

		Random n = new Random();
		int i = 1;
		int max = 80;

		for (i = 1; i <= max; i++) {

			String credentials = StringUtils.leftPad(String.valueOf(i), 3, "0");
			Seat s = new Seat(credentials, credentials);
			
			if (i % 2 == 0) {
				s.setFanName("Fan n" + credentials);
			}

			// generate random points ranging from 1 to max
			s.setPoints(n.nextInt(max - 1 + 1) + 1);

			seatRepository.save(s);

			Attention a = new Attention();
			a.setSeat(s);

			AttentionType at;

			if (i % 2 == 0) {
				at = AttentionType.FILM;
			} else {
				at = AttentionType.MESSAGE;
			}

			a.setAttentionType(at);

			if (AttentionType.MESSAGE.equals(a.getAttentionType())) {
				a.setMessage("Message for seat " + i);
			}

			attentionRepository.save(a);

			HistoryPoints hp = new HistoryPoints();
			hp.setSeat(s);
			hp.setPoints(100L);
			hp.setDescription("Description CREDIT" + i);
			hp.setHistoryType(HistoryType.CREDIT);

			historyPointsRepository.save(hp);
			HistoryPoints hp1 = new HistoryPoints();
			hp1.setSeat(s);
			hp1.setPoints(60L);
			hp1.setDescription("Description DEBIT" + i);
			hp1.setHistoryType(HistoryType.DEBIT);
			
			historyPointsRepository.save(hp1);
		}

		System.out.println(--i + " MOCK SEATS CREATED");
		
		System.out.println("CREATING MOCK QUESTIONS");

		Question q1 = new Question("Which goalie has won the most career Vezina Trophies?");
		q1 = questionRepository.save(q1);

		Answer a11 = new Answer();
		a11.setDescription("Dominik Hasek");
		a11.setRightAnswer(false);
		a11.setQuestion(q1);
		answerRepository.save(a11);

		Answer a12 = new Answer();
		a12.setDescription("Terry Sawchuk");
		a12.setRightAnswer(false);
		a12.setQuestion(q1);
		answerRepository.save(a12);

		Answer a13 = new Answer();
		a13.setDescription("Glenn Hall");
		a13.setRightAnswer(false);
		a13.setQuestion(q1);
		answerRepository.save(a13);

		Answer a14 = new Answer();
		a14.setDescription("Jacques Plante");
		a14.setRightAnswer(true);
		a14.setQuestion(q1);
		answerRepository.save(a14);
		
		Question q2 = new Question("Who was the first defenceman in history to reach 1,000 career points?");
		q2 = questionRepository.save(q2);
		
		Answer a21 = new Answer();
		a21.setDescription("Denis Potvin");
		a21.setRightAnswer(true);
		a21.setQuestion(q2);
		answerRepository.save(a21);

		Answer a22 = new Answer();
		a22.setDescription("Bobby Orr");
		a22.setRightAnswer(false);
		a22.setQuestion(q2);
		answerRepository.save(a22);

		Answer a23 = new Answer();
		a23.setDescription("Ray Bourque");
		a23.setRightAnswer(false);
		a23.setQuestion(q2);
		answerRepository.save(a23);

		Answer a24 = new Answer();
		a24.setDescription("Phil Housley");
		a24.setRightAnswer(false);
		a24.setQuestion(q2);
		answerRepository.save(a24);
		
		Question q3 = new Question("Which goaltender did Wayne Gretzky score the most career goals on?");
		q3 = questionRepository.save(q3);
		
		Answer a31 = new Answer();
		a31.setDescription("Richard Brodeur");
		a31.setRightAnswer(true);
		a31.setQuestion(q3);
		answerRepository.save(a31);
		
		Answer a32 = new Answer();
		a32.setDescription("Mike Vernon");
		a32.setRightAnswer(false);
		a32.setQuestion(q3);
		answerRepository.save(a32);
		
		Answer a33 = new Answer();
		a33.setDescription("Kirk McLean");
		a33.setRightAnswer(false);
		a33.setQuestion(q3);
		answerRepository.save(a33);
		
		Answer a34 = new Answer();
		a34.setDescription("Daniel Berthiaume");
		a34.setRightAnswer(false);
		a34.setQuestion(q3);
		answerRepository.save(a34);
		
		Question q4 = new Question("Who has recorded the most career points in the Stanley Cup final?");
		q4 = questionRepository.save(q4);
		
		Answer a41 = new Answer();
		a41.setDescription("Maurice Richard");
		a41.setRightAnswer(false);
		a41.setQuestion(q4);
		answerRepository.save(a41);
		
		Answer a42 = new Answer();
		a42.setDescription("Wayne Gretzky");
		a42.setRightAnswer(false);
		a42.setQuestion(q4);
		answerRepository.save(a42);
		
		Answer a43 = new Answer();
		a43.setDescription("Bryan Trottier");
		a43.setRightAnswer(false);
		a43.setQuestion(q4);
		answerRepository.save(a43);
		
		Answer a44 = new Answer();
		a44.setDescription("Jean Béliveau");
		a44.setRightAnswer(true);
		a44.setQuestion(q4);
		answerRepository.save(a44);
		
		Question q5 = new Question("Which team holds the record with a 35-game regular-season unbeaten streak?");
		q5 = questionRepository.save(q5);
		
		Answer a51 = new Answer();
		a51.setDescription("1977–78 Montreal Canadiens");
		a51.setRightAnswer(false);
		a51.setQuestion(q5);
		answerRepository.save(a51);
		
		Answer a52 = new Answer();
		a52.setDescription("1979–80 Philadelphia Flyers");
		a52.setRightAnswer(true);
		a52.setQuestion(q5);
		answerRepository.save(a52);
		
		Answer a53 = new Answer();
		a53.setDescription("1984–85 Edmonton Oilers");
		a53.setRightAnswer(false);
		a53.setQuestion(q5);
		answerRepository.save(a53);
		
		Answer a54 = new Answer();
		a54.setDescription("1987–88 Boston Bruins");
		a54.setRightAnswer(false);
		a54.setQuestion(q5);
		answerRepository.save(a54);

		System.out.println("MOCK QUESTIONS CREATED");
	}

}
