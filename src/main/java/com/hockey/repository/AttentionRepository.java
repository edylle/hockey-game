package com.hockey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hockey.model.entity.Attention;
import com.hockey.model.entity.Seat;
import com.hockey.model.enumeration.AttentionType;

public interface AttentionRepository extends JpaRepository<Attention, Long> {

	List<Attention> findAllByOrderByDateCreatedAsc();

	List<Attention> findByAcceptedOrderByDateCreatedAsc(Boolean accepted);

	List<Attention> findBySeatOrderByDateCreatedAsc(Seat seat);

	List<Attention> findByAttentionTypeOrderByDateCreatedAsc(AttentionType attentionType);

	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM attention WHERE seat_id = (:seat_id);", nativeQuery = true)
	void deleteBy(@Param("seat_id") String idSeat);
}
