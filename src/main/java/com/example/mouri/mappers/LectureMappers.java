package com.example.mouri.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mouri.dto.LectureDto;
import com.example.mouri.entity.Lecture;

@Component
public class LectureMappers {
	@Autowired
	private ModelMapper mapper;

	public Lecture entityToDto(LectureDto lectureDto) {
		Lecture lecture = mapper.map(lectureDto, Lecture.class);
		return lecture;
	}

	public LectureDto dtoToEntity(Lecture lecture) {
		LectureDto lectureDto = mapper.map(lecture, LectureDto.class);
		return lectureDto;
	}
	}