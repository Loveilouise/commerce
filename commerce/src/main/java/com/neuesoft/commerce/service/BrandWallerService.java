package com.neuesoft.commerce.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.common.Tools;
import com.neuesoft.commerce.mapper.BrandWallerMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.vo.CompanyAccountVo;




@Service
public class BrandWallerService {
	
	@Autowired
	private BrandWallerMapper brandWallerMapper;
	
	public String insertAccount(String ca_name,String ca_email,String ca_pwd,HttpSession session,Model model,HttpServletResponse response){
		try {
			CompanyAccount companyAccount=new CompanyAccount();
			Company company=(Company)session.getAttribute("company");
			
			
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			if(brandWallerMapper.queryAccount(company.getCid())==null){
				
				companyAccount.setCid(company.getCid());
				companyAccount.setCa_money(0);
				companyAccount.setCa_name(ca_name);
				companyAccount.setCa_email(ca_email);
				companyAccount.setCa_pwd(ca_pwd);
				brandWallerMapper.insertCompanyAccount(companyAccount);
				model.addAttribute("account",backAccount(company.getCid()));
				return "brand-wallerAcountRegister";
				
			}else{
				out.print("<script language=\"javascript\">alert('该钱包账号已注册，请登录！');</script>");
				return "brand-wallerAcountRegister";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
	
	public String loginAccount(String ca_name,String ca_email,String ca_pwd,
			HttpSession session,Model model,HttpServletResponse response) throws IOException{
		CompanyAccount companyAccount=new CompanyAccount();
		Company company=(Company)session.getAttribute("company");
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		if(brandWallerMapper.queryloginAccount(company.getCid(),ca_name,ca_email,ca_pwd)==null){
			out.print("<script language=\"javascript\">alert('登录信息错误，请重新登录！');</script>");
			return "brand-wallerAcountRegister";
		}else{
			model.addAttribute("account",backAccount(company.getCid()));
			return "brand-gmcwallerAcount";
		}
		
	}
	
	
	
	
	public CompanyAccount backAccount(int cid){
		return brandWallerMapper.queryAccount(cid);
	}
	
	
	public String judgeEqualsPwd(CompanyAccountVo obj,HttpSession session){
		float money=obj.getMoney();
		int ca_id=obj.getCa_id();
		String ca_pwd=obj.getCa_pwd(); 
			
		CompanyAccount account=brandWallerMapper.queryAccountPwd(ca_id);		
		if(account.getCa_pwd().equals(ca_pwd)) {			
			float newmoney=account.getCa_money()-money;
			if(newmoney>0) {
				
				CompanyRecord companyRecord=new CompanyRecord();
				Company company=(Company)session.getAttribute("company");
				companyRecord.setCid(company.getCid());
				companyRecord.setCr_money(obj.getMoney());
				companyRecord.setCr_time(Tools.getTime());
				companyRecord.setCr_transact(Tools.getTrackingno());
				companyRecord.setCr_type("提现");
				companyRecord.setCr_status(0);
				brandWallerMapper.insertCompanyRecord(companyRecord);
				
				//brandWallerMapper.updateAccount(newmoney,ca_id);
				return "移交管理员审核";
			}else {
				return "余额不足";
			}
			
			
		}else {
			return "密码不正确";
		}
			
	}
	
	/*public void  insertCompanyRecord(CompanyRecord companyRecord) {
		brandWallerMapper.insertCompanyRecord(companyRecord);
	}*/
	
	public  ArrayList<CompanyRecord> backAll(int cid){
		return brandWallerMapper.queryRecord(cid);
	}

}
