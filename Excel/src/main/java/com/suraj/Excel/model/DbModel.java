package com.suraj.Excel.model;

import java.time.LocalDate;

public class DbModel {
	private Integer db_id;
	private LocalDate datee;
	private Integer db_cnt;
	private Integer db_sum;
	public Integer getDb_id() {
		return db_id;
	}
	public void setDb_id(Integer db_id) {
		this.db_id = db_id;
	}
	public LocalDate getDatee() {
		return datee;
	}
	public void setDatee(LocalDate datee) {
		this.datee = datee;
	}
	public Integer getDb_cnt() {
		return db_cnt;
	}
	public void setDb_cnt(Integer db_cnt) {
		this.db_cnt = db_cnt;
	}
	public Integer getDb_sum() {
		return db_sum;
	}
	public void setDb_sum(Integer db_sum) {
		this.db_sum = db_sum;
	}
	
}
