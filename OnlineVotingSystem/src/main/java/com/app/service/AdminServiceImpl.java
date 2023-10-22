package com.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.app.dao.AdminDataDao;
import com.app.entities.AdminData;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
	private AdminDataDao adminDataDao;

	@Override
	public AdminData adminSignInService(AdminData adminData) {
	    AdminData adminDatas = adminDataDao.findByAdminId(adminData.getAdminId());
	    if(adminData.getAdminId().equals(adminDatas.getAdminId()) && adminData.getPassword().equals(adminDatas.getPassword())) {
	    	 return adminDatas;
	    }
	    return null;
	}
	
	

}
