package com.app.dtos;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class VotingforCandidateDto {

	private String voterId;
	private Long electionDataId;
	
	 private String fName;
	 private String lName;
	 private String party;
	 private String candidateImage;
	 private String partySymbol;
	 
	public VotingforCandidateDto(String fName, String lName, String party, String candidateImage, String partySymbol) {
		super();
		this.fName = fName;
		this.lName = lName;
		this.party = party;
		this.candidateImage = candidateImage;
		this.partySymbol = partySymbol;
	}
	 
	 

}
