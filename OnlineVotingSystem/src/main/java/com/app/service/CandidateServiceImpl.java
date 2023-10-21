package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CandidateDao;
import com.app.entities.Candidate;

import jakarta.transaction.Transactional;

@Transactional
@Service
public class CandidateServiceImpl implements CandidateService {
	
	@Autowired
	public CandidateDao candidateDao;
	

	@Override
	public String registerCandidate(Candidate candidate) {
		System.out.println("Candidate service");
		
		 candidateDao.save(candidate);
		 return "Save Successfully";
	}
	


}
