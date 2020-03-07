package com.neuesoft.commerce.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.common.Tools;
import com.neuesoft.commerce.mapper.OrdersMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Orders;


@Service
public class OrderService {

	@Autowired
	private OrdersMapper omapper;
	
	@Autowired
	HttpSession session;
	
	public String backAll(Model model) {
		Company company = (Company)session.getAttribute("company");
		ArrayList<Orders> olist=omapper.queryAll(company.getCid());
		List<Orders> result1=new ArrayList<Orders>();
		List<Orders> result2=new ArrayList<Orders>();
		List<Orders> result3=new ArrayList<Orders>();
		List<Orders> result4=new ArrayList<Orders>();
		List<Orders> result5=new ArrayList<Orders>();
		for (Orders order : olist) {
			//System.out.println(order.getGood()+"数据库");
			if(order.getOstatus()==0) {//待支付
				result1.add(order);
				model.addAttribute("paylist", result1);
			}else if(order.getOstatus()==1){//代发货
				result2.add(order);
				model.addAttribute("sendlist", result2);
			}else if(order.getOstatus()==2) {//已发货
				result3.add(order);
				model.addAttribute("sendlist2", result3);
			}else if(order.getOstatus()==3) {//已完成
				result4.add(order);
				model.addAttribute("finishlist", result4);
			}else  {//已取消
				result5.add(order);
				model.addAttribute("cancellist", result5);
			}
		}
		return "brand-orderlist";
	}
	
	public String backByTitle(String gname,Model model) {
		Company company = (Company)session.getAttribute("company");
		ArrayList<Orders> olist=omapper.queryByTitle(gname,company.getCid());
		if(olist.size()>0) {
			List<Orders> result1=new ArrayList<Orders>();
			List<Orders> result2=new ArrayList<Orders>();
			List<Orders> result3=new ArrayList<Orders>();
			List<Orders> result4=new ArrayList<Orders>();
			List<Orders> result5=new ArrayList<Orders>();
			for (Orders order : olist) {
				//System.out.println(order.getGood()+"数据库");
				if(order.getOstatus()==0) {//待支付
					result1.add(order);
					model.addAttribute("paylist", result1);
				}else if(order.getOstatus()==1){//代发货
					result2.add(order);
					model.addAttribute("sendlist", result2);
				}else if(order.getOstatus()==2) {//已发货
					result3.add(order);
					model.addAttribute("sendlist2", result3);
				}else if(order.getOstatus()==3) {//已完成
					result4.add(order);
					model.addAttribute("finishlist", result4);
				}else  {//已取消
					result5.add(order);
					model.addAttribute("cancellist", result5);
				}
			}
			
		}
		else {
			model.addAttribute("content","没有符合要求的结果！");
		
		}
		return "brand-orderlist";
	}
	
	public void updataStatus(int oid,int ostatus) {
		String trackingno=Tools.getTrackingno();
		if(ostatus==2) {
			omapper.updateSendStatus(oid, trackingno,ostatus);
		}
		else {
			omapper.updateCancelStatus(oid,ostatus);
		}
	}
	
	
	public boolean checkProductByPid(int gid) {
		try {
			ArrayList<Orders> list=omapper.backOrderByGid(gid);
			if(list.size()>0) {
				for (Orders order : list) {
					if(order.getOstatus() ==3 && order.getOstatus() ==4) {//如果订单处于已完成或者已取消的状态 可以删除商品
						return true;
					}else {
						return false;
					}						
				}
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
}
