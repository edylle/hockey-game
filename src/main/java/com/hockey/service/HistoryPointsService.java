package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.HistoryPoints;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.model.enumeration.HistoryType;
import com.hockey.model.vo.HistoryPointsVO;
import com.hockey.repository.HistoryPointsRepository;

@Service
public class HistoryPointsService {

	@Autowired
	private HistoryPointsRepository historyPointsRepository;

	public List<HistoryPointsVO> listHistoryPointsVO(Seat seat) {
		List<HistoryPointsVO> result = new ArrayList<>();
		List<HistoryPoints> bdResult = historyPointsRepository.findBySeatOrderByHistoryDateAsc(seat);

		bdResult.forEach(r -> result.add(new HistoryPointsVO(r)));

		return result;
	}

	public HistoryPoints save(HistoryType historyType, AttentionType attentionType, Long points, Long idQuestion, Seat seat) {
		HistoryPoints hp = new HistoryPoints();
		hp.setSeat(seat);
		hp.setPoints(points);
		hp.setHistoryType(historyType);

		if (AttentionType.FILM.equals(attentionType)) {
			hp.setDescription("Film accepted");
			idQuestion = null;

		} else if (AttentionType.MESSAGE.equals(attentionType)) {
			hp.setDescription("Message accepted");
			idQuestion = null;

		} else {
			hp.setDescription("Answered question " + idQuestion);
		}

		return historyPointsRepository.save(hp);
	}
}
