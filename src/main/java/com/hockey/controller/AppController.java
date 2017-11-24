package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hockey.service.SeatService;
import com.hockey.utils.UserUtils;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private SeatService seatService;

	@GetMapping("/seat-numbers")
	public ResponseEntity<?> seatNumber() {
		return new ResponseEntity<>(seatService.listSeatNumberVO(), HttpStatus.OK);
	}

	@GetMapping("/seat-ranking")
	public ResponseEntity<?> seatRanking() {
		return new ResponseEntity<>(seatService.listSeatRankingVO(), HttpStatus.OK);
	}

	@PostMapping("/invert-notification-status")
	public ResponseEntity<?> changeBlockNotification() {
		seatService.invertNotificationStatusFrom(seatService.findById(UserUtils.getUser().getUsername()));
		return new ResponseEntity<>(HttpStatus.OK);
	}
}