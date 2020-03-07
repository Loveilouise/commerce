package com.neuesoft.commerce.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuesoft.commerce.mapper.UserMapper2;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Seller;

@Service
public class UserService {
	@Autowired
	private UserMapper2 userMapper;
	
	public String sellerregister(Seller seller){
		try {
			userMapper.insertSeller(seller);
			return "sellerLogin";
		} catch (Exception e) {
			return "error";
		}
	}
	
	public  String  sellerLogin(Seller seller,HttpSession session){
		try{
			Seller s=userMapper.querySeller(seller);
			if(s==null){ 
				return  "error";
			}else{
				seller.setSid(s.getSid());
				//session.setAttribute("sid", seller.getSid());
				session.setAttribute("seller", seller);
				return  "index";
			}
		}catch(Exception e){
			e.printStackTrace();
			return  "error";
		}
	}
	
	public String companyregister(Company company){
		try {
			userMapper.insertCompany(company);
			return "companyLogin";
		} catch (Exception e) {
			return "error";
		}
	}
	
	public  String  companyLogin(Company company,HttpSession session){
		try{
			Company c=userMapper.queryCompany(company);
			if(c==null){ 
				return  "error";
			}else{
				company.setCid(c.getCid());
				//session.setAttribute("sid", seller.getSid());
				session.setAttribute("company", company);
				return  "index";
			}
		}catch(Exception e){
			e.printStackTrace();
			return  "error";
		}
	}
	
	
}
