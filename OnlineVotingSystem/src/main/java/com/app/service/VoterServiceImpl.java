package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ElectionDataDao;
import com.app.dao.VoterDao;
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

}
