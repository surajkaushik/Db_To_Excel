package com.suraj.Excel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="dp")
//Used To interact with Database.
public class Dp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dp_id;
	private LocalDate datee;
	private Integer dp_count;
	private Integer dp_sum;
	public Integer getDp_id() {
		return dp_id;
	}
	public void setDp_id(Integer dp_id) {
		this.dp_id = dp_id;
	}
	public LocalDate getDatee() {
		return datee;
	}
	public void setDatee(LocalDate datee) {
		this.datee = datee;
	}
	public Integer getDp_count() {
		return dp_count;
	}
	public void setDp_count(Integer dp_count) {
		this.dp_count = dp_count;
	}
	public Integer getDp_sum() {
		return dp_sum;
	}
	public void setDp_sum(Integer dp_sum) {
		this.dp_sum = dp_sum;
	}
	
}
