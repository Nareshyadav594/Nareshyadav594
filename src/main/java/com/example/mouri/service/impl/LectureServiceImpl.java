package com.example.mouri.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mouri.Exception.Exception;
import com.example.mouri.dto.LectureDto;
import com.example.mouri.entity.Lecture;
import com.example.mouri.mappers.LectureMappers;
import com.example.mouri.repository.LectureRepository;
import com.example.mouri.service.LectureService;
@Service
public class LectureServiceImpl implements LectureService {
	@Autowired
	private LectureMappers mappers;
	
	@Autowired
	private LectureRepository  lectureRepository;


	@Override
	public LectureDto saveLecture(LectureDto lectureDto) {
		Lecture lecture= mappers.entityToDto(lectureDto);
		lectureRepository.save(lecture);
		
		return mappers.dtoToEntity(lecture);
	}

	@Override
	public List<LectureDto> getAllLectures() {
		List<Lecture> dtos = lectureRepository.findAll();
		return dtos.stream().map(map->mappers.dtoToEntity(map))
				                            .collect(Collectors.toList());
	}

	@Override
	public LectureDto getUserDetailByLectureId(long id) {
		Lecture lecture = lectureRepository.findById(id).
				orElseThrow(()-> new Exception("Lacture", "lacture", id));
		return mappers.dtoToEntity(lecture);
	}

	@Override
	public LectureDto updateLectureDetails(LectureDto lectureDto, long id) {
		Lecture lecture = lectureRepository.findById(id).
				orElseThrow(()-> new Exception("Lacture", "lacture", id));
		lecture.setLectureName(lectureDto.getLectureName());
		lecture.setDepartment(lectureDto.getDepartment());
		lecture.setPhoneNumber(lectureDto.getPhoneNumber());
		lecture.setLectureEmail(lectureDto.getLectureEmail());
		lecture.setDepartment(lectureDto.getDepartment());
		Lecture updateLecture  = lectureRepository.save(lecture);
		return mappers.dtoToEntity(updateLecture);
		
	}

	@Override
	public void deleteLectureDetails(long id) {
	 lectureRepository.findById(id).
				orElseThrow(()-> new Exception("Lacture", "lacture", id));
		lectureRepository.deleteById(id);
	}

}
