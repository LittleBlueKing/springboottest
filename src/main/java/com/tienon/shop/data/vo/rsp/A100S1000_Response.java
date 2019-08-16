package com.tienon.shop.data.vo.rsp;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class A100S1000_Response {

	@JsonProperty("shop_list")
	private List<A100S1000_SHOP_Response> shopList;

	@Override
	public String toString() {
		return "A100S1000_Response{" +
				"shopList=" + shopList +
				'}';
	}

	public List<A100S1000_SHOP_Response> getShopList() {
		return shopList;
	}

	public void setShopList(List<A100S1000_SHOP_Response> shopList) {
		this.shopList = shopList;
	}
}
