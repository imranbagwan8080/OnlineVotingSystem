package com.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.customException.ResourceNotFoundException;
import com.app.dao.CandidateDao;
import com.app.dao.ElectionDataDao;
import com.app.dao.ElectionDetailsDao;
import com.app.dtos.ElectionDetailsDto;
import com.app.dtos.PrevElectionDetailsDto;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;

@Service
@Transactional
public class ElectionDetailsServiceImpl implements ElectionDetailsService {
@Autowired
ElectionDetailsDao electionDetailsDao;
@Autowired
CandidateDao candidateDao;
@Autowired
ElectionDataDao electionDataDao;

public List<ElectionDetailsDto> getAllElectionDetails(){
	List<ElectionDetails> list=electionDetailsDao.findAll();
	List<ElectionDetailsDto> list2=new LinkedList<ElectionDetailsDto>();
	for(ElectionDetails e:list) {
		ElectionDetailsDto obj=new ElectionDetailsDto(e.getNameOfElection(), e.getConstituency(), e.getStartDate(), e.getEndDate(), e.getState());
	list2.add(obj);
	}
	return list2;
}

public List<PrevElectionDetailsDto> getPreviousElectionDetails() {
	// TODO Auto-generated method stub
	Date d=new Date();
	System.out.println(d);
	List<ElectionDetails> list=electionDetailsDao.findAll();
	List<PrevElectionDetailsDto> list2=new LinkedList<PrevElectionDetailsDto>();
	for(ElectionDetails e:list) {
		if(e.getEndDate().compareTo(d)<0) {
			System.out.println("I am in If Statement");
			PrevElectionDetailsDto winner=new PrevElectionDetailsDto();
			List<Candidate> list3 =e.getCandidates();
			//List<Candidate> list3 =candidateDao.findByElectionDataId(e.getId());
			for(Candidate c:list3) {
				System.out.println(c.getId() +" "+e.getWinnerVoterId());
				if(c.getId()==e.getWinnerVoterId()) {
					ElectionData ed=c.getElectionData();
					System.out.println(ed.getFName());
					winner.setFName(ed.getFName());
					winner.setLName(ed.getLName());
				    winner.setVoteCount(c.getVoteCount());
				    winner.setConstituency(e.getConstituency());
				    winner.setEndDate(e.getEndDate());
				    winner.setStartDate(e.getStartDate());
				    winner.setParty(c.getParty());
				    winner.setState(e.getState());
				    winner.setNameOfElection(e.getNameOfElection());
				
				}
			}
			list2.add(winner);
		}
		
	}
	return list2;
	

}

}