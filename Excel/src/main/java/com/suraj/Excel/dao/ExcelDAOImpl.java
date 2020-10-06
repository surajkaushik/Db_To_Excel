package com.suraj.Excel.dao;

import java.time.LocalDate;
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
		Query q=entityManager.createQuery("SELECT t1.datee,t1.v_count,t1.v_sum,t2.db_cnt,t2.db_sum,t3.dp_count,t3.dp_sum,t4.load_trk,t4.load_trk_off FROM Vtable t1 inner join Db t2 on t1.datee=t2.datee INNER JOIN Dp t3 ON t2.datee=t3.datee INNER JOIN Load t4 ON t3.datee=t4.datee where t1.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate)");
		//Storing the fetching Entity results in ReceviedList
		System.out.println("Query Excuted");
		List<Object[]> receivedList=q.getResultList();
		
		System.out.println("After Getting data in the list");
		//Iterating over the Entity(receivedList) and converting it to model
		
		for (Object[] excelEntity : receivedList) {
			//Object as Model class is created
			ExcelModel excel = new ExcelModel();
	
			//Setting data in model class from Entity Class
			excel.setDatee((LocalDate)excelEntity[0]);
			excel.setDb_cnt((Integer)excelEntity[3]);
			excel.setDb_sum((Integer)excelEntity[4]);
			excel.setDp_count((Integer)excelEntity[5]);
			excel.setDp_sum((Integer)excelEntity[6]);
			excel.setLoad_trk((Integer)excelEntity[7]);
			excel.setLoad_trk_off((Integer)excelEntity[8]);
			excel.setV_count((Integer)excelEntity[1]);
			excel.setV_sum((Integer)excelEntity[2]);
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
		Query q=entityManager.createQuery("SELECT v FROM Vtable v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate) ORDER BY v.datee ASC");
		//System.out.println("After Query in dAO");
		List<Vtable> receivedList=q.getResultList();
		for (Vtable vtable : receivedList) {
			Vtable_Model v=new Vtable_Model();
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
		Query q=entityManager.createQuery("SELECT v FROM Db v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate) ORDER BY v.datee ASC");
		//System.out.println("After Query in dAO");
		List<Db> receivedList=q.getResultList();
		for (Db db : receivedList) {
			DbModel dbmodel=new DbModel();
			dbmodel.setDatee(db.getDatee());
			dbmodel.setDb_cnt(db.getDb_cnt());
			dbmodel.setDb_sum(db.getDb_sum());
			listOfData.add(dbmodel);
		}
		return listOfData;
	}

	@Override
	public List<DpModel> getAllDp() {
		List<DpModel> listOfData= new ArrayList<DpModel>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Dp v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate) ORDER BY v.datee ASC");
		//System.out.println("After Query in dAO");
		List<Dp> receivedList=q.getResultList();
		for (Dp dp : receivedList) {
			DpModel dpmodel=new DpModel();
			dpmodel.setDatee(dp.getDatee());
			dpmodel.setDp_count(dp.getDp_count());
			dpmodel.setDp_sum(dp.getDp_sum());
			listOfData.add(dpmodel);
		}
		return listOfData;
	}

	@Override
	public List<LoadModel> getAllLoad() {
		List<LoadModel> listOfData= new ArrayList<LoadModel>();
		//System.out.println("Inside Dao");
		Query q=entityManager.createQuery("SELECT v FROM Load v where v.datee BETWEEN trunc(sysdate-7) AND trunc(sysdate) ORDER BY v.datee ASC");
		//System.out.println("After Query in dAO");
		List<Load> receivedList=q.getResultList();
		for (Load load : receivedList) {
			LoadModel loadmodel=new LoadModel();
			loadmodel.setDatee(load.getDatee());
			loadmodel.setLoad_trk(load.getLoad_trk());
			loadmodel.setLoad_trk_off(load.getLoad_trk_off());
			listOfData.add(loadmodel);
		}
		return listOfData;
	}

}
