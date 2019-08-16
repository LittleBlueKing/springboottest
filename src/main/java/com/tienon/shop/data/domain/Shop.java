package com.tienon.shop.data.domain;

import java.io.Serializable;

public class Shop implements Serializable {
	private Integer id;
	private String nm;
	private String tm;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNm() {
		return nm;
	}
	public void setNm(String nm) {
		this.nm = nm;
	}
	public String getTm() {
		return tm;
	}
	public void setTm(String tm) {
		this.tm = tm;
	}
	@Override
	public String toString() {
		return "Shop [id=" + id + ", nm=" + nm + ", tm=" + tm + "]";
	}
}
