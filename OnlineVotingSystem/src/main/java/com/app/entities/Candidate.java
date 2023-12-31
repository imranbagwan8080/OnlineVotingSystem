package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "candidate")
public class Candidate extends BaseEntity{
	
	@Column(length=30)
	private String party;
	
	@Lob
	@Column(name="candidateImage")
	private String candidateImage;
	
	@Lob
	@Column(name="partySymbol")
	private String partySymbol;
	
	@Column(length=30)
	private String occupation;
	
	@Column(length=30)
	private String education;
	
	@Column(name="voteCount")
	private Long voteCount;
	
	@ManyToOne
	@JoinColumn(name = "electionDetailsId")
	private ElectionDetails electionDetails;
	
	@OneToOne
	@JoinColumn(name="electionDataId")
	private ElectionData electionData;
	
	@Column(length = 20)
	private String status;

//	public Candidate(ElectionDetails electionDetails, ElectionData electionData) {
//		this.electionDetails = electionDetails;
//		this.electionData = electionData;
//	}

	public Candidate(String party, String candidateImage, String partySymbol, String occupation, String education,
			 ElectionDetails electionDetails, ElectionData electionData, String status) {
		super();
		this.party = party;
		this.candidateImage = candidateImage;
		this.partySymbol = partySymbol;
		this.occupation = occupation;
		this.education = education;
		this.electionDetails = electionDetails;
		this.electionData = electionData;
		this.status = status;
	}
	
	
	

}
