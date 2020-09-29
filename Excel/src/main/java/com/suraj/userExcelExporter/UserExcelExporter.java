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
	private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ExcelModel> excelData;
    
    public UserExcelExporter(List<ExcelModel> excelData) {
		this.excelData=excelData;
		workbook = new XSSFWorkbook();
	}
    
    private void writeHeaderLine() {
    	 sheet = workbook.createSheet("UserData");
    	 Row row = sheet.createRow(0);
    	 CellStyle style = workbook.createCellStyle();
    	 XSSFFont font = workbook.createFont();
         font.setBold(true);
         font.setFontHeight(16);
         style.setFont(font);
         
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
    
    private void writeDataLines() {
        int rowCount = 1;
 
        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);
                 
        for (ExcelModel user : excelData) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;
             
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
    
    public void export(HttpServletResponse response) throws IOException {
        writeHeaderLine();
        writeDataLines();
         
        ServletOutputStream outputStream = response.getOutputStream();
        workbook.write(outputStream);
        workbook.close();
         
        outputStream.close();
         
    }
    
}
