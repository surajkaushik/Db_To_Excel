package com.suraj.Excel.service;

import java.util.List;

import com.suraj.Excel.model.ExcelModel;


public interface ExcelService {
	public List<ExcelModel> getAllData() throws Exception;
}
