package com.neuesoft.commerce.service;

 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.common.Tools;
import com.neuesoft.commerce.mapper.TurnoverMapper;
import com.neuesoft.commerce.mapper.WallerMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.SellerAccount;
import com.neuesoft.commerce.pojo.SellerRecord;
import com.neuesoft.commerce.vo.CompanyAccountVo;
import com.neuesoft.commerce.vo.SellerAccountVo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Random;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Service
public class WallerService {

    @Autowired
    private WallerMapper wallerMapper;

    @Autowired
    private TurnoverMapper turnoverMapper;

    
    /**
     * 借卖方钱包注册
     */
    /*public String signup1(SellerAccount debitWaller){
        wallerMapper.insertAccount1(debitWaller);
        return "/bvo-gmcwallermoney";
    }*/
    
    
    public String signup1(String sa_name,String sa_email,String sa_pwd,HttpSession session,Model model,HttpServletResponse response){
		try {
			SellerAccount sellerAccount=new SellerAccount();
			Seller seller=(Seller)session.getAttribute("seller");
			
			
			response.setContentType("text/html;charset=gb2312");
			PrintWriter out = response.getWriter();
			if(wallerMapper.queryAccount(seller.getSid())==null){
				
				sellerAccount.setSid(seller.getSid());
				sellerAccount.setSa_money(0);
				sellerAccount.setSa_name(sa_name);
				sellerAccount.setSa_email(sa_email);
				sellerAccount.setSa_pwd(sa_pwd);
				wallerMapper.insertAccount1(sellerAccount);
				model.addAttribute("account",wallerMapper.queryAccount(seller.getSid()));
				return "bvo-gmcwallerAcount";
				
			}else{
				out.print("<script language=\"javascript\">alert('该钱包账号已注册，请登录！');</script>");
				return "bvo-gmcwallerAcount";
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
	}
    
    
    public String loginAccount(String sa_name,String sa_email,String sa_pwd,
			HttpSession session,Model model,HttpServletResponse response) throws IOException{
    	SellerAccount sellerAccount=new SellerAccount();
		Seller seller=(Seller)session.getAttribute("seller");
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		
		if(wallerMapper.queryloginAccount(seller.getSid(),sa_name,sa_email,sa_pwd)==null){
			out.print("<script language=\"javascript\">alert('登录信息错误，请重新登录！');</script>");
			return "bvo-gmcwallerAcount";
		}else{
			model.addAttribute("waller",wallerMapper.queryAccount(seller.getSid()));
			return "bvo-gmcwallermoney";
		}
		
	}
    
    public SellerAccount backAccount(int sid){
		return wallerMapper.queryAccount(sid);
	}
    
    
    /**
     * 借卖方钱包信息
     */
    /*public String backDebitWaller(int sid, Model model){
    	SellerAccount waller = wallerMapper.selecyDebitWallerByDebitId(sid);
        model.addAttribute("waller",waller);
        return "/bvo-gmcwallermoney";
    }*/

    /**
     * 借卖方钱包提现
     */
    public String debitDeposit(SellerAccountVo obj,HttpSession session){
    	//SellerAccount waller = wallerMapper.selecyDebitWallerByWallerId(debitWaller);
    	Seller seller=(Seller)session.getAttribute("seller");
    	SellerAccount waller = wallerMapper.selecyDebitWallerByDebitId(seller.getSid());
    	
    	
    	float money=obj.getMoney();
		//int sa_id=obj.getSa_id();
		String sa_pwd=obj.getSa_pwd(); 
        
        	if(waller.getSa_pwd().equals(sa_pwd)) {
            //钱包的逻辑
            //float remain = waller.getSa_money() + money;
            //waller.setSa_money(remain);
            //wallerMapper.upddateDebitWaller(waller);
            //SellerAccount debitWaller1 = wallerMapper.selecyDebitWallerByDebitId(waller.getSid());
            //System.out.println(debitWaller1);
            //model.addAttribute("waller",debitWaller1);

            //流水的逻辑
            SellerRecord debitTurnover = new SellerRecord();
            debitTurnover.setSr_time(Tools.getTime());
            debitTurnover.setSr_transact(Tools.getTrackingno());
            debitTurnover.setSid(waller.getSid());
            System.out.println(waller.getSid());
            debitTurnover.setSr_status(0);
            debitTurnover.setSr_type("充值");
            debitTurnover.setSr_money(money);
            turnoverMapper.insertDebitTurnover(debitTurnover);

            return "移交管理员审核";
        	}else{
        		
        		 return "密码不正确";
        	}
        /*else{
             SellerAccount debitWaller1 = wallerMapper.selecyDebitWallerByDebitId(waller.getSid());
            model.addAttribute("waller",debitWaller1);
            return "bvo-gmcwallermoney";
        }*/
    }
    
    
    
    
    

    /**
     * 修改密码
     * @param newpassword
     * @param sa_pwd
     * @param id
     * @param model
     * @return
     */
    public String modifyPassword(String newpassword,String sa_pwd,Model model,HttpSession session){
    	Seller seller=(Seller)session.getAttribute("seller");
    	SellerAccount waller = wallerMapper.selecyDebitWallerByDebitId(seller.getSid());
        wallerMapper.updateDebitWallerPassword(newpassword,sa_pwd,seller.getSid());
        
        model.addAttribute("waller",waller);
        return "/bvo-gmcwallermoney";
    }

    /**
     * 借卖商钱包汇总
     * @param id
     * @param model
     * @return
     */
    public String debitWaller(int id,Model model){
    	SellerAccount debitWaller = wallerMapper.selecyDebitWallerByDebitId(id);
        if(debitWaller!=null){
            model.addAttribute("waller",debitWaller);
            return "bvo-gmcwallermoney";
        }else{
            return "bvo-gmcwallerAcount";
        }
    }
}
