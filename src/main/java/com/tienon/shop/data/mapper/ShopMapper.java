package com.tienon.shop.data.mapper;

import com.tienon.shop.data.domain.Shop;
import com.tienon.shop.data.vo.req.A100S1000_Request;

import java.util.List;

public interface ShopMapper {
	Shop findShopById(String id);

    List<Shop> selectShopList(A100S1000_Request request);

    Shop getShopDtlById(int id);
}
