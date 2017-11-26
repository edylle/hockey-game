package com.hockey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hockey.model.dto.AttentionNewDTO;
import com.hockey.model.dto.MyInfoDTO;
import com.hockey.model.entity.Attention;
import com.hockey.model.vo.AttentionVO;
import com.hockey.model.vo.SeatVO;
import com.hockey.service.AttentionService;
import com.hockey.service.HistoryPointsService;
import com.hockey.service.QuestionService;
import com.hockey.service.SeatService;
import com.hockey.utils.Messages;
import com.hockey.utils.UserUtils;

@RestController
@RequestMapping("/app")
public class AppController {

	@Autowired
	private SeatService seatService;
	@Autowired
	private HistoryPointsService historyPointsService;
	@Autowired
	private AttentionService attentionService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private Messages messages;

	@GetMapping("/seat-numbers")
	public ResponseEntity<?> seatNumber() {
		return new ResponseEntity<>(seatService.listSeatNumberVO(), HttpStatus.OK);
	}

	@GetMapping("/seat-ranking")
	public ResponseEntity<?> seatRanking() {
		return new ResponseEntity<>(seatService.listSeatRankingVO(), HttpStatus.OK);
	}

	@PostMapping("/seat-points-balance")
	public ResponseEntity<?> findSeatBalance() {
		return new ResponseEntity<>(seatService.findSeatBalance(UserUtils.getUser().getUsername()), HttpStatus.OK);
	}

	@PostMapping("/seat-history-points")
	public ResponseEntity<?> findSeatHistoryPoints() {
		return new ResponseEntity<>(historyPointsService.listHistoryPointsVO(UserUtils.getUser()), HttpStatus.OK);
	}

	@PostMapping("/my-info")
	public ResponseEntity<?> myInfo(@RequestBody(required = false) MyInfoDTO dto) {
		return new ResponseEntity<>(seatService.getMyInfo(dto), HttpStatus.OK);
	}

	@PostMapping("/ask-question")
	public ResponseEntity<?> askQuestion() {
		return new ResponseEntity<>(questionService.getRandomQuestion(), HttpStatus.OK);
	}

	@PostMapping("/submit-answer/{idAnswer}")
	public ResponseEntity<?> submitAnswer(@PathVariable Long idAnswer) {
		return new ResponseEntity<>(questionService.isCorrect(idAnswer), HttpStatus.OK);
	}

	@PostMapping("/logout")
	public ResponseEntity<?> logout() {
		seatService.logout();
		template.convertAndSend("/remove-attentions-from", new SeatVO(UserUtils.getUser()));
		return ResponseEntity.ok(messages.getMessageBy("message.logged.out"));
	}

	@PostMapping("/invert-notification-status")
	public ResponseEntity<?> invertNotificationStatus() {
		return new ResponseEntity<>(seatService.invertNotificationStatusFrom(seatService.findById(UserUtils.getUser().getUsername())), HttpStatus.OK);
	}

	@PostMapping("/new-attention")
	public ResponseEntity<?> newAttention(@RequestBody AttentionNewDTO attention) {
		if (attention != null) {
			Attention att = attentionService.attentionNew(attention);

			if (att != null) {
				AttentionVO vo = new AttentionVO(att);
				template.convertAndSend("/attention-client", vo);
				return ResponseEntity.status(HttpStatus.CREATED).body(vo);
			}
		}

		return ResponseEntity.notFound().build();

	}

}