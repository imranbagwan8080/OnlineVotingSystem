package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dao.ElectionDataDao;
import com.app.dao.ElectionDetailsDao;
import com.app.dtos.CandidateDto;
import com.app.dtos.ConverterDto;
import com.app.dtos.VotingforCandidateDto;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;
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

	@Autowired
	public ElectionDetailsDao edtailsDao;
	
	@Autowired
	public ElectionDataDao edataDao;	
	
	
	
	@PostMapping("/register")
	public String registerCandidate(CandidateDto candidateDto) {
		
		Candidate cand = converter.candDtotoEntity(candidateDto);
		
		ElectionDetails ed = edtailsDao.findById(candidateDto.getElectionDetailsID()).orElseThrow();
		ElectionData edta = edataDao.findById(candidateDto.getElectionDataID()).orElseThrow();

		Candidate cand1 = new Candidate(candidateDto.getParty(),cand.getCandidateImage(),cand.getPartySymbol(),candidateDto.getOccupation(),candidateDto.getEducation(),ed,edta,"pending");
		
		String thumbnailCand = storageService.store(candidateDto.getCandidateImage());
		String thumbnailParty = storageService.store(candidateDto.getPartySymbol());
		
		return candidateServ.registerCandidate(cand1);  

	}
	
	
	@GetMapping("/verified")
	public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId) {
		
		List<VotingforCandidateDto> cd = candidateServ.getCandidateDetails(electionVoterId);
		
		return cd;
	}
	
	
}
