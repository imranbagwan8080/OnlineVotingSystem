package com.app.dtos;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Component
public class ElectionCandidateDto {
	long id;
	private String fName;
	private String lName;
	private String party;
	private String candidateImage;	
	private String partySymbol;
	private String gender;
	private Long voteCount;	
}
