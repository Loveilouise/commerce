package com.neuesoft.commerce.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neuesoft.commerce.mapper.CompanyMyInfoMapper;
import com.neuesoft.commerce.pojo.Brand;
import com.neuesoft.commerce.pojo.Company;

@Controller
public class BrandMyInfoController {
	@Autowired
	private CompanyMyInfoMapper companyMyInfoMapper;

	// 跳转至编辑公司
	@RequestMapping("/brand-addbrand")
	public String brand_addbrand() {
		return "brand-addbrand";
	}

	// 跳转品牌商我的信息
	@RequestMapping("/brand-brandInput")
	public String brand_input(Model model, HttpSession session) {
		Company c = (Company) session.getAttribute("company");

		ArrayList<Brand> brandList = (ArrayList<Brand>) companyMyInfoMapper.queryCompanyBrand(c.getCid());
		model.addAttribute("brandList", brandList);
		return "brand-brandInput";
	}

	// 更新我的信息并跳回
	@RequestMapping(value = "/updateMyCompanyInfo", method = RequestMethod.POST)
	@ResponseBody
	public String updateCompanyInfo(HttpSession session, @Param("ccname") String ccname, @Param("cename") String cename,
			@Param("cinfo") String cinfo, @Param("ctype") String ctype, @Param("curl") String curl) {
		Company c = (Company) session.getAttribute("company");
		c.setCcname(ccname);
		c.setCename(cename);
		c.setCinfo(cinfo);
		c.setCtype(ctype);
		c.setCurl(curl);
		companyMyInfoMapper.updateCompany(c);
		return "brand-brandInput";
	}

	// 删除公司的品牌
	@RequestMapping(value = "/delCompanyBrand", method = RequestMethod.GET)
	@ResponseBody
	public String delCompanyBrand(HttpSession session, @Param("bid") int bid) {
		companyMyInfoMapper.delectCompanyBrand(bid);
		return "brand-brandInput";
	}

	// 更新品牌信息
	@RequestMapping(value = "/updateBrand", method = RequestMethod.POST)
	@ResponseBody
	public String updateBrandInfo(@Param("bid") int bid, @Param("bname") String bname, @Param("blogo") String blogo) {

		companyMyInfoMapper.updateBrand(bid, bname, blogo);
		return "success";
	}

	// 插入品牌信息
	@RequestMapping(value = "/insertBrand", method = RequestMethod.POST)
	@ResponseBody
	public String insertBrandInfo( HttpSession session,@Param("bname") String bname, @Param("blogo") String blogo) {
		Company c = (Company) session.getAttribute("company");
		companyMyInfoMapper.insertBrand( c.getCid(),bname, blogo);
		return "success";
	}
}
