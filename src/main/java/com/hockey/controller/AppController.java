package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hockey.service.SeatService;

@Controller
@RequestMapping("/app")
public class AppController {

	@Autowired
	private SeatService seatService;

	@RequestMapping(value = "/seat-numbers", method = RequestMethod.GET)
	ResponseEntity<?> allSeatsSimple() {
		return new ResponseEntity<>(seatService.listSeatSimple(), HttpStatus.OK);
	}
}
