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

import com.example.mouri.dto.LectureDto;
import com.example.mouri.service.LectureService;

@RestController
@RequestMapping("/api/Lecture")
public class LectureController {

	@Autowired
	private LectureService service;

	@PostMapping
	public ResponseEntity<LectureDto> createLecture(@RequestBody LectureDto dto) {
		return new ResponseEntity<LectureDto>(service.saveLecture(dto), HttpStatus.CREATED);

	}

	@GetMapping()
	public List<LectureDto> getAllLectures() {
		return service.getAllLectures();
	}

	@GetMapping("{id}")
	public ResponseEntity<LectureDto> getDetailById(@PathVariable("id") long id) {
		LectureDto lectureDto = service.getUserDetailByLectureId(id);
		return new ResponseEntity<LectureDto>(lectureDto, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<LectureDto> updatedetails(@RequestBody LectureDto lectureDto, @PathVariable("id") long id) {
		LectureDto UpdateUserLecture = service.updateLectureDetails(lectureDto, id);
		return new ResponseEntity<LectureDto>(UpdateUserLecture, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteValue(@PathVariable("id") long id) {
		service.deleteLectureDetails(id);
		return new ResponseEntity<String>("Lecture Details Successfully Deleted", HttpStatus.OK);
	}
}
