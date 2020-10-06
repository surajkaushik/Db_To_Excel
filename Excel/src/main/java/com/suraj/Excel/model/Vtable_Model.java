package com.suraj.Excel.model;

import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Vtable_Model {
	
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
