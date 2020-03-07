package com.neuesoft.commerce.controller;

 
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.SellerAccount;
import com.neuesoft.commerce.service.WallerService;
import com.neuesoft.commerce.vo.CompanyAccountVo;
import com.neuesoft.commerce.vo.SellerAccountVo;

@Controller
public class WallerController {

    @Autowired
    private WallerService wallerService;

    /**
     * 借卖方注册页面
     * @return
     */
    
    
    
    @RequestMapping("/bvo-gmcwallerAcount/{id}")
    public String bvo_gmcwallerAcount(@PathVariable int id,Model model){
    	System.out.println("这是id："+id);
        return wallerService.debitWaller(id, model);
    }

    /**
     * 借卖方注册逻辑
     */
    /*@RequestMapping("/depositwallersignup")
    public String debitSignUp1(SellerAccount waller){
        System.out.println("借卖方钱包注册成功");
        return wallerService.signup1(waller);
    }*/
    
    @RequestMapping("/depositwallersignup")
	public String debitSignUp1(String sa_name,String sa_email,String sa_pwd,HttpSession session,Model model,HttpServletResponse response) {

		return wallerService.signup1(sa_name, sa_email, sa_pwd, session, model,response);
	}
    
    /**
     * 借卖方登录逻辑
     */
    @RequestMapping("loginSellerAccount")
	public String loginSellerAccount(String sa_name,String sa_email,String sa_pwd,
			HttpSession session,Model model,HttpServletResponse response) throws IOException{
		return wallerService.loginAccount(sa_name, sa_email, sa_pwd, session, model,response);
	}

    /**
     * 借卖方钱包信息
     * @return
     */
    @RequestMapping("/bvo-gmcwallermoney")
    public String bvo_gmcwallermoney(Model model,HttpSession session){
    	Seller seller=(Seller)session.getAttribute("seller");
        //wallerService.backDebitWaller(model);
    	SellerAccount waller=wallerService.backAccount(seller.getSid());
        model.addAttribute("waller",waller);
        return "bvo-gmcwallermoney";
    }
    
    
    

    /**
     * 借卖方充值
     */
    @RequestMapping("/debitWallerDeposit")
    @ResponseBody
    public String debitDeposit(@RequestBody SellerAccountVo obj,HttpSession session){
        //System.out.println("debit waller deposit");
        return wallerService.debitDeposit(obj,session);
    }
    
   

    /**
     * 借卖方修改密码
     */     
    @RequestMapping("/modifyDebitPassword")
    public String modifyDebitPassword(@RequestParam("newpassword") String newpassword,
                                      @RequestParam("sa_pwd") String sa_pwd,Model model,HttpSession session){
        System.out.println("modify debit password");
        return wallerService.modifyPassword(newpassword, sa_pwd, model,session);
    }




    
}