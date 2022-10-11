package com.example.mouri.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LectureDto {
	 private  long lectureId;
	  private String lectureName;
	  private String lectureEmail;
	  private Integer phoneNumber;
	  private String department;
}
