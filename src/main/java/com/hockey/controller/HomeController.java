package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hockey.service.AttentionService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AttentionService attentionService;

	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("attentions", attentionService.getAllVO());

		return mv;
	}

}
