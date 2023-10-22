package com.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.customException.ResourceNotFoundException;
import com.app.dao.CandidateDao;
import com.app.dao.ElectionDataDao;
import com.app.dao.ElectionDetailsDao;
import com.app.dtos.VotingforCandidateDto;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	public CandidateDao candidateDao;
	
	@Autowired
	public  ElectionDataDao electionDataDao;
	
	@Autowired
	public ElectionDetailsDao electionDetailsDao;

	@Override
	public String registerCandidate(Candidate candidate) {
		System.out.println("Candidate service");
		
		 candidateDao.save(candidate);
		 return "Save Successfully";
	}


	@Override
	public List<VotingforCandidateDto> getCandidateDetails(VotingforCandidateDto electionVoterId) {
		ElectionData ed = electionDataDao.findByVoterId(electionVoterId.getVoterId());
		
//		System.out.println(ed.getVoterId().equals(electionVoterId.getVoterId()));
//		System.out.println(electionVoterId.getVoterId());
//		System.out.println(electionVoterId.getElectionDataId());
		
		ElectionDetails edt = electionDetailsDao.findById(electionVoterId.getElectionDataId()).orElseThrow();
		
		
		List<Candidate> cd= edt.getCandidates();
		
		List<Candidate> list = new ArrayList<Candidate>();
		
		
		for(Candidate cdt : cd)
		{
//			System.out.println(cdt.getCandidateImage());
			
			if(cdt.getElectionData().getConstituency().equals(ed.getConstituency()) && cdt.getStatus().equals("verified"))
			{
				list.add(cdt);
			}
		}
		
		List<VotingforCandidateDto> vcd = new ArrayList<VotingforCandidateDto>();
		for(Candidate l : list)
		{
//			System.out.println(l.getElectionData().getFName());
			VotingforCandidateDto vc = new VotingforCandidateDto(l.getElectionData().getFName(),l.getElectionData().getLName(),l.getParty(),l.getCandidateImage(),l.getPartySymbol());
//			System.out.println(vc.getCandidateImage() +" ,"+ vc.getFName());
			vcd.add(vc);
		}
		return vcd;
	}
	


}
