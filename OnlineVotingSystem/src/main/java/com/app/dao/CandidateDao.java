package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Long> {

}
