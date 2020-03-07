package com.neuesoft.commerce.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.SellerAccount;
import com.neuesoft.commerce.service.PayService;
import com.neuesoft.commerce.vo.SellerAccountVo;

@Controller
public class OrderListController {
	
	@Autowired
	private PayService payService;
	
	@Autowired 
	HttpSession session;
	
	//Pay Now跳转
	@RequestMapping("/bvo-orderPayment/{oid}")
	public String orderPayment(@PathVariable("oid") int oid,Model model){		 
			System.out.println(oid);
		   Orders orders = new Orders();
		   orders = payService.backOrderPayment(oid);
           model.addAttribute("pay",orders);
           SellerAccount sa=payService.backBalance(oid);
           //System.out.println(sa.getSa_money());
		   model.addAttribute("balance",sa);
		   return "/bvo-orderPayment";		 
	}
	
	 /**
           * 真实付款
     * @param orders
     * @return
     */
   /* @RequestMapping("/payProduct")
    @ResponseBody 
    public Result payProduct(@RequestBody Orders orders)
    {

        int oid  = orders.getOid();

        return payService.payGood(oid);

    }*/

	@RequestMapping("checkBalance") 
	@ResponseBody
	public String backBalance(@RequestBody SellerAccountVo obj) {
		System.out.println(obj.getMoney());
		System.out.println("会计法话等级"+obj.getSid());
		return payService.checkBalance( obj);
	}
		 	 
	@RequestMapping("/bvo-goodsdetail")
	public String goodsdetail(Model model){		 
		return "bvo-goodsdetail";
	}
	@RequestMapping("/bvo-ordertracking")
	public String ordertracking(Model model){		 
		return "bvo-ordertracking";
	}
	 
}
