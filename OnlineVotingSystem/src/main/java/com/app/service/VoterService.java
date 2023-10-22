package com.app.service;

import org.springframework.http.ResponseEntity;

import com.app.dtos.VoterDto;
import com.app.dtos.VoterIdCandidateId;
import com.app.entities.Voter;

public interface VoterService {

	String registerVoterService(Voter voter);

	Voter login(String vId, String pass);

	public String votForCandidates(VoterIdCandidateId vIdcId);

    VoterDto getVoterDetails(String voterId);

}
