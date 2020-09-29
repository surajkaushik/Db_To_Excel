package com.suraj.Excel.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.suraj.Excel.entity.ExcelEntity;
import com.suraj.Excel.model.ExcelModel;
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

}
