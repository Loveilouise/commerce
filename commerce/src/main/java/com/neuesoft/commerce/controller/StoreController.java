package com.neuesoft.commerce.controller;


import java.util.ArrayList;

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

import com.neuesoft.commerce.pojo.Store;
import com.neuesoft.commerce.service.GoodService;
import com.neuesoft.commerce.service.StoreService;
import com.neuesoft.commerce.vo.StoresGoodVo;

//1.通过获取store的借卖方id(sid)，展示对应的store名字
//2.展示store名字的时候需要根据store_type分类展示
//3.选择的多家店铺存good到store_good
//4.选择Amazon的时候需要展示当前good的upc
//5.在前台增加购买数量的框，根据当前good的库存判断数量是否足够，不够则返回错误信息，够则扣库存数量
//6.插入成功以后在orders的数据库能看见插入的订单信息
//7.生成orders时：订单编号为随机字符串、总价为数量*价格、订单创建时间获取当前时间、订单状态为0(待支付)


@Controller
public class StoreController {
	
	@Autowired
	private StoreService storeService;
	
	@RequestMapping("/bvo-goodsstorechoose/{gid}")
	public String bvoGoodsStoreChoose(@PathVariable("gid") int gid, Model model,HttpSession session){
		
		return storeService.backStoresById(session, model, gid);
	}
	
	
	@RequestMapping("/pushGoods")
	@ResponseBody
	public String pushGoods(@RequestBody StoresGoodVo obj,HttpSession session){
		
				if(storeService.addStoresGoodToStore(obj,session)){
					return "下单成功！";
				}else{
					return "库存不足，请重试";
				}
		
	}
	
	
	@RequestMapping("/bvo-showstoregoods/{store_id}")
	public String bvoshowstoregoods(@PathVariable("store_id") int store_id, 
			Model model,HttpSession session){
		
		//System.out.println("这是store的id："+store_id);
		
		return storeService.StoreGoods(store_id, model);
		
	}
	
	
	
}
