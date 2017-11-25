package com.hockey.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hockey.model.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

	List<Seat> findAllByOrderByPointsDesc();

	@Query(value = "SELECT ((select sum(points) from history_points where seat_id = :seat_id and history_type = 'CREDIT') - (select sum(points) from history_points where seat_id = :seat_id and history_type = 'DEBIT')) AS PONTOS;", nativeQuery = true)
	BigDecimal findSeatBalance(@Param("seat_id") String idSeat);

}
