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

	

}
