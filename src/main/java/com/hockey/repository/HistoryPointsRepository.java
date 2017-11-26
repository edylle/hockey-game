package com.hockey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hockey.model.entity.HistoryPoints;
import com.hockey.model.entity.Seat;

public interface HistoryPointsRepository extends JpaRepository<HistoryPoints, Long> {

	List<HistoryPoints> findBySeatOrderByHistoryDateAsc(Seat seat);

	@Modifying(clearAutomatically = true)
	@Query(value = "DELETE FROM history_points WHERE seat_id = (:seat_id);", nativeQuery = true)
	void deleteBy(@Param("seat_id") String idSeat);
}
