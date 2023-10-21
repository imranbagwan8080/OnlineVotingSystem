package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CandidateDto;
import com.app.dto.ConverterDto;
import com.app.entities.Candidate;
import com.app.service.CandidateService;
import com.app.service.StorageService;

@RestController
@RequestMapping("/candidate")
@CrossOrigin(origins = {"*"})
public class CandidateController {

	
	@Autowired
	public CandidateService candidateServ;
	
	@Autowired
	public ConverterDto converter;
	
	@Autowired 
	public StorageService storageService;
	
	
	@PostMapping("/register")
	public Candidate registerCandidate(CandidateDto candidateDto) {
		
		Candidate cand = converter.candDtotoEntity(candidateDto);
		String thumbnailCand = storageService.store(candidateDto.getCandidateImage());
		String thumbnailParty = storageService.store(candidateDto.getPartySymbol());
		
		return candidateServ.registerCandidate(cand);  
	}
	
	
}
