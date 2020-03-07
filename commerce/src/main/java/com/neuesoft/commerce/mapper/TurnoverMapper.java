package com.neuesoft.commerce.mapper;

 
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.neuesoft.commerce.pojo.SellerRecord;

import java.util.ArrayList;

@Mapper
public interface TurnoverMapper {

    

    /**
     * 借卖方流水
     */
    @Insert("insert into seller_record(sr_transact,sr_time,sr_status,sid,sr_money,sr_type) values(#{sr_transact},#{sr_time},#{sr_status},#{sid},#{sr_money},#{sr_type})")
    public void insertDebitTurnover(SellerRecord turnover);

    @Select("select * from seller_record where sid = #{id}")
    public ArrayList<SellerRecord> selectAllDebitTurnOverByCompanyId(int id);
}
