package com.hockey.startup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hockey.model.entity.Answer;
import com.hockey.model.entity.Question;
import com.hockey.repository.AnswerRepository;
import com.hockey.repository.QuestionRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

//	@Autowired
//	private SeatRepository seatRepository;
//	@Autowired
//	private AttentionRepository attentionRepository;
//	@Autowired
//	private HistoryPointsRepository historyPointsRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {

//		Random n = new Random();
//		int i = 1;
//		int max = 40;

		System.out.println("SAVING SEATS...");
		// System.out.println("SAVING ATTENTIONS...");
		// System.out.println("SAVING HISTORY POINTS...");
//		for (i = 1; i <= max; i++) {
//
//			Seat seat = saveSeats(i);
//
//			saveAttentions(i, seat);
//			saveHistoryPoints(i, seat);
//		}
		System.out.println("SAVING SEATS... COMPLETED");
		// System.out.println("SAVING ATTENTIONS... COMPLETED");
		// System.out.println("SAVING HISTORY POINTS... COMPLETED");

		saveQuestions();
	}

//	private Seat saveSeats(int i) {
//
//		String credentials = StringUtils.leftPad(String.valueOf(i), 3, "0");
//		Seat seat = new Seat(credentials, credentials);
//
//		// if (i % 2 == 0) {
//		// s.setFanName("Fan n" + credentials);
//		// }
//
//		// generate random points ranging from 1 to max
//		// s.setPoints(n.nextInt(max - 1 + 1) + 1);
//
//		seat = seatRepository.save(seat);
//		return seat;
//	}

