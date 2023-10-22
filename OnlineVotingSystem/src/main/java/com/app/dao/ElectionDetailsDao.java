package com.app.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.ElectionDetails;

public interface ElectionDetailsDao extends JpaRepository<ElectionDetails, Long> {
ElectionDetails findByEndDate(Date endDate);
List<ElectionDetails> findAll();
List<ElectionDetails> findByConstituency(String constituency);
ElectionDetails findById(long id);
}
