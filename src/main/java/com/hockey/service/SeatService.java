package com.hockey.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.Seat;
import com.hockey.model.vo.SeatNumberVO;
import com.hockey.model.vo.SeatRankingVO;
import com.hockey.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	public Seat findById(String username) {
		return seatRepository.findOne(username);
	}

	public List<SeatNumberVO> listSeatNumberVO() {
		List<SeatNumberVO> result = new ArrayList<>();
		List<Seat> bdResult = seatRepository.findAll();

		bdResult.forEach(r -> result.add(new SeatNumberVO(r)));

		return result;
	}

	public List<SeatRankingVO> listSeatRankingVO() {
		List<SeatRankingVO> result = new ArrayList<>();
		List<Seat> bdResult = seatRepository.findAllByOrderByPointsDesc();

		bdResult.forEach(r -> result.add(new SeatRankingVO(r)));

		return result;
	}

	public Seat invertNotificationStatusFrom(Seat seat) {
		if (seat == null)
			return null;

		seat.setReceiveNotification(!seat.getReceiveNotification());
		return seatRepository.save(seat);
	}

	public Long findSeatBalance(String seat) {
		if (StringUtils.isEmpty(seat)) {
			return null;
		}

		BigDecimal balance = seatRepository.findSeatBalance(seat);
		return balance != null ? balance.longValue() : 0L;
	}

}
