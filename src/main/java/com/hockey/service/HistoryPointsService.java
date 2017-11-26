package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.HistoryPoints;
import com.hockey.model.entity.Seat;
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

}
