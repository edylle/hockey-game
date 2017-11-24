package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

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
	
	public Seat updateNotificationBlock(Seat seat) {
		
		seat.setReceiveNotification(!seat.getReceiveNotification());
		
		return seatRepository.save(seat);
	}

}
