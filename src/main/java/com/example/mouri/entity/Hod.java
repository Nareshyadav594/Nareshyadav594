package com.example.mouri.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Hod {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	  private  long hodId;
	  private String hodName;
	  private String hodEmail;
	  private Integer phoneNumber;
	  private String department;
}
