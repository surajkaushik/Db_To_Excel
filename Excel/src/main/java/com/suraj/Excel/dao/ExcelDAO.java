package com.suraj.Excel.dao;

import java.util.List;

import com.suraj.Excel.model.DbModel;
import com.suraj.Excel.model.DpModel;
import com.suraj.Excel.model.ExcelModel;
import com.suraj.Excel.model.LoadModel;
import com.suraj.Excel.model.Vtable_Model;

public interface ExcelDAO {
	public List<ExcelModel> getAllData();
	public List<Vtable_Model> getAllVTable();
	public List<DbModel> getAllDb();
	public List<DpModel> getAllDp();
	public List<LoadModel> getAllLoad();
}

