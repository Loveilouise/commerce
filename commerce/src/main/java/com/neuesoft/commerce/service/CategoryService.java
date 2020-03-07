package com.neuesoft.commerce.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.mapper.GCategoryMapper;
import com.neuesoft.commerce.mapper.GoodMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Good_category;
import com.neuesoft.commerce.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private GCategoryMapper gcmapper;
	
	@Autowired
	private GoodMapper gmapper;
	
	@Autowired
	private OrderService oservice;
	
	@Autowired
	HttpSession session;

	
	public ArrayList<Good> queryAllByGcid(){
		Company company = (Company)session.getAttribute("company");
		return gcmapper.queryCategory(company.getCid());
	}
	
	
	public String queryByTitle(String gname,Model model) {
		int cid=(Integer) session.getAttribute("user");
		ArrayList<Good> gclist=gcmapper.queryByTitle(gname, cid);
		if(gclist.size()>0) {
			model.addAttribute("gclist", gclist);			
		}else {
			model.addAttribute("content", "没有符合要求的结果！");
		}
		
		return "brand-productInput-pic";
		
	}
	
	
	public String updateStatus(String gc_id,String gc_status,Model model) {
		int status=Integer.parseInt(gc_status)+1;
		gcmapper.updateStatus(status, gc_id);
		model.addAttribute("gclist", queryAllByGcid());
		/*ArrayList<Good> good=queryTitle();*/
		/*for (Good good2 : good) {
			System.out.println(good2.getGname()+"shangpinbiaoti");
		}*/
		model.addAttribute("title", queryTitle());
		return "brand-productInput-pic";
	}
	
	public ArrayList<Good> queryTitle(){
		Company company = (Company)session.getAttribute("company");
		return gcmapper.queryALL(company.getCid());
	}
	
	public void addCategory(String gid,String category,String pic) {
		Good_category gc=new Good_category();
		Company company = (Company)session.getAttribute("company");
		gc.setGc_category(category);
		gc.setGc_status(company.getCid());
		gc.setGc_picture(pic);
		System.out.println(pic+"service层");
		gcmapper.insertCategory(gc);
		int gc_id=gc.getGc_id();
		System.out.println(gc_id+"新增到的id");
		gmapper.updateGcid(gid, gc_id);
		
	}
	
	public String backForUpdate(int gc_id,Model model) {
		ArrayList<Good> uplist=gcmapper.queryForUpdate(gc_id);
		ArrayList<Good>  result=new ArrayList<Good>();
		/*for (Good good : uplist) {
			if(good.getCategory().getGc_id() ==null) {
				result.add(good);
			}
		}*/
		model.addAttribute("uplist", result);
		return "brand-productInput-pic";
	}
	
	public void updateCategory(String category,String fileName,String gname,String gcid) {
		gcmapper.updateCategory(category, fileName, gcid);
		//gcmapper.updateGoodTitle(gcid, gname);
	}
	
	public void updateCategory2(String category,String gcid) {
		gcmapper.updateCategory2(category,gcid);
		
	}
	
	public String delCategory(CategoryVo obj) {
		int gid=obj.getGid();
		int gc_id=obj.getGcid();
		if(oservice.checkProductByPid(gid)) {
			gcmapper.deleteCategory(gc_id);
			//只删列表中gc_id
			//gcmapper.deleteGcid(gc_id, gid);
			//商品一起删除
			gcmapper.deleteByGcid(gc_id, gid);
			return "删除成功";
		}
		else {
			return "删除失败";
		}
	}
}
