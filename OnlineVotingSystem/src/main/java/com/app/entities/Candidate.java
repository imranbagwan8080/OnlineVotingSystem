package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
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
@Entity
@Table(name = "candidate")
public class Candidate extends BaseEntity{
	@Column(length=30,nullable=false)
	private String fname;
	
	@Column(length=30,nullable=false)
	private String lname;
	
	@Column(length=30,nullable=false)
	private int voterId;
	
	@Column(length=30,nullable=false)
	private String aadharNo;
	
	@Column(nullable=false)
	private int age;
	
	@Column(length=30,nullable=false)
	private String constituency;
	
	@Column(length=10,nullable=false)
	private String gender;
	
	@Column(length=30,nullable=false)
	private String mobile;
	
	@Column(length=30,nullable=false)
	private String password;
	
	@Column(length=30,nullable=false)
	private String party;
	
	@Lob
	@Column(length=100,nullable=false)
	private String candidateImage;
	
	@Lob
	@Column(length=100,nullable=false)
	private String partySymbol;
	
	@Column(length=30,nullable=false)
	private String occupation;
	
	@Column(length=30,nullable=false)
	private String education;
	
	@Column(nullable=false)
	private Long voteCount;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
