package com.suraj.Excel.model;

import java.time.LocalDate;

//Used To interact with java classes.
public class ExcelModel {
	private Integer srl;
	private LocalDate Datee;
	private Integer v_count;
	private Integer v_sum;
	private Integer db_cnt;
	private Integer db_sum;
	private Integer dp_count;
	private Integer dp_sum;
	private Integer load_trk;
	private Integer load_trk_off;
	public Integer getSrl() {
		return srl;
	}
	public void setSrl(Integer srl) {
		this.srl = srl;
	}
	
	public LocalDate getDatee() {
		return Datee;
	}
	public void setDatee(LocalDate datee) {
		Datee = datee;
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
	public Integer getLoad_trk() {
		return load_trk;
	}
	public void setLoad_trk(Integer load_trk) {
		this.load_trk = load_trk;
	}
	public Integer getLoad_trk_off() {
		return load_trk_off;
	}
	public void setLoad_trk_off(Integer load_trk_off) {
		this.load_trk_off = load_trk_off;
	}
	
	
	
}
