package com.app.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
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
@Table(name = "electionDetails")
public class ElectionDetails extends BaseEntity{
	
     @Column(length = 50 ,name="nameOfElection")
	 private String nameOfElection;
	 
	 @Column(length = 50 )
	 private String constituency ;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date startDate;
	 
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date endDate;
	 
	 
	  @Column(length = 50 , name = "winnerVoterId" )
	  private int winnerVoterId;
	  
	  @Column(length = 50 )
		 private String state;
	  
	  
	  @OneToMany(mappedBy = "electionDetails" , cascade = CascadeType.ALL)
	  private List<Candidate> candidates;


	public ElectionDetails(String nameOfElection, String constituency, Date startDate, Date endDate, String state) {
		super();
		this.nameOfElection = nameOfElection;
		this.constituency = constituency;
		this.startDate = startDate;
		this.endDate = endDate;
		this.state = state;
	}
	  

	
}
