package com.suraj.Excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suraj.Excel.model.ExcelModel;
import com.suraj.Excel.dao.ExcelDAO;


@Service(value = "ExcelService")
@Transactional
public class ExcelServiceImpl implements ExcelService {

	@Autowired
	private ExcelDAO excelDAO;
	
	@Override
	public List<ExcelModel> getAllData() throws Exception {
		return excelDAO.getAllData();
	}

}
