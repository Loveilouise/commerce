package com.neuesoft.commerce.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.common.Resource;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.mapper.OrderListMapper;
import com.neuesoft.commerce.pojo.Orders;
 
 
 
@Service
public class OrderListService {
	
	@Autowired
	private OrderListMapper bvoOrdersMapper;
	
	public String backList(Model model){    
		try { 
			 ArrayList<Orders> awaitPayOrders = new ArrayList<Orders>();
	            awaitPayOrders = bvoOrdersMapper.backOrderByStatus(0);
	            model.addAttribute("awaitPayOrders",awaitPayOrders);

	            ArrayList<Orders> awaitShipOrders = new ArrayList<Orders>();
	            awaitShipOrders = bvoOrdersMapper.awaitShipOrders(1);
	            model.addAttribute("awaitShipOrders",awaitShipOrders);
	            
	            ArrayList<Orders> shipedOrders = new ArrayList<Orders>();
	            shipedOrders = bvoOrdersMapper.shipedOrders(2);
	            model.addAttribute("shipedOrders",shipedOrders);
	            
	            ArrayList<Orders> finishedOrders = new ArrayList<Orders>();
	            finishedOrders = bvoOrdersMapper.finishedOrders(3);
	            model.addAttribute("finishedOrders",finishedOrders);
	            
	            ArrayList<Orders> cancelledOrders = new ArrayList<Orders>();
	            cancelledOrders = bvoOrdersMapper.cancelledOrders(4);
	            model.addAttribute("cancelledOrders",cancelledOrders);
			
        return "bvo-orderlist";
    } catch (Exception e) {
        e.printStackTrace();
        return "index";
    }
    }
	
	 
	
	 public Result searchOrdersByTitle(String gname)
	    {

	        Result result = new Result();

	        try {
	            ArrayList<Orders> olist1 = bvoOrdersMapper.searchOrders(gname);	             	           	            
	            result.setData(olist1);
	            result.setCode(Resource.SUCCESS);
	            result.setMsg("查询成功");
	        }catch (Exception e)
	        {
	            result.setCode(Resource.ERROR);
	            result.setMsg("查询失败");
	            e.printStackTrace();
	        }
	        return result;

	    }
	 
	
}
