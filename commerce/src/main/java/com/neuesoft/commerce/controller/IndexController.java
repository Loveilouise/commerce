package com.neuesoft.commerce.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.service.OrderListService;
 

@Controller
public class IndexController {
	@Autowired
	private OrderListService orderListService;
	
	@RequestMapping("/index")
	public String index(Model model){	 
		return "index";
	}
	
	//跳转借卖方订单列表
	@RequestMapping("/bvo-orderlist")
	public String bvo_orderlist(Model model){
		return orderListService.backList(model);
		    
	}
	  
	/**
     * 搜索
     * @param good
     * @return
     */

	 @RequestMapping("find")
	    @ResponseBody
	    public Result searchOrders(@RequestBody Good good)
	    {
	        String gname = good.getGname();
	        System.out.println(gname+"xxxxxxxx");

	        return orderListService.searchOrdersByTitle(gname);

	    }
	
	 
	//跳转借卖方钱包
	@RequestMapping("/bvo-gmcwallerAcount")
	public String gmcwallerAcount(Model model){		 
		return "bvo-gmcwallerAcount";
	}
}
