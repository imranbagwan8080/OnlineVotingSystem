package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Long> {

}
