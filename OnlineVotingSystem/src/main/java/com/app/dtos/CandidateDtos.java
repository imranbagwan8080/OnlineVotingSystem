package com.app.dtos;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDtos {
	private String party;
	private String candidateImage;	
	private String partySymbol;
	private String occupation;	
	private String education;	
	private Long voteCount;	
    private String fName;
    private String lName;
    private String voterId;
    private String constituency ;
    private String mobile;
    private Date dob;
	
}
