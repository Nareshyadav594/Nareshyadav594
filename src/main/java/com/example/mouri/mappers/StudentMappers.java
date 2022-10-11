package com.example.mouri.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mouri.dto.StudentDto;
import com.example.mouri.entity.Student;

@Component
public class StudentMappers {
	@Autowired
	private ModelMapper mapper;

	public Student entityToDto(StudentDto studentDto) {
		Student student = mapper.map(studentDto, Student.class);
		return student;
	}

	public StudentDto dtoToEntity(Student student) {
		StudentDto studentDto = mapper.map(student, StudentDto.class);
		return studentDto;
	}
	}