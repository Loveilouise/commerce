package com.neuesoft.commerce.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.neuesoft.commerce.mapper.GoodMapper;
import com.neuesoft.commerce.mapper.WishlistMapper;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.Wishlist;


@Service
public class WishlistService {

	@Autowired
	private WishlistMapper wishlistMapper;
	
	
	
	//把商品插入到心愿单表
	//如果心愿单已经有该商品，则返回提示信息，商品不插入表中
	public boolean ToWishlist(int gid,HttpSession session){
		
		Seller seller = (Seller)session.getAttribute("seller");		
		int sid = seller.getSid();
		
		if(wishlistMapper.queryAllWishlist(gid, sid)!=null){  //如果心愿单已经有该商品
			return false;
		
		}else{
			wishlistMapper.addWishlist(gid, sid);	//没有就插入
			return true;
		}

	}
	
	
	//跳转到心愿单页面，展示表里现有的商品
	public String showWishlist(Model model,HttpSession session){
		
		Seller seller = (Seller)session.getAttribute("seller");		
		int sid = seller.getSid();
		
		ArrayList<Wishlist> wishlist = wishlistMapper.queryAllWishGood(sid);
		ArrayList<Good> wishgoodlist = new ArrayList<Good>();
		
		for (Wishlist wish : wishlist) {
			wishgoodlist.add(wish.getGood());
		}
		
		model.addAttribute("wishlist",wishgoodlist);
		
		return "bvo-wishlist";
	}
	
	//通过返回删除的商品id删除心愿单的商品
	public void delWishlist(String delgoods,HttpSession session){
		
		Seller seller = (Seller)session.getAttribute("seller");		
		int sid = seller.getSid();	
		
		String[] delgoodlist = delgoods.split(",");	
		
		for (String delgood : delgoodlist) {		
			int gid = Integer.parseInt(delgood);
			wishlistMapper.deleteWishlist(gid, sid);
		}
		
		
		
	}
	
}
