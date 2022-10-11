package com.example.mouri.mappers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.mouri.dto.HodDto;
import com.example.mouri.entity.Hod;

@Component
public class HodMappers {
	@Autowired
	private ModelMapper mapper;

	public Hod entityToDto(HodDto dto) {
		Hod hod = mapper.map(dto, Hod.class);
		return hod;
	}

	public HodDto dtoToEntity(Hod hod) {
		HodDto dto = mapper.map(hod, HodDto.class);
		return dto;
	}
	}