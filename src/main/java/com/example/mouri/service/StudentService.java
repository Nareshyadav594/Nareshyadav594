package com.example.mouri.service;

import java.util.List;

import com.example.mouri.dto.StudentDto;

public interface StudentService {
	StudentDto saveStudent(StudentDto studentDto);

	List<StudentDto> getAllStudents();

	StudentDto getStudentDetailByStudentId(long id);

	StudentDto updateStudentDetails(StudentDto studentDto, long id);

	void deleteStudentDetails(long id);
}
