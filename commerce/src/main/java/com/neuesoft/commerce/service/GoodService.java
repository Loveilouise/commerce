package com.neuesoft.commerce.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.mapper.GoodMapper;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.vo.GoodVo2;

@Service
public class GoodService {

	@Autowired
	private GoodMapper goodMapper;
	
	@Autowired
	private GoodMapper gmapper;
	
	@Autowired
	HttpSession session;
	
	@Autowired
	private OrderService orderService;
	
	public Map<String, List<Good>> backAllGoods(){
		
		ArrayList<Good> glist = goodMapper.queryAllGood();
		ArrayList<Good> gslist = new ArrayList<Good>();
		for (Good good : glist) {
				
			if(good.getCategory().getGc_status()==4){ //筛选上架的good
				
				gslist.add(good);	//把good添加到gslist里		
			}						
		}

		Map<String, List<Good>> map = new HashMap<String, List<Good>>();
		for (Good good : gslist) {
			String key = good.getCategory().getGc_category(); //将good的分类作为key值
            if(map.containsKey(key)) {  //如果map里面存在同样的分类
               
                map.get(key).add(good);  //就在同一个分类中里面增加商品
            } else {
                
                List<Good> goodList = new ArrayList<Good>();  //没有此分类则在新的分类中添加商品
                goodList.add(good);
                map.put(key, goodList);
            }
		}
		

		return map;
	}
	
	
	public Good backGoodById(int gid){
		
		return goodMapper.queryGoodById(gid);
	}
	
	
	
	
	public ArrayList<Good> backAll(int cid) {
		
		return gmapper.queryAll(cid);
	}
	
	public String backByTitle(String gname,int cid,Model model) {
		ArrayList<Good> good=gmapper.queryByTitle(gname,cid);
		if(good.size()>0) {
			model.addAttribute("goodlist", good);
		}else {
			model.addAttribute("content", "没有符合要求的结果！");
			
		}		
		return "brand-productInput-attr";
	}
	
	public String deleteGood(int gid) {
		boolean result=orderService.checkProductByPid(gid);
		if(result) {//如果为true则证明可以进行删除
			gmapper.deleteByGid(gid);
			return "删除成功！";
		} 
		return "删除失败！";
	}
	

	
	public String backByGid(int gid,Model model) {
		Good good=gmapper.queryByGid(gid);
		model.addAttribute("good", good);
		return "brand-productInput-attr2";
	}
	
	public void updateGood(GoodVo2 obj) {
		int gid=obj.getGid();
		if(gid ==0) {
			gmapper.insertGood(obj);
		}
		gmapper.updateByGid(obj);
	}
	
}
