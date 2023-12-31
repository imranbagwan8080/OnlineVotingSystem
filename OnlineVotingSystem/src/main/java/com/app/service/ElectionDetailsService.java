package com.app.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import com.app.dtos.CandidateDtos;
import com.app.dtos.ElectionCandidateDto;
import com.app.dtos.ElectionDetailsDto;
import com.app.dtos.PrevElectionDetailsDto;
import com.app.entities.ElectionDetails;

public interface ElectionDetailsService {
	public List<ElectionDetailsDto> getAllElectionDetails();
	public List<PrevElectionDetailsDto> getPreviousElectionDetails();
	public ElectionDetailsDto addElectionDetails(ElectionDetailsDto electionDetailsDto);
	public Set<String> getElectionNamesList() ;
	public ElectionDetailsDto getTodayElectionDetails(String constituency);
	public List<ElectionCandidateDto> getElectionCandidateList(long id);
	public List<CandidateDtos> getAllCandidates(long electionId);



}
