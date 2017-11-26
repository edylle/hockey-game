package com.hockey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hockey.model.entity.Attention;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;

public interface AttentionRepository extends JpaRepository<Attention, Long> {

	List<Attention> findAllByOrderByDateCreatedAsc();

	List<Attention> findByAcceptedOrderByDateCreatedAsc(Boolean accepted);

	List<Attention> findBySeatOrderByDateCreatedAsc(Seat seat);

	List<Attention> findByAttentionTypeOrderByDateCreatedAsc(AttentionType attentionType);
}
