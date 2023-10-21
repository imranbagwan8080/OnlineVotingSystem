package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Voter;

public interface VoterDao extends JpaRepository<Voter, Long> {

	Voter findByVoterIdAndPassword(String vId, String pass);

}
