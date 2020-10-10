package com.quanly.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "datlich")

public class Dsdkkcb {
	@Id
	@Column(name = "id_DL")
	private String id_DL;

	@Column(name = "HoTen")
	private String hoten;

	@Column(name = "SDT")
	private String sdt;

	@Column(name = "Email")
	private String email;

	@Column(name = "CMND")
	private String cmnd;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NgayDK")
	private Date ngaydk;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	@Column(name = "NgayKham")
	private Date ngaykham;

	@Column(name = "id_TK")
	private String id_TK;

	public Dsdkkcb(String id_DL, String hoten, String sdt, String email, String cmnd, Date ngaydk, Date ngaykham,
			String id_TK) {
		super();
		this.id_DL = id_DL;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.cmnd = cmnd;
		this.ngaydk = ngaydk;
		this.ngaykham = ngaykham;
		this.id_TK = id_TK;
	}

	public Dsdkkcb() {
		
	}

	public String getId_DL() {
		return id_DL;
	}

	public void setId_DL(String id_DL) {
		this.id_DL = id_DL;
	}

	public String getHoten() {
		return hoten;
	}

	public void setHoten(String hoten) {
		this.hoten = hoten;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCmnd() {
		return cmnd;
	}

	public void setCmnd(String cmnd) {
		this.cmnd = cmnd;
	}

	public Date getNgaydk() {
		return ngaydk;
	}

	public void setNgaydk(Date ngaydk) {
		this.ngaydk = ngaydk;
	}

	public Date getNgaykham() {
		return ngaykham;
	}

	public void setNgaykham(Date ngaykham) {
		this.ngaykham = ngaykham;
	}

	public String getId_TK() {
		return id_TK;
	}

	public void setId_TK(String id_TK) {
		this.id_TK = id_TK;
	}
	
	

}
