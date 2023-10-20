package com.app.entities;


import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	
	 @Column(length = 30 , nullable = false)
	 private String fName;
     
     @Column(length = 30 , nullable = false)
	 private String lName;
     
     @Column(length = 20 , nullable = false)
	 private String voterId;
     
     @Column(length = 20 , nullable = false)
	 private String aadharNo;
     
     @Column(length = 50 , nullable = false)
	 private String constituency ;
     
     @Column(length = 10 , nullable = false)
	 private String gender;
     
     @Column(length = 15 , nullable = false )
	 private String mobile;
     
     @Temporal(TemporalType.DATE)
	 private Date dob;
     
     
     
     

}
