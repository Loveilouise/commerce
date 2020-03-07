/*package com.neuesoft.commerce.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.neuesoft.commerce.mapper.CompanyMyInfoMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CompanyMyInfoMapper companyMyInfoMapper;
	
	
	@RequestMapping("/sellerRegist")
	public String sellerregist(){
		return "sellerRegister";
	}
	
	
	@RequestMapping("/sellerRegister")
	public String sellerregister(Seller seller){
		return userService.sellerregister(seller);
	}
	
	@RequestMapping("/sellerLogin")
	public String sellerlogin(){
		return "sellerLogin";
	}
	
	@RequestMapping("/sellerLoginin")
	public  String  sellerlogin(Seller seller,HttpSession session,Model model){
		model.addAttribute("seller",seller);
		return   userService.sellerLogin(seller,session);
	}
	
	
	@RequestMapping("/companyRegist")
	public String companyregist(){
		return "companyRegister";
	}
	
	
	@RequestMapping("/companyRegister")
	public String companyregister(Company company){
		return userService.companyregister(company);
	}
	
	@RequestMapping("/companyLogin")
	public String companylogin(){
		return "companyLogin";
	}
	
	@RequestMapping("/companyLoginin")
	public  String  companylogin(Company company,HttpSession session,Model model){
		model.addAttribute("company",company);
		return   userService.companyLogin(company,session);
	}
	
	
	@RequestMapping("/companylogin")
	public  String  login(HttpSession session,Model model){
		//2020.3.3 写死登陆 ！！！！！！！！！！！！！！！！！！！！！！！！！！！记得替换
		CompanyAccount ca = companyMyInfoMapper.companyLogin();
		Company c = companyMyInfoMapper.queryCompany(ca.getCid());
		System.out.println(c);
		session.setAttribute("companyAccount", ca);
		session.setAttribute("company",c);

		return "index";
	}
	
}
*/