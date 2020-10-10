package com.quanly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Columns;

@Entity
@Table(name="bacsi")
public class Bacsi {
	@Id
	@Column(name="id_BS")
	private String id_BS;
	
	@Column(name="HoTen")
	private String hoten;
	
	@Column(name="SDT")
	private String sdt;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="ChuyenKhoa")
	private String chuyenkhoa;
	
	@Column(name="TrangThai")
	private String trangthai;
	
	@Column(name="DiaChi")
	private String diachi;
	
	@Column(name="Hinh")
	private String hinh;
	
	@Column(name="id_TK")
	private String id_TK;
	
	public Bacsi() {
	
	}

	public Bacsi(String id_BS, String hoten, String sdt, String email, String chuyenkhoa, String trangthai,
			String diachi, String hinh, String id_TK) {
		super();
		this.id_BS = id_BS;
		this.hoten = hoten;
		this.sdt = sdt;
		this.email = email;
		this.chuyenkhoa = chuyenkhoa;
		this.trangthai = trangthai;
		this.diachi = diachi;
		this.hinh = hinh;
		this.id_TK = id_TK;
	}

	public String getId_BS() {
		return id_BS;
	}

	public void setId_BS(String id_BS) {
		this.id_BS = id_BS;
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

	public String getChuyenkhoa() {
		return chuyenkhoa;
	}

	public void setChuyenkhoa(String chuyenkhoa) {
		this.chuyenkhoa = chuyenkhoa;
	}

	public String getTrangthai() {
		return trangthai;
	}

	public void setTrangthai(String trangthai) {
		this.trangthai = trangthai;
	}

	public String getDiachi() {
		return diachi;
	}

	public void setDiachi(String diachi) {
		this.diachi = diachi;
	}

	public String getHinh() {
		return hinh;
	}

	public void setHinh(String hinh) {
		this.hinh = hinh;
	}

	public String getId_TK() {
		return id_TK;
	}

	public void setId_TK(String id_TK) {
		this.id_TK = id_TK;
	}
		
	
	
}
