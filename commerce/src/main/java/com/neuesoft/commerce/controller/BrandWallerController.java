package com.neuesoft.commerce.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.common.Tools;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.service.BrandWallerService;
import com.neuesoft.commerce.vo.CompanyAccountVo;

@Controller
public class BrandWallerController {
	
	@Autowired BrandWallerService brandWallerService;
	
	@RequestMapping("brand-wallerAcountRegister")
	public String brand_wallerAcountRegister() {
		return "brand-wallerAcountRegister";
	}
	
	
	
	
	@RequestMapping("insertCompanyAccount")
	public String insertCompanyAccount(String ca_name,String ca_email,String ca_pwd,HttpSession session,Model model,HttpServletResponse response) {

		return brandWallerService.insertAccount(ca_name, ca_email, ca_pwd, session, model,response);
	}
	

	
	@RequestMapping("loginCompanyAccount")
	public String loginCompanyAccount(String ca_name,String ca_email,String ca_pwd,
			HttpSession session,Model model,HttpServletResponse response) throws IOException{
		return brandWallerService.loginAccount(ca_name, ca_email, ca_pwd, session, model,response);
	}
	
	
	
	@RequestMapping("brand-gmcwallerAcount")
	public String brand_gmcwallerAcount(Model model,HttpSession session) {
		Company company=(Company)session.getAttribute("company");
		CompanyAccount account=brandWallerService.backAccount(company.getCid());
		model.addAttribute("account",account);
		return "brand-gmcwallerAcount";
	}
	/*
	@RequestMapping("/brand-gmcwallerAcount")
	public String brand_gmcwallerAcount(HttpSession session,Model model) {
		Company company=(Company)session.getAttribute("company");
		ArrayList<CompanyAccount> list=brandWallerService.backlist(company.getCid());
		for (CompanyAccount companyAccount : list) {
			System.out.println(companyAccount.getCa_name());
		}
		model.addAttribute("accountlist",list);
		return "brand-gmcwallerAcount";
	}*/
	
	
	
	@RequestMapping("updateMoney")
	@ResponseBody
	public String accountWithdraw(@RequestBody CompanyAccountVo obj,HttpSession session){			
		return brandWallerService.judgeEqualsPwd( obj,session);			
	}
	
	@RequestMapping("brand-gmcwallerAcountlist")
	public String backAllRecord(HttpSession session,Model model) {
		
		Company company=(Company)session.getAttribute("company");
		

		
		ArrayList<CompanyRecord> crlist=brandWallerService.backAll(company.getCid());
		model.addAttribute("crlist", crlist);
		return "brand-gmcwallerAcountlist";
		
	}
	
	

}
