package com.app.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "voter")
public class Voter extends BaseEntity{
     
     @Column(length = 20 )
	 private String voterId;
     
     @Column(length = 15 )
	 private String mobile;
     
     @Column(length = 20 )
	 private String password;
     
     @Column(length = 15 )
	 private String status;
     
     @OneToOne
     private ElectionData electionData;
     
     
}
