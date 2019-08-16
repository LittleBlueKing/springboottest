package com.tienon.shop.service.inf;

import com.tienon.shop.data.domain.Shop;
import com.tienon.shop.data.vo.req.A100S1000_Request;
import com.tienon.shop.data.vo.rsp.A100S1000_Response;

public interface ShopService {

	String getShopMsg(String id);

	A100S1000_Response getShopList(A100S1000_Request request);

	Shop getShopDtl(int id);
}
