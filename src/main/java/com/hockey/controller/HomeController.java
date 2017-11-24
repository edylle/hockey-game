package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hockey.model.vo.AttentionVO;
import com.hockey.service.AttentionService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AttentionService attentionService;
	@Autowired
	private SimpMessagingTemplate template;

	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("attentions", attentionService.getAllVO());

		// this is just a test
		// template.convertAndSend("/attention-client", new AttentionVO(attentionService.findById(1L)));

		return mv;
	}

}
