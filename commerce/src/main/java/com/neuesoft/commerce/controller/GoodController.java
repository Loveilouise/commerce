package com.neuesoft.commerce.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.collections.SynchronizedStack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.neuesoft.commerce.mapper.GoodMapper;
import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.service.GoodService;
import com.neuesoft.commerce.service.WishlistService;
import com.neuesoft.commerce.vo.GoodVo2;


@Controller
public class GoodController {

	@Autowired
	private GoodService goodService;
	
	@Autowired
	private WishlistService wishlistService;
	
	@Autowired
	private GoodService gservice;
	
	@Autowired
	private GoodMapper gmapper;
	
	@Autowired
	HttpSession session;
	
	
	public void setGoodService(GoodService goodService) {
		this.goodService = goodService;
	}



	@RequestMapping("/bvo-index")
	public String good(Model model,Map<String, List<Good>> map){
		
		map = goodService.backAllGoods();  //拿到分好组的map
		
		model.addAttribute("category_map",map);
			
		return "bvo-index";
	}
	
	
	
	@RequestMapping("/bvo-goodsdetail/{gid}")
	public String bvoGoodsDetail(@PathVariable("gid") int gid, Model model){
			
		Good good = goodService.backGoodById(gid);

		model.addAttribute("good",good);
		
		return "/bvo-goodsdetail";
	}
		
	
	@RequestMapping("/bvo-wishlist/{gid}")
	public String toBvoWishlist(@PathVariable("gid") int gid,Model model,
			HttpSession session,HttpServletResponse response) throws IOException{	
		
		response.setContentType("text/html;charset=gb2312");
		PrintWriter out = response.getWriter();
		if(wishlistService.ToWishlist(gid, session)){  //新增成功,跳转页面
			wishlistService.ToWishlist(gid, session);
			return wishlistService.showWishlist(model,session);
			
		}
		
		else{											//重复，没有新增
			out.print("<script language=\"javascript\">alert('心愿单已有该商品哟！');"
					+ "window.location.href='/bvo-wishlist'</script>");
			return null;
		}
		
	}
		

	
	
	@RequestMapping("/bvo-wishlist")
	public String bvoWishlist(Model model,HttpSession session){

		return wishlistService.showWishlist(model,session);
	}
	
	
	
	@RequestMapping("/delGoods")
	public String delGoods(Model model,@RequestParam(value="delgoods") String delgoods,
			HttpSession session){
		
		wishlistService.delWishlist(delgoods, session);
		
		return wishlistService.showWishlist(model,session);
	}
	
	
	
	
	

	@RequestMapping("brand-productInput-attr")
	public String goodPage(Model model) {

		Company company = (Company)session.getAttribute("company");
		ArrayList<Good> good=gmapper.queryAll(company.getCid());
		model.addAttribute("goodlist", good);
		return "brand-productInput-attr";
	}
	
	@RequestMapping("brand-productInput-attr2")
	public String editPage() {
		return "brand-productInput-attr2";
	}

	@RequestMapping("goodQuery")
	public String backByTitle(String gname,Model model) {
		Company company = (Company)session.getAttribute("company");
		return gservice.backByTitle(gname, company.getCid(),model);
	}
	
	@RequestMapping("delete")
	@ResponseBody
	public String delGood(@RequestBody Good good) {
		
		Company company = (Company)session.getAttribute("company");
		good.setCid(company.getCid());
		int gid=good.getGid();
		//System.out.println(gid);
		return gservice.deleteGood(gid);
	}
	
	
	@RequestMapping("update")
	public String updatePage(int gid,Model model) {
		//System.out.println(gid);
		return gservice.backByGid(gid,model);
		
	}
	
	@RequestMapping("Good")
	@ResponseBody
	public void updateByGid(@RequestBody GoodVo2 obj) {
		//System.out.println(obj.getGid());
		//System.out.println(obj.getAdescription()+"1");
		//System.out.println(obj.getEdescription()+"2");
		Company company = (Company)session.getAttribute("company");
		obj.setCid(company.getCid());
		gservice.updateGood(obj);
	}
	 
}
