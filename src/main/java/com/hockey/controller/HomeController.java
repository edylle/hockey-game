package com.hockey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/home")
public class HomeController {

	@RequestMapping
	public ModelAndView newUser() {
		ModelAndView mv = new ModelAndView("home");

		return mv;
	}

}
