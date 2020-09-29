package com.suraj.Excel.api;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
import com.suraj.userExcelExporter.UserExcelExporter;

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
	
	@GetMapping("/users/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<ExcelModel> excelData = service.getAllData();
         
        UserExcelExporter excelExporter = new UserExcelExporter(excelData);
         
        excelExporter.export(response);    
    }  
}
