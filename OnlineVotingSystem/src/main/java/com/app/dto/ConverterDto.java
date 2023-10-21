package com.app.dto;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.app.entities.Candidate;

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
	
}
