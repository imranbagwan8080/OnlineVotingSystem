package com.app.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dtos.ElectionDetailsDto;
import com.app.service.ElectionDetailsServiceImpl;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/electionDetails")

public class ElectionDetailsController {
	@Autowired
	ElectionDetailsServiceImpl electionDetailsServiceImpl;
	
	//All election list (for admin/homepage)
	@GetMapping("/ElectionList")
	public ResponseEntity<?> getAllElectionDetails(){
		return ResponseEntity.ok(electionDetailsServiceImpl.getAllElectionDetails());
	}
	
	//previous election Details with winner (previous=less than current date)
	@GetMapping("/PrevElectionList")
	public ResponseEntity<?> getPreviousElectionDetails(){
		System.out.println("In Controller");
		return ResponseEntity.ok(electionDetailsServiceImpl.getPreviousElectionDetails());
	}
	//adding new Election Details without winner 
	@PostMapping("/AddNewElection")
	public ResponseEntity<?> addElectionDetails(@RequestBody ElectionDetailsDto electionDetailsDto){
		return ResponseEntity.ok(electionDetailsServiceImpl.addElectionDetails(electionDetailsDto));
	}
	
	//todays election showing for voter/admin by constituency
	@GetMapping("/TodayElection/{constituency}")
	public ResponseEntity<?> todayElectionDetails(@PathVariable("constituency") String constituency){
		return ResponseEntity.ok(electionDetailsServiceImpl.getTodayElectionDetails(constituency));
	}
	@GetMapping("/ElectionNameList")
	//distinct election only name list
	public ResponseEntity<?> getElectionNamesList(){
		return ResponseEntity.ok(electionDetailsServiceImpl.getElectionNamesList());
	}
	
	//Get Election Details by constituency for admin
	@GetMapping("/ElectionByConstituency/{constituency}")
	public ResponseEntity<?> getElectionListByConstituency(@PathVariable("constituency") String constituency){
		return ResponseEntity.ok(electionDetailsServiceImpl.getElectionDeatilsByConstituency(constituency));
	}
	//get candidates of specific election
	@GetMapping("/ElectionCandidates/{id}")
	public ResponseEntity<?> getCandidateOfElection(@PathVariable("id")long id){
		return ResponseEntity.ok(electionDetailsServiceImpl.getElectionCandidateList(id));
	}
	
}
