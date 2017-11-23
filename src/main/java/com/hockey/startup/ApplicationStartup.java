package com.hockey.startup;

import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.hockey.model.entity.Seat;
import com.hockey.repository.SeatRepository;

@Component
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {

	@Autowired
	private SeatRepository seatRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {

		System.out.println("CREATING MOCK SEATS");

		Random n = new Random();
		int i = 1;

		for (i = 1; i <= 100; i++) {

			String credentials = StringUtils.leftPad(String.valueOf(i), 3, "0");
			Seat s = new Seat(credentials, credentials);

			// generate random points ranging from 1 to 100
			s.setPoints(n.nextInt(100 - 1 + 1) + 1);

			seatRepository.save(s);
		}

		System.out.println(--i + " MOCK SEATS CREATED");

	}

}
