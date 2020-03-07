package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.CompanyRecord;

@Mapper
public interface BrandWallerMapper {

	@Insert("insert into company_account(ca_name,ca_email,ca_pwd,cid,ca_money) values(#{ca_name},#{ca_email},#{ca_pwd},#{cid},#{ca_money})")
	public void insertCompanyAccount(CompanyAccount companyAccount);
	
	/*@Select("select * from company_account where cid=#{cid}")
	public ArrayList<CompanyAccount> queryAccount(int cid);*/
	
	@Select("select * from company_account where cid=#{cid}")
	public CompanyAccount queryAccount(int cid);
	
	@Select("select * from company_account where cid=#{param1} and ca_name=#{param2} and ca_email=#{param3} and ca_pwd=#{param4}")
	public CompanyAccount queryloginAccount(int cid,String ca_name,String ca_email,String ca_pwd);
	
	
	@Select("select * from company_account where ca_id=#{ca_id}")
	public CompanyAccount queryAccountPwd(int ca_id);
	
	@Update("update company_account set ca_money=#{param1} where ca_id=#{param2}")
	public void updateAccount(float ca_money,int ca_id);
	
	
	@Insert("insert into company_record(cid,cr_transact,cr_money,cr_time,cr_status,cr_type) values(#{cid},#{cr_transact},#{cr_money},#{cr_time},#{cr_status},#{cr_type})")
	public void insertCompanyRecord(CompanyRecord companyRecord);

	
	@Select("select * from company_record where cid=#{cid}")
	public ArrayList<CompanyRecord> queryRecord(int cid);
}
