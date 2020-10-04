package com.suraj.Excel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.suraj.Excel.model.DbModel;
import com.suraj.Excel.model.DpModel;
import com.suraj.Excel.model.ExcelModel;
import com.suraj.Excel.model.LoadModel;
import com.suraj.Excel.model.Vtable_Model;
import com.suraj.Excel.dao.ExcelDAO;


@Service(value = "ExcelService")
@Transactional
public class ExcelServiceImpl implements ExcelService {

	@Autowired
	private ExcelDAO excelDAO;
	
	@Override
	//This getAllData Function will retrieve all the ExcelModel data which is fetched by DAO.
	public List<ExcelModel> getAllData() {
		//Calling of DAO function
		return excelDAO.getAllData();
	}

	@Override
	//This getAllData Function will retrieve all the Vtable_Model data which is fetched by DAO.
	public List<Vtable_Model> getAllVTable() {
		System.out.println("Inside Function call Service");
		return excelDAO.getAllVTable();
	}

	@Override
	
	//This getAllData Function will retrieve all the DbModel data which is fetched by DAO.
	public List<DbModel> getAllDb() {
		return excelDAO.getAllDb();
	}

	@Override
	//This getAllData Function will retrieve all the DpModel data which is fetched by DAO.
	public List<DpModel> getAllDp() {
		return excelDAO.getAllDp();
	}

	@Override
	//This getAllData Function will retrieve all the LoadModel data which is fetched by DAO.
	public List<LoadModel> getAllLoad() {
		return excelDAO.getAllLoad();
	}

}
