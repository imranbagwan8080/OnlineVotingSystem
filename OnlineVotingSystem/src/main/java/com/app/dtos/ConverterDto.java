package com.app.dtos;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.app.dao.ElectionDataDao;
import com.app.dao.ElectionDetailsDao;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;

@Component
public class ConverterDto {
	
	
	public Candidate candDtotoEntity(CandidateDto candidateDto)
	{
		Candidate candidate = new Candidate();
		
		BeanUtils.copyProperties(candidateDto, candidate, "thumbnail");
		
		if(candidateDto.getCandidateImage() != null && candidateDto.getPartySymbol()!= null)
		{
			candidate.setCandidateImage(candidateDto.getCandidateImage().getOriginalFilename());
			candidate.setPartySymbol(candidateDto.getPartySymbol().getOriginalFilename());
		
		}
		
		
			
		return candidate;
	}
	
	public CandidateDtos toCandidateDtos(Candidate c , ElectionData electionData) {
		CandidateDtos candidate = new CandidateDtos();
		candidate.setFName(electionData.getFName());
		candidate.setLName(electionData.getLName());
		candidate.setMobile(electionData.getMobile());
		candidate.setDob(electionData.getDob());
		candidate.setEducation(c.getEducation());
		candidate.setOccupation(c.getOccupation());
		candidate.setParty(c.getParty());
		candidate.setVoteCount(c.getVoteCount());
		candidate.setVoterId(electionData.getVoterId());
		candidate.setConstituency(electionData.getConstituency());
		// Image load from front end by using candidateImage name
		candidate.setCandidateImage(c.getCandidateImage());
		// Image load from front end by using partySymbole name
		candidate.setPartySymbol(c.getPartySymbol());
		
		return candidate;
	}
	
}
