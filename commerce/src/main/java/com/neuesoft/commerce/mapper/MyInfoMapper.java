package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.Seller;
import com.neuesoft.commerce.pojo.Store;



@Mapper
public interface MyInfoMapper {
	
	@Update("update seller set sname=#{sname},semail=#{semail},sphone=#{sphone} where sid=#{sid}")
	public void updateSeller(Seller seller);
	
	@Insert("insert into store(store_name,sid,marketplaceId,mws,store_type) values(#{store_name},#{sid},#{marketplaceId},#{mws},#{store_type})")
	public void insertStore(Store store);
	
	@Select("select * from store where store_type='Amazon' and sid=#{sid}")
	public ArrayList<Store> queryAmazon(int sid);
	
	@Select("select * from store where store_type='eBay' and sid=#{sid}")
	public ArrayList<Store> queryeBay(int sid);
	
	@Select("select * from good where gid=#{gid}")
	public Good queryByGid(int gid);
	
	
	@Select("select * from orders where ostatus=0 and sid=#{sid}")
	@Results(id = "basemap", value = { @Result(column = "oid", property = "oid", id = true),
			@Result(column = "sid ", property = "sid"),
			@Result(column = "ocost", property = "ocost"), 
			@Result(column = "ocounts", property = "ocounts"),
			@Result(column = "createtime", property = "createtime"), 
			@Result(column = "ostatus", property = "ostatus"),
			@Result(column = "orderno", property = "orderno"),
			@Result(column = "trackingno", property = "trackingno"),
			@Result(column = "gid", property = "good", one = @One(select = "com.neuesoft.commerce.mapper.MyInfoMapper.queryByGid")) })
	public ArrayList<Orders> backOrderByStatus(int sid);
	
	@Select("select * from orders where ostatus=1 and sid=#{sid}")
	@ResultMap("basemap")
	public ArrayList<Orders> backOrderByStatus1(int sid);
	
	@Select("select * from orders where ostatus=2 and sid=#{sid}")
	@ResultMap("basemap")
	public ArrayList<Orders> backOrderByStatus2(int sid);
	
	@Select("select * from orders where ostatus=3 and sid=#{sid}")
	@ResultMap("basemap")
	public ArrayList<Orders> backOrderByStatus3(int sid);
	
	@Select("select * from orders where ostatus=4 and sid=#{sid}")
	@ResultMap("basemap")
	public ArrayList<Orders> backOrderByStatus4(int sid);
	
	

}
