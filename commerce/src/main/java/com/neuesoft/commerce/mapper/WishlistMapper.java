package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Wishlist;


public interface WishlistMapper {

	
	@Insert("insert into wishlist (gid,sid) values(#{param1},#{param2})")
	public void addWishlist(int gid ,int sid);
	
	@Select("select  *  from  good g,wishlist w where g.gid=w.gid and w.sid=#{sid}")
	@Results(id="basemap2", value={
			@Result(column="wid", property="wid", id=true),
			@Result(column="sid", property="sid"),
			@Result(column="gid", property="good",
			one=@One(select="com.neuesoft.commerce.mapper.WishlistMapper.queryWishGoodById",fetchType=FetchType.DEFAULT))
		})
	public ArrayList<Wishlist> queryAllWishGood(int sid);
	
	
	@Select("select  *  from  good  where gid=#{gid}")
	@ResultMap("com.neuesoft.commerce.mapper.GoodMapper.basemap")
	public Good queryWishGoodById(int gid);
	
	@Select("select  *  from  wishlist  where gid=#{param1} and sid=#{param2}")
	public Wishlist queryAllWishlist(int gid,int sid);
	
	
	@Delete("delete from wishlist where gid=#{param1} and sid=#{param2}")
	public void deleteWishlist(int gid,int sid);
}
