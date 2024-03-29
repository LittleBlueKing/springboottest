package com.tienon.shop.controller;

import com.tienon.shop.data.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.tienon.shop.data.vo.req.A100S1000_Request;
import com.tienon.shop.data.vo.rsp.A100S1000_Response;
import com.tienon.shop.service.inf.ShopService;

import java.io.IOException;
import java.util.Map;

//@RestController
@Controller
public class ShopController {
	
	@Autowired
	private ShopService shopService;

    @RequestMapping(value="/show")
    public String showMsg(Map<String, Object> model){
        model.put("aaa","abc");
        Shop shop = shopService.getShopDtl(1);
        model.put("shop",shop);
        return "show";
    }

    @RequestMapping(value="")
    public String test(){
        System.out.println("123142312");
        String command = "taskkill /f /im qq.exe";
        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "test";
    }

	
//	@RequestMapping(value="/shop/{id}",method=RequestMethod.GET)
//	public String getShopMsg(@PathVariable("id") String id) {
//		  return shopService.getShopMsg(id);
//	}
	
//	@RequestMapping(value="/shop/list",method=RequestMethod.POST)
//	public A100S1000_Response getShopList(@RequestBody A100S1000_Request request) {
//		return shopService.getShopList(request);
//	}
}
