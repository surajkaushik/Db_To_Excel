package com.suraj.Excel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="db")
//Used To interact with Database.
public class Db {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDate datee;
	private Integer db_cnt;
	private Integer db_sum;
	
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
