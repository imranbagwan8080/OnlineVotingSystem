package com.app.entities;


import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
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
@Table(name = "electionData")
public class ElectionData extends BaseEntity{
	
	 @Column(length = 30 , name="fname")
	 private String fName;
     
     @Column(length = 30 , name="lname")
	 private String lName;
     
     @Column(length = 20 ,name="voterId")
	 private String voterId;
     
     @Column(length = 20 ,name="aadharNo")
	 private String aadharNo;
     
     @Column(length = 50 )
	 private String constituency ;
     
     @Column(length = 10 )
	 private String gender;
     
     @Column(length = 15  )
	 private String mobile;
     
     @Temporal(TemporalType.DATE)
	 private Date dob;
     
     @Column(length = 15)
     private String state;
     
     @OneToOne(mappedBy = "electionData", cascade = CascadeType.ALL)
     private Candidate candidate;
     
    
     

}
