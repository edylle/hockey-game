package com.hockey.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.HistoryPoints;
import com.hockey.repository.HistoryRepository;

@Service
public class HistoryService {

	@Autowired
	private HistoryRepository historyRepository;

	public List<HistoryPoints> listSeatHistoryPoints() {
		
		return historyRepository.findAll();
	}

	
}
