package com.hockey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hockey.model.entity.HistoryPoints;

public interface HistoryPointsRepository extends JpaRepository<HistoryPoints, Long> {

}
