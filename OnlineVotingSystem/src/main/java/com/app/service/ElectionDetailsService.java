package com.app.service;

import java.util.List;

import com.app.dtos.ElectionDetailsDto;
import com.app.dtos.PrevElectionDetailsDto;
import com.app.entities.ElectionDetails;

public interface ElectionDetailsService {
	public List<ElectionDetailsDto> getAllElectionDetails();
	public List<PrevElectionDetailsDto> getPreviousElectionDetails();
	public ElectionDetailsDto addElectionDetails(ElectionDetailsDto electionDetailsDto);
}
