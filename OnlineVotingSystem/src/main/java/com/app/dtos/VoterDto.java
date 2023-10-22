package com.app.dtos;

import java.util.Date;

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
public class VoterDto {
	 
	 private String fName;
     
    
	 private String lName;
     
   
	 private String voterId;
     
    
	 private String aadharNo;
     
     
	 private String constituency ;
     
    
	 private String gender;
     
    
	 private String mobile;
     
    
	 private Date dob;
     
    
     private String state;
     
     
	 private String status;
}
