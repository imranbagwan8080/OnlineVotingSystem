package com.app.service;

import java.util.List;
import java.util.Set;

import com.app.dtos.ElectionDetailsDto;
import com.app.dtos.PrevElectionDetailsDto;

public interface ElectionDetailsService {
	public List<ElectionDetailsDto> getAllElectionDetails();
	public List<PrevElectionDetailsDto> getPreviousElectionDetails();
	public ElectionDetailsDto addElectionDetails(ElectionDetailsDto electionDetailsDto);
	public Set<String> getElectionNamesList() ;
}
