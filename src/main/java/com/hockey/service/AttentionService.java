package com.hockey.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hockey.model.entity.Attention;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;
import com.hockey.model.vo.AttentionVO;
import com.hockey.repository.AttentionRepository;

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

	public void acceptAttention(Long idAttention, boolean accepted) {
		Attention attention = findById(idAttention);

		if (attention != null) {
			attention.setAccepted(accepted);
			attentionRepository.save(attention);
		}
	}
}
