package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hockey.service.AttentionService;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AttentionService attentionService;

	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("attentions", attentionService.getVOByAccepted(false));

		return mv;
	}

	@PostMapping("accept-attention/{id}/{accepted}")
	public @ResponseBody String acceptAttention(@PathVariable long id, @PathVariable boolean accepted) throws JsonProcessingException {
		try {
			attentionService.acceptAttention(id, true);

		} catch (Exception e) {
			return new ObjectMapper().writeValueAsString("error");
		}

		return new ObjectMapper().writeValueAsString("success");
	}

}
