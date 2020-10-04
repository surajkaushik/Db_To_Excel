package com.suraj.Excel.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="load")
//Used To interact with Database.
public class Load {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer load_id;
	private LocalDate datee;
	private Integer load_trk;
	private Integer load_trk_off;
	public Integer getLoad_id() {
		return load_id;
	}
	public void setLoad_id(Integer load_id) {
		this.load_id = load_id;
	}
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
