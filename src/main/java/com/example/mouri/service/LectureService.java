package com.example.mouri.service;

import java.util.List;

import com.example.mouri.dto.LectureDto;

public interface LectureService {
	LectureDto saveLecture(LectureDto lectureDto );

	List<LectureDto> getAllLectures();

	LectureDto getUserDetailByLectureId(long id);

	LectureDto updateLectureDetails(LectureDto lectureDto, long id);

	void deleteLectureDetails(long id);
}
