package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.ElectionData;
import com.app.service.ElectionDataService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/electionData")
public class ElectionDataController {
	
	@Autowired
	private ElectionDataService eData;
	
	@PostMapping("/addVoterData")
	public String addVoterData(@RequestBody ElectionData data) {
		
		ElectionData d=null;
		
		d = eData.add(data);
		if(d!=null) {
			return "Voter Data Added Succesfully";
		}else {
			return "Something Went Wrong";
		}
		
		
		
	}
	

}
