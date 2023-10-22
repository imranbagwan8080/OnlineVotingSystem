package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CandidateDao;
import com.app.dao.ElectionDataDao;
import com.app.dao.VoterDao;
import com.app.dtos.VoterDto;
import com.app.dtos.VoterIdCandidateId;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.Voter;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class VoterServiceImpl implements VoterService {
	
	@Autowired
	private VoterDao voterdao;
	
	@Autowired
	private ElectionDataDao electionDataDao;
	
	@Autowired
	private CandidateDao candidateDao;
	
	
	

	@Override
	public String registerVoterService(Voter voter) {
		// TODO Auto-generated method stub
		ElectionData electionData =  electionDataDao.findByVoterId(voter.getVoterId());
		if(electionData !=null) {
			voterdao.save(voter);
			return "Voter Registered Succesfully";
		}
		else {
			return null;
		}
		
	}




	@Override
	public Voter login(String vId, String pass) {
		// TODO Auto-generated method stub
		Voter v1 = voterdao.findByVoterIdAndPassword(vId, pass);
		if(v1!=null) {
			return v1;
		}else {
			return null;
		}
	}




	@Override
	public String votForCandidates(VoterIdCandidateId vIdcId) {
		Voter voter = voterdao.findByVoterId(vIdcId.getVoterId());
    	ElectionData electionData = electionDataDao.findByVoterId(vIdcId.getVoterId());
		Candidate candidate = candidateDao.findById(vIdcId.getCandidateId());
		
		if( voter.getStatus() == null &&  candidate.getElectionData().getConstituency().equals(electionData.getConstituency())) {
			  voter.setStatus("voted");
			  candidate.setVoteCount(candidate.getVoteCount()+1);
			  return "voter voted successfully";
		}
		return null;
	}




	@Override
	public VoterDto getVoterDetails(String voterId) {
		System.out.println(voterId);
		ElectionData electionData = electionDataDao.findByVoterId(voterId);
		System.out.println(electionData.toString());
		
		Voter voter = voterdao.findByVoterId(voterId);
		
		VoterDto voterDto = new VoterDto();
		voterDto.setAadharNo(electionData.getAadharNo());
		voterDto.setConstituency(electionData.getConstituency());
		voterDto.setDob(electionData.getDob());
		voterDto.setFName(electionData.getFName());
		voterDto.setGender(electionData.getGender());
		voterDto.setLName(electionData.getLName());
		voterDto.setMobile(electionData.getMobile());
		voterDto.setState(electionData.getState());
		voterDto.setStatus(voter.getStatus());
		voterDto.setVoterId(electionData.getVoterId());
		return voterDto;
	}

}
