package com.example.mouri.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
	 private  long stdId;
	  private String StuName;
	  private String email;
	  private Integer phoneNumber;
	  private String department;
}
