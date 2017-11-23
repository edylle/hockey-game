package com.hockey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hockey.model.entity.Seat;

public interface SeatRepository extends JpaRepository<Seat, String> {

	List<Seat> findAllByOrderByPointsDesc();

}
