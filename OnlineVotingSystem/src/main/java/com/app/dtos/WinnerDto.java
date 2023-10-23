package com.app.dtos;

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
public class WinnerDto {
	
	private String fname;
	
	private String lname;
	
	private String party;
	
	private String constituency;
	
	private long voteCount;

}
