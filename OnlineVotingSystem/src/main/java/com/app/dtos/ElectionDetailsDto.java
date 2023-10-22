package com.app.dtos;

import java.util.Date;
import java.util.List;

import com.app.entities.ElectionData;
import com.app.entities.ElectionDetails;

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
public class ElectionDetailsDto {
         long id;
		 private String nameOfElection;
		 
		 private String constituency ;
		 
		 private Date startDate;
		 
		 private Date endDate;
		 
		  private String state;

		
}
