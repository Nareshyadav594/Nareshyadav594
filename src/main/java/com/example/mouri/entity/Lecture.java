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
public class Lecture {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private  long lectureId;
	  private String lectureName;
	  private String lectureEmail;
	  private Integer phoneNumber;
	  private String department;
}
