package com.example.mouri.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mouri.dto.StudentDto;
import com.example.mouri.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping
	public ResponseEntity<StudentDto> createUser(@RequestBody StudentDto dto) {
		return new ResponseEntity<StudentDto>(service.saveStudent(dto), HttpStatus.CREATED);

	}

	@GetMapping()
	public List<StudentDto> getAllUsers() {
		return service.getAllStudents();
	}

	@GetMapping("{id}")
	public ResponseEntity<StudentDto> getDetailById(@PathVariable("id") long id) {
		StudentDto studentDto = service.getStudentDetailByStudentId(id);
		return new ResponseEntity<StudentDto>(studentDto, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<StudentDto> updatedetails(@RequestBody StudentDto studentDto, @PathVariable("id") long id) {
		StudentDto UpdateUserValue = service.updateStudentDetails(studentDto, id);
		return new ResponseEntity<StudentDto>(UpdateUserValue, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteValue(@PathVariable("id") long id) {
		service.deleteStudentDetails(id);
		return new ResponseEntity<String>("User Details Successfully Deleted", HttpStatus.OK);
	}
}
