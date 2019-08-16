package com.tienon.shop.service.impl;

import com.tienon.shop.data.domain.Shop;
import com.tienon.shop.data.vo.rsp.A100S1000_SHOP_Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tienon.shop.data.mapper.ShopMapper;
import com.tienon.shop.data.vo.req.A100S1000_Request;
import com.tienon.shop.data.vo.rsp.A100S1000_Response;
import com.tienon.shop.service.inf.ShopService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;

	@Override
	public String getShopMsg(String id) {
		System.out.println("==================" + id);
		return shopMapper.findShopById(id).toString();
	}

	@Override
	public A100S1000_Response getShopList(A100S1000_Request request) {
		A100S1000_Response response = new A100S1000_Response();
		List<A100S1000_SHOP_Response> shopList = new ArrayList<>();

		List<Shop> list = shopMapper.selectShopList(request);
		for (Shop shop:	list) {
			A100S1000_SHOP_Response rsp = new A100S1000_SHOP_Response();
			BeanUtils.copyProperties(shop,rsp);
			shopList.add(rsp);
		}
		response.setShopList(shopList);
		return response;
	}

	@Override
	public Shop getShopDtl(int id) {
		return shopMapper.getShopDtlById(id);
	}

}
