package com.neuesoft.commerce.controller;

import com.neuesoft.commerce.mapper.DataDictionaryMapper;
import com.neuesoft.commerce.pojo.DataDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class TestController {
	
/*	
	@RequestMapping("/test")
	public String welcome(Model model){
		System.out.println("commerce");
		model.addAttribute("content","这是老地鼠的测试类");
		return "test";
	}
	
	@RequestMapping("/index")
	public String index(Model model,HttpSession session){
		//session.setAttribute("sid", 1);   //测试存一个sid用	
	
		return "index";
	}
	*/
	

	@Autowired
    private DataDictionaryMapper dataDictionaryMapper;

   /**
     * 测试数据库是否可以连接
     * @return
     */
    @RequestMapping("/findAll")
    @ResponseBody
    public List<DataDictionary> queryAll(){

        return dataDictionaryMapper.queryAll();

    }
   
    @RequestMapping("/code")
    public String code(){
        return "code";
    }
    @RequestMapping("/parameter")
    public String parameter(){
        return "parameter";
    }
    
    /*@RequestMapping("/admin-withdraw-audit")
    public String adminwithdrawaudit(){
        return "admin-withdraw-audit";
    }*/

	
	
	
	
	
	
	
}
