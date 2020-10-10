package com.quanly.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="nhathuoc")
public class Nhathuoc {

	@Id
	private String id_NT;
	private String tencoso;
	private String diachi;
	private String gps;
		
	public Nhathuoc() {
		
	}
	
	public Nhathuoc(String id_NT, String tencoso, String diachi, String gps) {
		super();
		this.id_NT = id_NT;
		this.tencoso = tencoso;
		this.diachi = diachi;
		this.gps = gps;
	}


	public String getId_NT() {
		return id_NT;
	}
	public void setId_NT(String id_NT) {
		this.id_NT = id_NT;
	}
	public String getTencoso() {
		return tencoso;
	}
	public void setTencoso(String tencoso) {
		this.tencoso = tencoso;
	}
	public String getDiachi() {
		return diachi;
	}
	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}
}
