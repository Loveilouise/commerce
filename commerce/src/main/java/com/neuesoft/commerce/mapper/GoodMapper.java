package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.mapping.FetchType;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Good_category;
import com.neuesoft.commerce.vo.GoodVo2;

public interface GoodMapper {
	
	@Select("select  *  from   good g,good_category gc where g.gc_id=gc.gc_id")
	@Results(id="basemap", value={
			@Result(column="gid", property="gid", id=true),
			@Result(column="gname", property="gname"),
			@Result(column="gprice", property="gprice"),
			@Result(column="gsku", property="gsku"),
			@Result(column="model", property="model"),
			@Result(column="maintain", property="maintain"),
			@Result(column="gcounts", property="gcounts"),
			@Result(column="edescription", property="edescription"),
			@Result(column="adescription", property="adescription"),
			@Result(column="gc_id", property="category",
			one=@One(select="com.neuesoft.commerce.mapper.GoodMapper.queryCategoryById",fetchType=FetchType.DEFAULT))
		})
	public ArrayList<Good> queryAllGood();

	@Select("select  *  from  good_category  where gc_id=#{gc_id}")
	public Good_category queryCategoryById(int gc_id);
	
	@Select("select  *  from  good  where gid=#{gid}")
	@ResultMap("basemap")
	public Good queryGoodById(int gid);
	
	
	@Select("update good set gcounts=#{param1} where gid=#{param2}")
	public void updateGoodById(int gcounts,int gid);
	
	
	//订单中连表用的 固定方法
		@Select("select * from good where gid=#{gid}")
		public Good queryByGid(int gid);
		
	/*	@Select("select * from good where gid=#{gid}")
		public ArrayList<Good> queryByGid2(int gid);*/
		
		//显示商品列表
		@Select("select * from good where cid=#{cid}")
		public ArrayList<Good> queryAll(int cid);
		
		//商品标题查询
		@Select("select * from good where cid=#{param2} and gname like CONCAT(CONCAT('%',#{param1}),'%') ")
		public ArrayList<Good> queryByTitle(String gname,int cid);
		
		//商品删除
		@Delete("delete from good where gid=#{gid}")
		public void deleteByGid(int gid);
		
		//商品新增
		@Insert("insert into good(cid,gname,gprice,gcounts,gsku,length,width,height,weight,upc,ena,model,maintain,edescription,adescription) "
				+ "values(#{cid},#{gname},#{gprice},#{gcounts},#{gsku},#{length},#{width},#{height},"
				+ "#{weight},#{upc},#{ena},#{model},#{maintain},#{edescription},#{adescription}) ")
		public void insertGood(GoodVo2 obj);
		
		//商品更新
		@Update("update good set gname=#{gname},gprice=#{gprice},gcounts=#{gcounts},gsku=#{gsku},"
				+ "length=#{length},width=#{width},height=#{height},weight=#{weight},upc=#{upc},ena=#{ena},"
				+ "model=#{model},maintain=#{maintain},edescription=#{edescription},adescription=#{adescription} "
				+ "where gid=#{gid}")
		public void updateByGid(GoodVo2 obj);
		
		//当新增分类时 将对应的id 插入商品表中
		@Update("update good set gc_id=#{param2} where gid=#{param1}")
		public void updateGcid(String gid,int gc_id);
}
