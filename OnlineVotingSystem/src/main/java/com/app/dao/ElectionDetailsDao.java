package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.app.entities.ElectionDetails;

import jakarta.transaction.Transactional;

public interface ElectionDetailsDao extends JpaRepository<ElectionDetails, Long> {
ElectionDetails findByEndDate(Date endDate);
List<ElectionDetails> findAll();
List<ElectionDetails> findByConstituency(String constituency);
ElectionDetails findById(long id);

@Modifying
@Transactional
@Query("UPDATE ElectionDetails e SET e.winnerVoterId = :candidateID WHERE e.id = :electionId")
int updateField(@Param("candidateID") long candidateID, @Param("electionId") long electionId);



}
