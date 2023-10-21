package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.AdminData;

public interface AdminDataDao extends JpaRepository<AdminData, Long> {

	public AdminData findByAdminId(String adminId);

}
