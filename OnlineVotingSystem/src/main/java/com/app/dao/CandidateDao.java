package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Candidate;

public interface CandidateDao extends JpaRepository<Candidate, Long> {
List<Candidate> findByElectionDataId(long ElectionId);
}
