package com.example.mouri.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.mouri.Exception.Exception;
import com.example.mouri.dto.HodDto;
import com.example.mouri.entity.Hod;
import com.example.mouri.mappers.HodMappers;
import com.example.mouri.repository.HodRepository;
import com.example.mouri.service.HodService;

@Service
public class HodServiceImpl implements HodService {
	@Autowired
	private HodMappers mappers;

	@Autowired
	private HodRepository hodRepository;

	@Override
	public HodDto saveHod(HodDto dto) {

		Hod hod = mappers.entityToDto(dto);
		hodRepository.save(hod);

		return mappers.dtoToEntity(hod);
	}

	@Override
	public List<HodDto> getAllHod() {
		List<Hod> hods = hodRepository.findAll();
		return hods.stream().map(map -> mappers.dtoToEntity(map)).collect(Collectors.toList());
	}

	@Override
	public HodDto getHodDetailByHodId(long id) {
		Hod hod = hodRepository.findById(id).orElseThrow(()-> new Exception("Hod", "hod", id));
		return mappers.dtoToEntity(hod);
	}

	@Override
	public HodDto updateHodDetails(HodDto hodDto, long id) {
		Hod hod = hodRepository.findById(id).orElseThrow(()-> new Exception("Hod", "hod", id));
		hod.setHodName(hodDto.getHodName());
		hod.setHodEmail(hodDto.getHodEmail());
		hod.setPhoneNumber(hodDto.getPhoneNumber());
		hod.setDepartment(hodDto.getDepartment());
		Hod updateHod = hodRepository.save(hod);
		return mappers.dtoToEntity(updateHod);
	}

	@Override
	public void deleteHodDetails(long id) {
		 hodRepository.findById(id).orElseThrow(()-> new Exception("Hod", "hod", id));

		hodRepository.deleteById(id);

	}

}
