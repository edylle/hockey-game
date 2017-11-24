package com.hockey.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hockey.model.entity.Seat;
import com.hockey.service.SeatService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private SeatService seatService;

	@RequestMapping(value = "/seat-numbers", method = RequestMethod.GET)
	ResponseEntity<?> seatNumber() {
		return new ResponseEntity<>(seatService.listSeatNumberVO(), HttpStatus.OK);
	}

	@RequestMapping(value = "/seat-ranking", method = RequestMethod.GET)
	ResponseEntity<?> seatRanking() {
		return new ResponseEntity<>(seatService.listSeatRankingVO(), HttpStatus.OK);
	}
	
	@PostMapping("/change-status")
	public ResponseEntity<?> changeBlockNotification(Seat seat){
		
		seat = seatService.updateNotificationBlock(seat);
		
		return ResponseEntity.ok(seat);
		
	}
}
