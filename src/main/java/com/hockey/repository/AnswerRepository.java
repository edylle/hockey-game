package com.hockey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hockey.model.entity.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
