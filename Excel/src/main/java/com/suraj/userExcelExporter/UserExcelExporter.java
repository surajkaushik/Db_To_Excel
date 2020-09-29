package com.suraj.userExcelExporter;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import com.suraj.Excel.model.ExcelModel;

public class UserExcelExporter {
	//creating variables for Excel
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ExcelModel> excelData;
    
    //Construtor for setting Data in excelData variable.
    public UserExcelExporter(List<ExcelModel> excelData) {
		this.excelData=excelData;
		//object for workbook is created.
		workbook = new XSSFWorkbook();
	}
    
    // for the Header row in Excel file
    private void writeHeaderLine() {
    	//Assigned the worksheet name
    	 sheet = workbook.createSheet("UserData");
    	 //Created row in sheet
    	 Row row = sheet.createRow(0);
    	 CellStyle style = workbook.createCellStyle();
    	 //Set the font for the row 0 with bold and size 16
    	 XSSFFont font = workbook.createFont();
         font.setBold(true);
         font.setFontHeight(16);
         style.setFont(font);
         
         //Created all the Title for the required database in excel file
         createCell(row, 0, "Sr. No.", style);      
         createCell(row, 1, "DATE", style);       
         createCell(row, 2, "V Count", style);    
         createCell(row, 3, "V SUM ", style);
         createCell(row, 4, "DB COUNT", style);
         createCell(row, 5, "DB SUM", style);      
         createCell(row, 6, "DP COUNT", style);
         createCell(row, 7, "DP SUM", style);      
         createCell(row, 8, "LOAD TRK", style);
         createCell(row, 9, "LOAD RRK OFF", style);
   
    }
    
    //This function will create cell with the data received.
    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }
    
    //this function will write the data part in the excel sheet
    private void writeDataLines() {
    	//set the rowCOunt as 1
        int rowCount = 1;
        CellStyle style = workbook.createCellStyle();
        //Created font for the data part and gave font size as 14
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
        //Iterating over the backend data and writing it to the Excel sheet
        for (ExcelModel user : excelData) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             //Setting data for excel in each column
            createCell(row, columnCount++, user.getSrl(), style);
            createCell(row, columnCount++, user.getDatee().toString(), style);
            createCell(row, columnCount++, user.getV_count(), style);
            createCell(row, columnCount++, user.getV_sum(), style);
            createCell(row, columnCount++, user.getDb_cnt(), style);
            createCell(row, columnCount++, user.getDb_sum(), style);
            createCell(row, columnCount++, user.getDp_count(), style);
            createCell(row, columnCount++, user.getDp_sum(), style);
            createCell(row, columnCount++, user.getLoad_trk(), style);
            createCell(row, columnCount++, user.getLoad_trk_off(), style);
        }
    }
    
    //This is the main function for calling Header and Data lines.
    public void export(HttpServletResponse response) throws IOException {
    	//writeHeaderLine function invoked.
        writeHeaderLine();
        //writeDataLines function invoked.
        writeDataLines();
         //Returns a ServletOutputStream suitable for writing binary data in the response.
        //The servlet container does not encode the binary data. 
        ServletOutputStream outputStream = response.getOutputStream();
        //Data written in Excel file.
        workbook.write(outputStream);
        //Closed the excel file.
        workbook.close();
        //Closed output stream. 
        outputStream.close();
         
    }
    
}
