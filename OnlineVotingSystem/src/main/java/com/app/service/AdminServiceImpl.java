package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.dao.AdminDataDao;
import com.app.dao.CandidateDao;
import com.app.dao.ElectionDataDao;
import com.app.dao.ElectionDetailsDao;
import com.app.dtos.WinnerDto;
import com.app.entities.AdminData;
import com.app.entities.Candidate;
import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;

@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private AdminDataDao adminDataDao;

	@Autowired
	private CandidateDao candidateDao;

	@Autowired
	private ElectionDetailsService electioDetailsService;

	@Autowired
	private ElectionDetailsDao electionDetailsDao;

	@Autowired
	private ElectionDataDao electionDataDao;

	@Override
	public AdminData adminSignInService(AdminData adminData) {
		AdminData adminDatas = adminDataDao.findByAdminId(adminData.getAdminId());
		if (adminData.getAdminId().equals(adminDatas.getAdminId())
				&& adminData.getPassword().equals(adminDatas.getPassword())) {
			return adminDatas;
		}
		return null;
	}

	public WinnerDto getResult(long electionId) {
		// TODO Auto-generated method stub
		List<Candidate> list = candidateDao.findByElectionDetailsId(electionId);

		long max = 0, candidateID = 0;
		int i = 0;
		Candidate candidate = new Candidate();
		for (Candidate c : list) {
			if (c.getVoteCount() > max) {
				max = c.getVoteCount();
				candidateID = c.getId();
				candidate = c;

			}

		}

		System.out.println("after for loop " + candidateID);
		Optional<ElectionDetails> electionDetails = electioDetailsService.findElectionDetails(electionId);

		System.out.println(candidateID);

		if (electionDetails != null) {
			System.out.println(candidateID);
			// electionDetails.get().setWinnerVoterId(candidateID);
			electionDetailsDao.updateField(candidateID, electionId);

		}

		ElectionData electionData = electionDataDao.findById(candidate.getElectionData().getId());

		WinnerDto winnerDto = new WinnerDto();
		System.out.println(electionData.getFName());

		winnerDto.setFname(electionData.getFName());
		winnerDto.setLname(electionData.getLName());
		winnerDto.setParty(candidate.getParty());
		winnerDto.setConstituency(electionDetails.get().getConstituency());
		winnerDto.setVoteCount(candidate.getVoteCount());

		return winnerDto;

	}

}
