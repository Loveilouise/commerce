package com.neuesoft.commerce.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.common.RandomNo;
import com.neuesoft.commerce.common.Tools;
import com.neuesoft.commerce.mapper.GoodMapper;
import com.neuesoft.commerce.mapper.OrdersMapper;
import com.neuesoft.commerce.mapper.StoreMapper;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.Store;
import com.neuesoft.commerce.pojo.Store_good;
import com.neuesoft.commerce.pojo.Wishlist;
import com.neuesoft.commerce.vo.StoresGoodVo;



@Service
public class StoreService {

	@Autowired
	private StoreMapper storeMapper;
	
	@Autowired
	private GoodMapper goodMapper;
	
	@Autowired
	private OrdersMapper ordersMapper;

	
	
	public String backStoresById(HttpSession session,Model model,int gid){
		
			
		//通过获取store的借卖方id(sid)，展示对应的store名字
		Seller seller = (Seller)session.getAttribute("seller");		
		int sid = seller.getSid();
		ArrayList<Store> storelist = storeMapper.querystoresById(sid);
		//展示store名字的时候需要根据store_type分类展示
		ArrayList<Store> ebaylist = new ArrayList<Store>();	
		ArrayList<Store> amazonlist = new ArrayList<Store>();		
		for (Store store : storelist) {
			if(store.getStore_type().equals("eBay")){
				ebaylist.add(store);
			}
			else if(store.getStore_type().equals("Amazon")){
						amazonlist.add(store);
			}
		}	
		model.addAttribute("storelist",storelist);
		model.addAttribute("ebaylist",ebaylist);
		model.addAttribute("amazonlist",amazonlist);
		
		
		//选择Amazon的时候展示当前good的upc
		Good good = goodMapper.queryGoodById(gid);
		model.addAttribute("good",good);
		
			
		return "bvo-goodsstorechoose";
	}
	
	
	
	
	public boolean addStoresGoodToStore(StoresGoodVo obj,HttpSession session){
		
		//返回购买总数量
		String[] storelist = obj.getStores().split(",");		
		//System.out.println("这是下单总数量："+obj.getValue());
		
		
		//根据当前good的库存判断数量是否足够
		Good good = goodMapper.queryGoodById(obj.getGid());
		if(good.getGcounts() >= obj.getValue()){
			
			//够则在店铺中插入商品
			for (String store : storelist) {
				int store_id = Integer.parseInt(store);			
				storeMapper.addStoreGood(obj.getGid(), store_id);
			}
			
			//且更新商品库存数量
			int crruentGcounts= good.getGcounts()-obj.getValue();
			goodMapper.updateGoodById(crruentGcounts,obj.getGid());  
			
			//将下单情况插入订单
			Seller seller = (Seller)session.getAttribute("seller");		
			int sid = seller.getSid();
			String createtime = Tools.getTime();
			String orderno = RandomNo.getRandomString2(10);
			ordersMapper.addOrders(obj.getGid(),sid,obj.getValue(),orderno,createtime,0,good.getGprice());
			
			//提示下单成功
			return true;
		}else{  
			
			//不够则返回错误信息
			return false;
				
		}
		
	
	}
	
	
	public String StoreGoods(int store_id, Model model){
		
		//根据store_id显示相应店铺的商品信息
		ArrayList<Store_good> sglist =  storeMapper.querygoodsByStoreId(store_id);
		/*List<Integer> gids = new ArrayList<Integer>();
		
		
		
		for (Store_good store_good : sglist) {   //拿该商铺的good的gid
			gids.add(store_good.getGids());
		}
		
		Set<Integer> set = new HashSet<Integer>(gids);
		List<Integer> newgids = new ArrayList<Integer>(set);  //gid去重
*/		
		
		
		ArrayList<Good> storegoodlist = new ArrayList<Good>();
		for (Store_good sgood : sglist) {
			storegoodlist.add(sgood.getGood());
		}	
		
		
		Set<Good> set = new HashSet<Good>(storegoodlist);
		List<Good> newstoregoodlist = new ArrayList<Good>(set);  //gid去重
		
		
		model.addAttribute("storegoodlist",newstoregoodlist);
		
		//显示该商铺的具体信息
		Store store = storeMapper.querystoreByStoreId(store_id);
		model.addAttribute("store",store);
		
		
		
		return "bvo-showstoregoods";
	}

		
	
	
}
