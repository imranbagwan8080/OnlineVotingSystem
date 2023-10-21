package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ElectionDetails;

public interface ElectionDetailsDao extends JpaRepository<ElectionDetails, Long> {

}
