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

import com.example.mouri.dto.HodDto;
import com.example.mouri.service.HodService;

@RestController
@RequestMapping("/api/hod")
public class HodController {

	@Autowired
	private HodService service;

	@PostMapping
	public ResponseEntity<HodDto> createHod(@RequestBody HodDto dto) {
		return new ResponseEntity<HodDto>(service.saveHod(dto), HttpStatus.CREATED);

	}

	@GetMapping()
	public List<HodDto> getAllHod() {
		return service.getAllHod();
	}

	@GetMapping("{id}")
	public ResponseEntity<HodDto> getDetailById(@PathVariable("id") long id) {
		HodDto hodDto = service.getHodDetailByHodId(id);
		return new ResponseEntity<HodDto>(hodDto, HttpStatus.OK);

	}

	@PutMapping("{id}")
	public ResponseEntity<HodDto> updatedetails(@RequestBody HodDto hodDto, @PathVariable("id") long id) {
		HodDto UpdateHod = service.updateHodDetails(hodDto, id);
		return new ResponseEntity<HodDto>(UpdateHod, HttpStatus.OK);

	}

	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteValue(@PathVariable("id") long id) {
		service.deleteHodDetails(id);;
		return new ResponseEntity<String>("Hod Details Successfully Deleted", HttpStatus.OK);
	}
}
