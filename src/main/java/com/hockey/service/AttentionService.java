package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.dto.AttentionNewDto;
import com.hockey.model.entity.Attention;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.model.vo.AttentionVO;
import com.hockey.repository.AttentionRepository;
import com.hockey.utils.UserUtils;

@Service
public class AttentionService {

	@Autowired
	private AttentionRepository attentionRepository;

	public Attention findById(Long id) {
		return attentionRepository.findOne(id);
	}

	public List<AttentionVO> getAllVO() {
		List<AttentionVO> result = new ArrayList<>();
		List<Attention> bdResult = attentionRepository.findAllByOrderByDateCreatedAsc();

		bdResult.forEach(r -> result.add(new AttentionVO(r)));

		return result;
	}

	public List<AttentionVO> getVOBySeat(Seat seat) {
		List<AttentionVO> result = new ArrayList<>();
		List<Attention> bdResult = attentionRepository.findBySeatOrderByDateCreatedAsc(seat);

		bdResult.forEach(r -> result.add(new AttentionVO(r)));

		return result;
	}

	public List<AttentionVO> getVOByAttentionType(AttentionType attentionType) {
		List<AttentionVO> result = new ArrayList<>();
		List<Attention> bdResult = attentionRepository.findByAttentionTypeOrderByDateCreatedAsc(attentionType);

		bdResult.forEach(r -> result.add(new AttentionVO(r)));

		return result;
	}
	
	public Attention attentionNew(AttentionNewDto attention) {
		if (attention != null) {
			
			Attention att = new Attention();
			
			att.setSeat(UserUtils.getUser());
			att.setAttentionType(attention.getAttentionType());
			att.setMessage(attention.getMessage());
			att.setDateCreated(DateUtils. (attention.getDateCreated()));
			
			return attentionRepository.save(att);
		} else {
			return null;
		}

	}
}
