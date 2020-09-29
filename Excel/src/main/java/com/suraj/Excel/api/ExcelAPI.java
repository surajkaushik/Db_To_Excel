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
//@RequestMapping("ExcelAPI")
public class ExcelAPI {

	@Autowired
	private ExcelService service;
	
	@Autowired
	private Environment environment;

	//URL to be used for view data on webpage: http://localhost:4444/getdata/
	@GetMapping(value = "/getdata")
	public ResponseEntity<List<ExcelModel>> getAllData() throws Exception{
		try {
		//this statement is fetching data from database using service class.
		List<ExcelModel> allData=service.getAllData();
		//this statement is returning the Database Data to the webpage.
		return new ResponseEntity<List<ExcelModel>>(allData, HttpStatus.OK);
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
		}
		
	}
	
	//URL to be used for downloading Excel file: http://localhost:4444/getdata/excel
	@GetMapping("/getdata/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        //Set date and time format for file name.
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        //Got the current Date and Timestamp.
        String currentDateTime = dateFormatter.format(new Date());
        String headerKey = "Content-Disposition";
        //Set the File name as users_ then date and time with xlsx file extension.
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
      //this statement is fetching data from database using service class.
        List<ExcelModel> excelData = service.getAllData();
        UserExcelExporter excelExporter = new UserExcelExporter(excelData);
        //Called UserExcelExporter class for downloading Excel file.
        excelExporter.export(response);    
    }  
}
