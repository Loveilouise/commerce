package com.neuesoft.commerce.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.mapper.MyInfoMapper;
import com.neuesoft.commerce.mapper.UserMapper2;
import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.Store;


@Service
public class MyInfoService {

	@Autowired
	private MyInfoMapper myInfoMapper;
	
	@Autowired
	private UserMapper2 umapper;
	
	@Autowired
	HttpSession session;
	
	public String updateSeller(Seller seller) {
		try {
			myInfoMapper.updateSeller(seller);
			//System.out.println("更新了111"+seller.getSemail());
			return "bvo-myInfo";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public String insertStore(Store store) {
		try {
			myInfoMapper.insertStore(store);
			//System.out.println("插入了"+store.getStore_type());
			return "bvo-goodsstoreAdd";
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "error";
		}
	}
	
	public ArrayList<Store> backAllAmazon(int sid){
		return myInfoMapper.queryAmazon(sid);
	}
	
	public ArrayList<Store> backAlleBay(int sid){
		return myInfoMapper.queryeBay(sid);
	}
	
	
	public String backList(Orders orders,Model model) {
		try {
			if(orders.getOstatus()==0) {
				ArrayList<Orders> apolist=myInfoMapper.backOrderByStatus(orders.getSid());
				model.addAttribute("apolist",apolist);
			}else if(orders.getOstatus()==1){
				ArrayList<Orders> asolist=myInfoMapper.backOrderByStatus1(orders.getSid());
				model.addAttribute("asolist",asolist);
			}else if(orders.getOstatus()==2){
				ArrayList<Orders> solist=myInfoMapper.backOrderByStatus2(orders.getSid());
				model.addAttribute("solist",solist);
			}else if(orders.getOstatus()==3){
				ArrayList<Orders> colist=myInfoMapper.backOrderByStatus3(orders.getSid());
				model.addAttribute("colist",colist);
			}else if(orders.getOstatus()==4){
				ArrayList<Orders> clolist=myInfoMapper.backOrderByStatus4(orders.getSid());
				model.addAttribute("clolist",clolist);
			}
			return "bvo-orderlist";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "error";
		}
	}
	
	
}
