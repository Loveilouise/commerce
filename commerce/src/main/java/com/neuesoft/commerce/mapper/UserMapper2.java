package com.neuesoft.commerce.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.Seller;

@Mapper
public interface UserMapper2 {

	/*@Insert("insert into seller(sname,semail,sphone) values(#{sname},#{semail},#{sphone})")
	public void insertSeller(Seller seller);
	
	@Select("select * from seller where sname=#{sname} and semail=#{semail} and sphone=#{sphone}")
	public Seller querySeller(Seller seller);*/
	
	@Insert("insert into seller(sname,spassword) values(#{sname},#{spassword})")
	public void insertSeller(Seller seller);
	
	@Select("select * from seller where sname=#{sname} and spassword=#{spassword}")
	public Seller querySeller(Seller seller);
	
	@Insert("insert into company(cename,cpassword) values(#{cename},#{cpassword})")
	public void insertCompany(Company company);
	
	@Select("select * from company where cename=#{cename} and cpassword=#{cpassword}")
	public Company queryCompany(Company company);
	
	
}
