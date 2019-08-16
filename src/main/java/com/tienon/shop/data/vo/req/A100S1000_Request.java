package com.tienon.shop.data.vo.req;

import com.fasterxml.jackson.annotation.JsonProperty;

public class A100S1000_Request {

	@JsonProperty("nm")
	private String nm;
	
	@JsonProperty("tm")
	private String tm;

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
		return "A100S1000_Request [nm=" + nm + ", tm=" + tm + "]";
	}
	
}
