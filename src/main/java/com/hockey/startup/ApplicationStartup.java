package com.hockey.startup;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hockey.model.entity.Attention;
import com.hockey.model.entity.HistoryPoints;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.model.enumeration.HistoryType;
import com.hockey.repository.AttentionRepository;
import com.hockey.repository.HistoryPointsRepository;
import com.hockey.repository.SeatRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private AttentionRepository attentionRepository;
	@Autowired
	private HistoryPointsRepository historyPointsRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {

		System.out.println("CREATING MOCK SEATS");

		Random n = new Random();
		int i = 1;
		int max = 80;

		for (i = 1; i <= max; i++) {

			String credentials = StringUtils.leftPad(String.valueOf(i), 3, "0");
			Seat s = new Seat(credentials, credentials);
			s.setFanName("Fan n" + credentials);

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

	}

}
