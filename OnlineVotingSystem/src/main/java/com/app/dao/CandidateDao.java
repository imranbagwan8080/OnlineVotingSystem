package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Candidate;

@Repository
public interface CandidateDao extends JpaRepository<Candidate, Long> {
    List<Candidate> findByElectionDataId(long ElectionId);

    Candidate findById(long id);
    
    List<Candidate>  findByElectionDetailsId(long electionDetailsID);
}
