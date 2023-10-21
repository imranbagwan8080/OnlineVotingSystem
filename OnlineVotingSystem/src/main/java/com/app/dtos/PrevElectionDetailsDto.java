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
public class PrevElectionDetailsDto {
	 private String nameOfElection;
	 
	 private String constituency ;
	 
	 private Date startDate;
	 
	 private Date endDate;
	 
	  private String state;
	   private String fName;
	   private String lName;
	   private long voteCount;
	   private String party;
	   
}
