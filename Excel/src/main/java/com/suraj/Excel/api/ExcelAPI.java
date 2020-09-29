package com.suraj.Excel.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.suraj.Excel.model.ExcelModel;
import com.suraj.Excel.service.ExcelService;

@CrossOrigin
@RestController
@RequestMapping("ExcelAPI")
public class ExcelAPI {

	@Autowired
	private ExcelService service;
	
	@Autowired
	private Environment environment;
	
	@GetMapping(value = "/getAllData")
	public ResponseEntity<List<ExcelModel>> getAllData() throws Exception{
		try {
		List<ExcelModel> allData=service.getAllData();
		return new ResponseEntity<List<ExcelModel>>(allData, HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
}
