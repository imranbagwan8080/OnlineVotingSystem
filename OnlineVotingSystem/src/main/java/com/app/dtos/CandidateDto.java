package com.app.dtos;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
//@Component
public class CandidateDto {
	
	private String party;
	private MultipartFile candidateImage;	
	private MultipartFile partySymbol;
	private String occupation;	
	private String education;	
//	private Long voteCount;	
	private Long electionDetailsID;	
	private Long electionDataID;	
//	private String status;
}
