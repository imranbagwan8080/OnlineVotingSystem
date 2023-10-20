package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
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
	
	@Column
	private Long voteCount;
	
	@ManyToOne
	@JoinColumn(name = "electionId")
	private ElectionDetails electionDetails;
	
	
	
	
	
	
	
	
	
	
	

}
