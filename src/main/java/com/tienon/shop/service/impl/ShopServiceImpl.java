package com.tienon.shop.service.impl;

import com.tienon.shop.data.domain.Shop;
import com.tienon.shop.data.vo.rsp.A100S1000_SHOP_Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.tienon.shop.data.mapper.ShopMapper;
import com.tienon.shop.data.vo.req.A100S1000_Request;
import com.tienon.shop.data.vo.rsp.A100S1000_Response;
import com.tienon.shop.service.inf.ShopService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ShopServiceImpl implements ShopService {

	@Autowired
	private ShopMapper shopMapper;

	@Autowired
	private RedisTemplate redisTemplate;

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
		//redis缓存的key
		String key = "shop_" + id;

		ValueOperations<String,Shop> operations = redisTemplate.opsForValue();
		//判断是否有缓存
		boolean hasKey = redisTemplate.hasKey(key);
		if(hasKey){
			long start = System.currentTimeMillis();
			Shop shop = operations.get(key);
			System.out.println("从缓存中取得数据。。。");
			long end = System.currentTimeMillis();
			System.out.println("查询redis花费的时间是:" + (end - start)+"ms");
			return shop;
		}else{
			long start = System.currentTimeMillis();
			Shop shop = shopMapper.getShopDtlById(id);
			System.out.println("从数据库中取得数据。。。");
			//写入缓存
			operations.set(key,shop,5,TimeUnit.HOURS);
			long end = System.currentTimeMillis();
			System.out.println("查询mysql花费的时间是:" + (end - start)+"ms");
			return shop;
		}
	}

}
