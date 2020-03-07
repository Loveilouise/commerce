package com.neuesoft.commerce.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.service.CategoryService;
import com.neuesoft.commerce.vo.CategoryVo;


@Controller
public class CategoryController {

	@Autowired
	private CategoryService gcService;
	
	@Autowired
	HttpSession session;
	
	@RequestMapping("brand-productInput-pic")
	public String showpic(Model model) {
		//System.out.println(session.getAttribute("user"));
		ArrayList<Good> gclist=gcService.queryAllByGcid();
		/*for (Good good : gclist) {
			System.out.println(good.getCategory().getGc_id());
		}
		System.out.println(gclist.size()+"到底多长啊");*/
		model.addAttribute("gclist", gclist);
		ArrayList<Good> title=gcService.queryTitle();
		/*ArrayList<Good> result=new ArrayList<Good>();
		for (Good good : title) {
			if(good.getCategory().getGc_id()==null) {
				result.add(good);
			}
		}*/
	/*	for (Good good : title) {
			System.out.println(good.getGname());
		}*/
		model.addAttribute("title", title);
		return "brand-productInput-pic";
	}
	
	@RequestMapping("queryByGname")
	public String backByTitle(String gname,Model model) {
		return gcService.queryByTitle(gname, model);
	}
	
	@RequestMapping("updateStatus")
	public String updateStatus(String gc_id,String gc_status,Model model) {
		System.out.println(gc_id);
		System.out.println(gc_status+"状态值");
		return gcService.updateStatus(gc_id, gc_status, model);
	}
	
	
	@RequestMapping("uploadImage")
	@ResponseBody
	public String uploadImage(MultipartFile file,String gid,String category,String gname,String gcid) throws Exception {
		System.out.println("我来了"+gid+category+gname+gcid);
		
        //System.out.println(fileName);
        if(gcid==null) {
        	 String fileName = file.getOriginalFilename();
             String filePath = "D:/FFOutput/";
             File dest = new File(filePath + fileName);
        	 gcService.addCategory(gid,category, fileName);
        	 try {
                 file.transferTo(dest);
                 return "上传成功";
             } catch (IOException e) {
                e.printStackTrace();
             }
             return "上传失败！";
        }
        else if(gcid !=null && file==null){
        	gcService.updateCategory2(category,gcid);
        }
        else {
        	if (file.isEmpty()) {
                return "上传失败，请选择文件";
            }
            String fileName = file.getOriginalFilename();
            String filePath = "D:/FFOutput/";
            File dest = new File(filePath + fileName);
        	gcService.updateCategory(category,fileName,gname,gcid);
        	 try {
                 file.transferTo(dest);
                 return "上传成功";
             } catch (IOException e) {
                e.printStackTrace();
             }
             return "上传失败！";
        }
       return null;
	}
	
	@RequestMapping("delCate")
	@ResponseBody
	public String delCate(@RequestBody CategoryVo obj) {
		System.out.println(obj.getGcid()+"hshsh"+obj.getGid());
		return gcService.delCategory(obj);
	} 
}
