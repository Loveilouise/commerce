package com.neuesoft.commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.service.OrderService;

@Controller
public class OrdersController {
	
	@Autowired
	private OrderService orderservice;

	@RequestMapping("brand-orderlist")
	public String orderlist(Model model){
		return orderservice.backAll(model);
		//return "brand-orderlist";
	}
	
	@RequestMapping("brand-ordertracking")
	public String ordertracking() {
		return "brand-ordertracking";
	}
	
	@RequestMapping("queryByTitle")
	public String queryByTitle(String gname,Model model) {
		return orderservice.backByTitle(gname, model);
	}
	
	@RequestMapping("send")
	@ResponseBody
	public void sendout(@RequestBody Orders obj) {
		int oid=obj.getOid();
		//System.out.println(oid);
		int ostatus=obj.getOstatus();
		//System.out.println(status+"shshs");
		//System.out.println(oid+status+"sdff");
		orderservice.updataStatus(oid, ostatus);
		
	}
	@RequestMapping("cancel")
	@ResponseBody
	public void cancel(@RequestBody Orders obj) {
		int oid=obj.getOid();
		//System.out.println(oid);
		int ostatus=obj.getOstatus();
		//System.out.println(status+"shshs");
		//System.out.println(oid+status+"sdff");
		orderservice.updataStatus(oid, ostatus);
		
	}
}
