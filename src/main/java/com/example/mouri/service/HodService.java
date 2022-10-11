package com.example.mouri.service;

import java.util.List;

import com.example.mouri.dto.HodDto;

public interface HodService {
	HodDto saveHod(HodDto dto);

	List<HodDto> getAllHod();

	HodDto getHodDetailByHodId(long id);

	HodDto updateHodDetails(HodDto hodDto, long id);

	void deleteHodDetails(long id);
}
