package com.hockey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hockey.model.entity.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
