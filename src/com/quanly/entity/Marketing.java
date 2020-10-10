package com.quanly.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marketing")
public class Marketing {
	@Id
	@Column(name = "id_Mkt")
	private String id_mkt;
	@Column(name = "BanTin")
	private String bantin;
	@Column(name = "MoTa")
	private String mota;
	@Column(name = "TrangThai")
	private boolean trangthai;
	@Column(name = "id_TK")
	private String id_tk;

	public Marketing(String id_mkt, String bantin, String mota, boolean trangthai, String id_tk) {
		super();
		this.id_mkt = id_mkt;
		this.bantin = bantin;
		this.mota = mota;
		this.trangthai = trangthai;
		this.id_tk = id_tk;
	}

	public Marketing() {
		super();
	}

	public String getId_mkt() {
		return id_mkt;
	}

	public void setId_mkt(String id_mkt) {
		this.id_mkt = id_mkt;
	}

	public String getBantin() {
		return bantin;
	}

	public void setBantin(String bantin) {
		this.bantin = bantin;
	}

	public String getMota() {
		return mota;
	}

	public void setMota(String mota) {
		this.mota = mota;
	}

	public boolean isTrangthai() {
		return trangthai;
	}

	public void setTrangthai(boolean trangthai) {
		this.trangthai = trangthai;
	}

	public String getId_tk() {
		return id_tk;
	}

	public void setId_tk(String id_tk) {
		this.id_tk = id_tk;
	}

}
