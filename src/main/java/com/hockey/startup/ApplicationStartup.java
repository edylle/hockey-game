package com.hockey.startup;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hockey.model.entity.Attention;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.repository.AttentionRepository;
import com.hockey.repository.SeatRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private SeatRepository seatRepository;
	@Autowired
	private AttentionRepository attentionRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {

		System.out.println("CREATING MOCK SEATS");

		Random n = new Random();
		int i = 1;

		for (i = 1; i <= 5; i++) {

			String credentials = StringUtils.leftPad(String.valueOf(i), 3, "0");
			Seat s = new Seat(credentials, credentials);

			// generate random points ranging from 1 to 5
			s.setPoints(n.nextInt(5 - 1 + 1) + 1);

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
		}

		System.out.println(--i + " MOCK SEATS CREATED");

	}

}
