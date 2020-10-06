package com.suraj.Excel.model;

import java.time.LocalDate;

public class LoadModel {
	
	private LocalDate datee;
	private Integer load_trk;
	private Integer load_trk_off;

	public LocalDate getDatee() {
		return datee;
	}
	public void setDatee(LocalDate datee) {
		this.datee = datee;
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
