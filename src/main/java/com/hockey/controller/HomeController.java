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
import com.hockey.exception.PushException;
import com.hockey.service.AttentionService;
import com.hockey.service.PushService;
import com.hockey.utils.Messages;

@Controller
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private AttentionService attentionService;
	@Autowired
	private PushService pushService;
	@Autowired
	private Messages messages;

	@RequestMapping
	public ModelAndView home() {
		ModelAndView mv = new ModelAndView("home");

		mv.addObject("attentions", attentionService.getVOByAccepted(false));

		return mv;
	}

	@PostMapping("accept-attention/{id}/{accepted}")
	public @ResponseBody String acceptAttention(@PathVariable long id, @PathVariable boolean accepted) throws JsonProcessingException {
		attentionService.acceptAttention(id, true);
		return new ObjectMapper().writeValueAsString("success");
	}

	@PostMapping("send-question")
	public @ResponseBody String sendQuestion() throws PushException, JsonProcessingException {
		pushService.notifyAndroid(messages.getMessageBy("message.notification.question.title"), messages.getMessageBy("message.notification.question.message"));
		return new ObjectMapper().writeValueAsString("success");
	}
	
}
