package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.Seat;
import com.hockey.model.vo.SeatSimpleVO;
import com.hockey.repository.SeatRepository;

@Service
public class SeatService {

	@Autowired
	private SeatRepository seatRepository;

	public List<SeatSimpleVO> listSeatSimple() {
		List<SeatSimpleVO> result = new ArrayList<>();
		List<Seat> bdResult = seatRepository.findAll();

		bdResult.forEach(r -> result.add(new SeatSimpleVO(r)));

		return result;
	}

}
