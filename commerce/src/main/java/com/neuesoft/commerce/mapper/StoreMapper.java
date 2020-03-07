package com.neuesoft.commerce.mapper;


import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Store;
import com.neuesoft.commerce.pojo.Store_good;


//通过获取store的借卖方id(sid)，展示对应的stores名字
//存入store的商品gids
//通过store_id获取商铺对应的商品

public interface StoreMapper {

	@Select("select  *  from  store  where sid=#{sid}")
	public ArrayList<Store> querystoresById(int sid);
	
	@Insert("insert into  store_good  (gid,store_id) values(#{param1},#{param2})")
	public void addStoreGood(int gid ,int store_id);
	
	
	@Select("select  *  from  store_good sg,good g where g.gid=sg.gid and sg.store_id=#{store_id}")
	@Results(id="basemap3", value={
			@Result(column="gids", property="gids", id=true),
			@Result(column="store_id", property="store_id"),
			@Result(column="gid", property="good",
			one=@One(select="com.neuesoft.commerce.mapper.StoreMapper.queryStoreGoodById",fetchType=FetchType.DEFAULT))
		})
	public ArrayList<Store_good> querygoodsByStoreId(int store_id);
	
	
	
	@Select("select  *  from  good  where gid=#{gid}")
	@ResultMap("com.neuesoft.commerce.mapper.GoodMapper.basemap")
	public Good queryStoreGoodById(int gid);
	
	
	@Select("select  *  from  store  where store_id=#{store_id}")
	public Store querystoreByStoreId(int store_id);
}
