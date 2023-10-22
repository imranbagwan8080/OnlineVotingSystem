package com.app.service;

import java.util.List;

import com.app.dtos.VotingforCandidateDto;
import com.app.entities.Candidate;

public interface CandidateService {
	

	public String registerCandidate(Candidate candidate);

	public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId);
}
