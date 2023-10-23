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
	
}
