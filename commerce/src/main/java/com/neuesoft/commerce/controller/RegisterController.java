package com.neuesoft.commerce.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.pojo.User;
import com.neuesoft.commerce.service.RegisterService;


@Controller
public class RegisterController {
	@Autowired
	RegisterService registerService;
	
	@RequestMapping("/regist")
	public String regist(){
		return "register";
	}
	@RequestMapping("/register")
	@ResponseBody int login(@RequestParam(name="userName",required = false)String userName,
							@RequestParam(name="userPwd",required = false)String userPwd,
							@RequestParam(name="userRole",required = false)int userRole){
		if (1==registerService.registerNameCheck(userName)){
			registerService.register(userName,userPwd,userRole);
		}else{
			return 0;//注册失败
		}

		return 1;//注册成功
	}
	
}