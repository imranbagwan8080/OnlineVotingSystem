package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.service.ElectionDetailsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/electionDetails")

public class ElectionDetailsController {
	@Autowired
	ElectionDetailsServiceImpl electionDetailsServiceImpl;
	
	@GetMapping("/ElectionList")
	public ResponseEntity<?> getAllElectionDetails(){
		return ResponseEntity.ok(electionDetailsServiceImpl.getAllElectionDetails());
	}
	
	@GetMapping("/PrevElectionList")
	public ResponseEntity<?> getPreviousElectionDetails(){
		System.out.println("In Controller");
		return ResponseEntity.ok(electionDetailsServiceImpl.getPreviousElectionDetails());
	}
	
}
