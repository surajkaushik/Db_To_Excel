package com.suraj.Excel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.suraj.Excel.entity.Db;
import com.suraj.Excel.entity.Dp;
import com.suraj.Excel.entity.ExcelEntity;
import com.suraj.Excel.entity.Load;
import com.suraj.Excel.entity.Vtable;
import com.suraj.Excel.model.DbModel;
import com.suraj.Excel.model.DpModel;
import com.suraj.Excel.model.ExcelModel;
import com.suraj.Excel.model.LoadModel;
import com.suraj.Excel.model.Vtable_Model;
@Repository(value ="ExcelDAO")
public class ExcelDAOImpl implements ExcelDAO{
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<ExcelModel> getAllData() {
		//creating an Empty list
		List<ExcelModel> listOfData= new ArrayList<ExcelModel>();
		//JPA query for fetching Oracle database data 
		Query q=entityManager.createQuery("SELECT p FROM ExcelEntity p");
		//Storing the fetching Entity results in ReceviedList
		List<ExcelEntity> receivedList=q.getResultList();
		//Iterating over the Entity(receivedList) and converting it to model
		for (ExcelEntity excelEntity : receivedList) {
			//Object as Model class is created
			ExcelModel excel = new ExcelModel();
			//Setting data in model class from Entity Class
			excel.setSrl(excelEntity.getSrl());
			excel.setDatee(excelEntity.getDatee());
			excel.setDb_cnt(excelEntity.getDb_cnt());
			excel.setDb_sum(excelEntity.getDb_sum());
			excel.setDp_count(excelEntity.getDp_count());
			excel.setDp_sum(excelEntity.getDp_sum());
			excel.setLoad_trk(excelEntity.getLoad_trk());
			excel.setLoad_trk_off(excelEntity.getLoad_trk_off());
			excel.setV_count(excelEntity.getV_count());
			excel.setV_sum(excelEntity.getV_sum());
			//Adding all the Model class data in the list.
			listOfData.add(excel);
		}
		//Returning the fetched data from backend.
		return listOfData;
	}
	
	@Override
	public List<Vtable_Model> getAllVTable() {
		List<Vtable_Model> listOfData= new ArrayList<Vtable_Model>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Vtable v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate)");
		//System.out.println("After Query in dAO");
		List<Vtable> receivedList=q.getResultList();
		for (Vtable vtable : receivedList) {
			Vtable_Model v=new Vtable_Model();
			v.setV_id(vtable.getV_id());
			v.setDatee(vtable.getDatee());
			v.setV_count(vtable.getV_count());
			v.setV_sum(vtable.getV_sum());
			listOfData.add(v);
		}
		//System.out.println("DAO Before Exit");
		return listOfData;
	}

	@Override
	public List<DbModel> getAllDb() {
		List<DbModel> listOfData= new ArrayList<DbModel>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Db v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate)");
		//System.out.println("After Query in dAO");
		List<Db> receivedList=q.getResultList();
		for (Db db : receivedList) {
			DbModel dbmodel=new DbModel();
			dbmodel.setDatee(db.getDatee());
			dbmodel.setDb_cnt(db.getDb_cnt());
			dbmodel.setDb_id(db.getDb_id());
			dbmodel.setDb_sum(db.getDb_sum());
			listOfData.add(dbmodel);
		}
		return listOfData;
	}

	@Override
	public List<DpModel> getAllDp() {
		List<DpModel> listOfData= new ArrayList<DpModel>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Dp v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate)");
		//System.out.println("After Query in dAO");
		List<Dp> receivedList=q.getResultList();
		for (Dp dp : receivedList) {
			DpModel dpmodel=new DpModel();
			dpmodel.setDatee(dp.getDatee());
			dpmodel.setDp_count(dp.getDp_count());
			dpmodel.setDp_id(dp.getDp_id());
			dpmodel.setDp_sum(dp.getDp_sum());
			listOfData.add(dpmodel);
		}
		return listOfData;
	}

	@Override
	public List<LoadModel> getAllLoad() {
		List<LoadModel> listOfData= new ArrayList<LoadModel>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Load v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate)");
		//System.out.println("After Query in dAO");
		List<Load> receivedList=q.getResultList();
		for (Load load : receivedList) {
			LoadModel loadmodel=new LoadModel();
			loadmodel.setDatee(load.getDatee());
			loadmodel.setLoad_id(load.getLoad_id());
			loadmodel.setLoad_trk(load.getLoad_trk());
			loadmodel.setLoad_trk_off(load.getLoad_trk_off());
			listOfData.add(loadmodel);
		}
		return listOfData;
	}

}
