package com.neuesoft.commerce.mapper;


import org.apache.ibatis.annotations.*;

import com.neuesoft.commerce.pojo.Company;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.CompanyRecord;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.SellerAccount;
import com.neuesoft.commerce.pojo.SellerRecord;

import java.util.ArrayList;


public interface AuditMapper {
	
    //展示全部流水
    @Select("select * from company_record  where cr_status =0 ")
    @Results(id="crMap1",value ={
            @Result(id=true, column = "cr_id",property = "cr_id"),
            @Result(column = "cr_transact",property = "cr_transact"),
            @Result(column = "cr_money",property = "cr_money"),
            @Result(column = "cr_time",property = "cr_time"),
            @Result(column = "cr_status",property = "cr_status"),
            @Result(column = "cr_type",property = "cr_type"),
         
            @Result(column = "cid",property ="ca",one=@One(select = "com.neuesoft.commerce.mapper.AuditMapper.getcacount"))
    })
    public ArrayList<CompanyRecord> showallCrecords();

    @Select("select * from company_account where cid=#{cid}")
    public CompanyAccount getcacount(int cid);

    //展示借卖方全部流水
    @Select("select * from seller_record where sr_status =0")
    @Results({
            @Result(column = "sr_id",property = "sr_id"),      
            @Result(column = "sr_transact",property = "sr_transact"),
            @Result(column = "sr_money",property = "sr_money"),
            @Result(column = "sr_time",property = "sr_time"),
            @Result(column = "sr_status",property = "sr_status"),
            @Result(column = "sr_type",property = "sr_type"),
            @Result(column = "sid",property ="sa",one=@One(select ="com.neuesoft.commerce.mapper.AuditMapper.getsacount"))
    })
    public ArrayList<SellerRecord> showallSrecords();

    @Select("select * from seller_account where sid=#{sid}")
    public SellerAccount getsacount(int sid);
    
    //提现 捡钱
    @Update("update company_account set ca_money=#{param2} where cid=#{param1}")
    public void divMoney(int id,float money);
    @Update("update company_record set cr_status=#{param2} where cid=#{param1}")
    public void updateCaStatus(int id,int status);
    
    @Select("select * from seller_account where sid=#{sid}")
    public SellerAccount queryMoney(int sid);
    
    @Select("select * from company_account where cid=#{cid}")
    public CompanyAccount queryMoney2(int cid);
    
    //充值 加钱
    @Update("update seller_account set sa_money=#{param2} where sid=#{param1}")
    public void addMoney(int id,float money);
    @Update("update seller_record set sr_status=#{param2} where sid=#{param1}")
    public void updateCaStatus2(int id,int status);
}
