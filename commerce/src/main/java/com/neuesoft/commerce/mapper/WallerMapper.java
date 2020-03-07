package com.neuesoft.commerce.mapper;

 
import org.apache.ibatis.annotations.*;

import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.SellerAccount;

@Mapper
public interface WallerMapper {
 
    /**
     * 借卖方
     */
    @Insert("insert into seller_account(sid,sa_name,sa_email,sa_pwd,sa_money) values(#{sid},#{sa_name},#{sa_email},#{sa_pwd},#{sa_money})")
    public void insertAccount1(SellerAccount debitWaller);

    @Select("select * from seller_account where sid = #{sid}")
    public SellerAccount selecyDebitWallerByDebitId(int sid);

   /* @Select("select * from seller_account where sa_id = #{id}")
    public SellerAccount selecyDebitWallerByDebitId1(int id);*/

    @Select("select * from seller_account where sa_id = #{sa_id} and sa_pwd = #{sa_pwd}")
    public SellerAccount selecyDebitWallerByWallerId(SellerAccount debitWaller);

    @Update("update seller_account set sa_money = #{sa_money} where sa_id = #{sa_id}")
    public void upddateDebitWaller(SellerAccount debitWaller);

    @Update("update seller_account set sa_pwd = #{param1} where sa_pwd = #{param2} and sid=#{param3}")
    public void updateDebitWallerPassword(@Param("newpassword") String newpassword,
                                          @Param("sa_pwd") String sa_pwd,int sid);
    
    
    @Select("select * from seller_account where sid=#{sid}")
	public SellerAccount queryAccount(int sid);
    
    @Select("select * from seller_account where sid=#{param1} and sa_name=#{param2} and sa_email=#{param3} and sa_pwd=#{param4}")
	public SellerAccount queryloginAccount(int sid,String sa_name,String sa_email,String sa_pwd);
}