//	private void saveAttentions(int i, Seat s) {
//		Attention a = new Attention();
//		a.setSeat(s);
//
//		AttentionType at;
//
//		if (i % 2 == 0) {
//			at = AttentionType.FILM;
//		} else {
//			at = AttentionType.MESSAGE;
//		}
//
//		a.setAttentionType(at);
//
//		if (AttentionType.MESSAGE.equals(a.getAttentionType())) {
//			a.setMessage("Message for seat " + i);
//		}
//
//		attentionRepository.save(a);
//	}
//
//	private void saveHistoryPoints(int i, Seat seat) {
//		HistoryPoints hp = new HistoryPoints();
//		hp.setSeat(seat);
//		hp.setPoints(100L);
//		hp.setDescription("Description CREDIT" + i);
//		hp.setHistoryType(HistoryType.CREDIT);
//
//		historyPointsRepository.save(hp);
//
//		HistoryPoints hp1 = new HistoryPoints();
//		hp1.setSeat(seat);
//		hp1.setPoints(60L);
//		hp1.setDescription("Description DEBIT" + i);
//		hp1.setHistoryType(HistoryType.DEBIT);
//
//		historyPointsRepository.save(hp1);
//	}

	private void saveQuestions() {
		System.out.println("SAVING QUESTIONS...");

		// QUESTION 1
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

		// QUESTION 2
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

		// QUESTION 3
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

		// QUESTION 4
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

		// QUESTION 5
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

		// QUESTION 6
		Question q6 = new Question("Who holds the NHL record for most career regular-season power-play goals?");
		q6 = questionRepository.save(q6);

		Answer a61 = new Answer();
		a61.setDescription("Phil Esposito");
		a61.setRightAnswer(false);
		a61.setQuestion(q6);
		answerRepository.save(a61);

		Answer a62 = new Answer();
		a62.setDescription("Jaromir Jagr");
		a62.setRightAnswer(false);
		a62.setQuestion(q6);
		answerRepository.save(a62);

		Answer a63 = new Answer();
		a63.setDescription("Dave Andreychuk");
		a63.setRightAnswer(true);
		a63.setQuestion(q6);
		answerRepository.save(a63);

		Answer a64 = new Answer();
		a64.setDescription("Mike Gartner");
		a64.setRightAnswer(false);
		a64.setQuestion(q6);
		answerRepository.save(a64);

		// QUESTION 7
		Question q7 = new Question("Which player holds the record for goals by a rookie in a single post-season?");
		q7 = questionRepository.save(q7);

		Answer a71 = new Answer();
		a71.setDescription("Mike Bossy");
		a71.setRightAnswer(false);
		a71.setQuestion(q7);
		answerRepository.save(a71);

		Answer a72 = new Answer();
		a72.setDescription("Rick Middleton");
		a72.setRightAnswer(false);
		a72.setQuestion(q7);
		answerRepository.save(a72);

		Answer a73 = new Answer();
		a73.setDescription("Jari Kurri");
		a73.setRightAnswer(false);
		a73.setQuestion(q7);
		answerRepository.save(a73);

		Answer a74 = new Answer();
		a74.setDescription("Dino Ciccarelli");
		a74.setRightAnswer(true);
		a74.setQuestion(q7);
		answerRepository.save(a74);

		// QUESTION 8
		Question q8 = new Question("Which of these top-20 all-time career leaders in goals had the best single-season mark?");
		q8 = questionRepository.save(q8);

		Answer a81 = new Answer();
		a81.setDescription("Brendan Shanahan");
		a81.setRightAnswer(false);
		a81.setQuestion(q8);
		answerRepository.save(a81);

		Answer a82 = new Answer();
		a82.setDescription("Mike Gartner");
		a82.setRightAnswer(false);
		a82.setQuestion(q8);
		answerRepository.save(a82);

		Answer a83 = new Answer();
		a83.setDescription("Mark Recchi");
		a83.setRightAnswer(true);
		a83.setQuestion(q8);
		answerRepository.save(a83);

		Answer a84 = new Answer();
		a84.setDescription("Mark Messier");
		a84.setRightAnswer(false);
		a84.setQuestion(q8);
		answerRepository.save(a84);

		// QUESTION 9
		Question q9 = new Question("Which of these goalies has the most career ties?");
		q9 = questionRepository.save(q9);

		Answer a91 = new Answer();
		a91.setDescription("Glenn Hall");
		a91.setRightAnswer(true);
		a91.setQuestion(q9);
		answerRepository.save(a91);

		Answer a92 = new Answer();
		a92.setDescription("Patrick Roy");
		a92.setRightAnswer(false);
		a92.setQuestion(q9);
		answerRepository.save(a92);

		Answer a93 = new Answer();
		a93.setDescription("Jacques Plante");
		a93.setRightAnswer(false);
		a93.setQuestion(q9);
		answerRepository.save(a93);

		Answer a94 = new Answer();
		a94.setDescription("Tony Esposito");
		a94.setRightAnswer(false);
		a94.setQuestion(q9);
		answerRepository.save(a94);

		// QUESTION 10
		Question q10 = new Question("Which of these goalies has the most career ties?");
		q10 = questionRepository.save(q10);

		Answer a101 = new Answer();
		a101.setDescription("Glenn Hall");
		a101.setRightAnswer(true);
		a101.setQuestion(q10);
		answerRepository.save(a101);

		Answer a102 = new Answer();
		a102.setDescription("Patrick Roy");
		a102.setRightAnswer(false);
		a102.setQuestion(q10);
		answerRepository.save(a102);

		Answer a103 = new Answer();
		a103.setDescription("Jacques Plante");
		a103.setRightAnswer(false);
		a103.setQuestion(q10);
		answerRepository.save(a103);

		Answer a104 = new Answer();
		a104.setDescription("Tony Esposito");
		a104.setRightAnswer(false);
		a104.setQuestion(q10);
		answerRepository.save(a104);

		// QUESTION 11
		Question q11 = new Question("Who holds the record for most consecutive wins by a goaltender in the Stanley Cup final?");
		q11 = questionRepository.save(q11);

		Answer a111 = new Answer();
		a111.setDescription("Turk Broda");
		a111.setRightAnswer(false);
		a111.setQuestion(q11);
		answerRepository.save(a111);

		Answer a112 = new Answer();
		a112.setDescription("Ken Dryden");
		a112.setRightAnswer(true);
		a112.setQuestion(q11);
		answerRepository.save(a112);

		Answer a113 = new Answer();
		a113.setDescription("Billy Smith");
		a113.setRightAnswer(false);
		a113.setQuestion(q11);
		answerRepository.save(a113);

		Answer a114 = new Answer();
		a114.setDescription("Grant Fuhr");
		a114.setRightAnswer(false);
		a114.setQuestion(q11);
		answerRepository.save(a114);

		// QUESTION 12
		Question q12 = new Question("Who was the last active player to play in the Original Six era?");
		q12 = questionRepository.save(q12);

		Answer a121 = new Answer();
		a121.setDescription("Tony Esposito");
		a121.setRightAnswer(false);
		a121.setQuestion(q12);
		answerRepository.save(a121);

		Answer a122 = new Answer();
		a122.setDescription("Gordie Howe");
		a122.setRightAnswer(false);
		a122.setQuestion(q12);
		answerRepository.save(a122);

		Answer a123 = new Answer();
		a123.setDescription("Wayne Cashman");
		a123.setRightAnswer(true);
		a123.setQuestion(q12);
		answerRepository.save(a123);

		Answer a124 = new Answer();
		a124.setDescription("Brad Park");
		a124.setRightAnswer(false);
		a124.setQuestion(q12);
		answerRepository.save(a124);

		// QUESTION 13
		Question q13 = new Question("Which player has been traded for Chris Pronger twice?");
		q13 = questionRepository.save(q13);

		Answer a131 = new Answer();
		a131.setDescription("Joffrey Lupul");
		a131.setRightAnswer(true);
		a131.setQuestion(q13);
		answerRepository.save(a131);

		Answer a132 = new Answer();
		a132.setDescription("Dustin Penner");
		a132.setRightAnswer(false);
		a132.setQuestion(q13);
		answerRepository.save(a132);

		Answer a133 = new Answer();
		a133.setDescription("Brendan Shanahan");
		a133.setRightAnswer(false);
		a133.setQuestion(q13);
		answerRepository.save(a133);

		Answer a134 = new Answer();
		a134.setDescription("Curtis Joseph");
		a134.setRightAnswer(false);
		a134.setQuestion(q13);
		answerRepository.save(a134);

		// QUESTION 14
		Question q14 = new Question("Who was the first player to record 300 PIM in a season?");
		q14 = questionRepository.save(q14);

		Answer a141 = new Answer();
		a141.setDescription("Howie Young");
		a141.setRightAnswer(false);
		a141.setQuestion(q14);
		answerRepository.save(a141);

		Answer a142 = new Answer();
		a142.setDescription("Keith Magnuson");
		a142.setRightAnswer(false);
		a142.setQuestion(q14);
		answerRepository.save(a142);

		Answer a143 = new Answer();
		a143.setDescription("Dave Schultz");
		a143.setRightAnswer(true);
		a143.setQuestion(q14);
		answerRepository.save(a143);

		Answer a144 = new Answer();
		a144.setDescription("Tiger Williams");
		a144.setRightAnswer(false);
		a144.setQuestion(q14);
		answerRepository.save(a144);

		// QUESTION 15
		Question q15 = new Question("Who is the only player to record 100 points and 100 penalty minutes in his rookie season?");
		q15 = questionRepository.save(q15);

		Answer a151 = new Answer();
		a151.setDescription("Sidney Crosby");
		a151.setRightAnswer(true);
		a151.setQuestion(q15);
		answerRepository.save(a151);

		Answer a152 = new Answer();
		a152.setDescription("Joe Nieuwendyk");
		a152.setRightAnswer(false);
		a152.setQuestion(q15);
		answerRepository.save(a152);

		Answer a153 = new Answer();
		a153.setDescription("Stan Mikita");
		a153.setRightAnswer(false);
		a153.setQuestion(q15);
		answerRepository.save(a153);

		Answer a154 = new Answer();
		a154.setDescription("Joe Thornton");
		a154.setRightAnswer(false);
		a154.setQuestion(q15);
		answerRepository.save(a154);

		System.out.println("SAVING QUESTIONS... COMPLETED");
	}

}
