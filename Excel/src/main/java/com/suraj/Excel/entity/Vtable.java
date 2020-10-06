package com.suraj.Excel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="vtable")
//Used To interact with Database.
public class Vtable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private LocalDate datee;
	private Integer v_count;
	private Integer v_sum;
	
	public LocalDate getDatee() {
		return datee;
	}
	public void setDatee(LocalDate datee) {
		this.datee = datee;
	}
	public Integer getV_count() {
		return v_count;
	}
	public void setV_count(Integer v_count) {
		this.v_count = v_count;
	}
	public Integer getV_sum() {
		return v_sum;
	}
	public void setV_sum(Integer v_sum) {
		this.v_sum = v_sum;
	}
	
	
}
