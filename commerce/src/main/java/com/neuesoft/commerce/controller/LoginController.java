package com.neuesoft.commerce.controller;

import com.neuesoft.commerce.mapper.UserMapper2;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.User;
import com.neuesoft.commerce.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    LoginService loginService;
    @Autowired
	private UserMapper2 userMapper;
    
    
    @RequestMapping("/login")
    public String loginPage(){
//        System.out.println("123");
        return "login";
    }

    @RequestMapping("/userLogin")
    @ResponseBody int login(@RequestParam(name="userName",required = false)String userName,
               @RequestParam(name="userPwd",required = false)String userPwd,HttpServletRequest request,
               HttpSession session
               ){
//        System.out.println("login传来的username："+userName);
//        System.out.println("login传来的userPwd："+userPwd);
//        System.out.println("login传来的userRole："+userRole);
        User user = loginService.findUser(userName);
        //HttpSession session = request.getSession(true);
        session.setAttribute("user",user);
        if(user.getUserStatus()==1){
        	Company company = new Company();
        	
        	
        	company.setCename(user.getUserName());
        	company.setCpassword(user.getUserPassword()); 
        	
        	Company c = userMapper.queryCompany(company);
        	company.setCid(c.getCid());
        	
        	session.setAttribute("company",company);
        }else if(user.getUserStatus()==2){
        	Seller seller = new Seller();
        	
        	
        	seller.setSname(user.getUserName());
        	seller.setSpassword(user.getUserPassword());    
        	
        	Seller s = userMapper.querySeller(seller);
        	seller.setSid(s.getSid());
        	session.setAttribute("seller",seller);
        	
        	//Seller seller2  = (Seller)session.getAttribute("seller");
        	//System.out.println("---------------"+seller2.getSid());
        }
        
        
        
        if (null!=user){
            //用户不为空值，用户存在
            if(user.getUserPassword().equals(userPwd)){
                //System.out.println("1");
                return user.getUserStatus();//密码正确，登陆成功
            }else{
                //System.out.println("0");
                return 3;//密码错误，登陆失败
            }
        }else{
            //System.out.println("2");
            return 4;//用户不存在
        }
    }

}
