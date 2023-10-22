package com.app.service;

import com.app.entities.Candidate;

public interface CandidateService {
	

	public String registerCandidate(Candidate candidate);

	public String verifyCandidateByAdmin(long candidateId);

	public String rejectCandidateByAdmin(long candidateId);


}
