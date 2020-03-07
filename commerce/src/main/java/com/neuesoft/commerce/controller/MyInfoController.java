package com.neuesoft.commerce.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.Store;
import com.neuesoft.commerce.service.MyInfoService;

@Controller
public class MyInfoController {
	@Autowired
	private MyInfoService myInfoService;
	
	/*//跳转首页
	@RequestMapping("/index")
	public String index() {
		return "index";
	}*/
	
	//跳转借卖方我的信息
	@RequestMapping("/bvo-myInfo")
	public String bvo_myInfo() {
		return "bvo-myInfo";
	}
	
	//跳转借卖方店铺管理
	@RequestMapping("/bvo-shops")
	public String bvo_shops() {
		return "bvo-shops";
	}
	
	//跳转增加店铺
	@RequestMapping("/bvo-goodsstoreAdd")
	public String bvo_goodsstoreAdd(Model model,HttpSession session) {
		Seller s=(Seller)session.getAttribute("seller");
		
		//查询Amazon的店铺列表
		ArrayList<Store> amazonlist=myInfoService.backAllAmazon(s.getSid());
		model.addAttribute("amazonlist",amazonlist);
		
		//查询eBay的店铺列表
		ArrayList<Store> ebaylist=myInfoService.backAlleBay(s.getSid());
		model.addAttribute("ebaylist",ebaylist);
		
		return "bvo-goodsstoreAdd";
	}
	
	
	
	/**
	 * 更新借卖方信息
	 * @param seller 从前台传过来的seller对象
	 * @param model
	 * @param session 
	 * @return
	 */
	@RequestMapping("save")
	@ResponseBody
	public String save(@RequestBody Seller seller,Model model,HttpSession session) {
		
		//从session中的sid付给seller对象的sid
		Seller s=(Seller)session.getAttribute("seller");
		seller.setSid(s.getSid());
		System.out.println(seller.getSid());
		System.out.println(seller.getSemail());
		System.out.println(seller.getSphone());
		myInfoService.updateSeller(seller);
		return "更新了";
	}
	
	
	//增加店铺操作
	@RequestMapping("addshopdetail")
	@ResponseBody
	public String addshopdetail(@RequestBody Store store,Model model,HttpSession session) {
		Seller s=(Seller)session.getAttribute("seller");
		store.setSid(s.getSid());
		//System.out.println(store.getStore_type());
		//System.out.println(store.getStore_name());
		myInfoService.insertStore(store);
		return "插入了";
	}
	//展示店铺商品
	@RequestMapping("showgood")
	public String showgood() {
		return "goodlist";
	}
	/*//借卖方的订单管理
	@RequestMapping("bvo-orderlist")
	public String bvo_orderlist(Orders orders,Model model,HttpSession session) {
		Seller s=(Seller)session.getAttribute("seller");
		orders.setSid(s.getSid());
		myInfoService.backList(orders,model);
		return "bvo-orderlist";
	}*/

}
