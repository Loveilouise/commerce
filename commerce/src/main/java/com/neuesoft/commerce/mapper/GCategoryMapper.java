package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Good_category;

public interface GCategoryMapper {

	//显示主图列表
	@Select("select * from good g ,good_category gc where g.cid=#{cid} and g.gc_id=gc.gc_id")
	/*@Select("select * from good g  where cid=#{cid} ")*/
	@Results(id = "cateMap", value ={
			@Result(id = true,column="gid",property="gid"),
			  @Result(column="cid",property="cid"),
			  @Result(column="gname",property="gname"),
			  @Result(property ="category",column="gc_id",
	            one =@One(select ="com.neuesoft.commerce.mapper.GCategoryMapper.queryByGcid"))} )
	public ArrayList<Good> queryCategory(int cid);
	
	@Select("select * from good_category where gc_id=#{gc_id}")
	public Good_category queryByGcid(int gc_id);
	
	//主图模块的查询
	@Select("select * from  good g ,good_category gc where g.cid=#{cid} and g.gc_id=gc.gc_id and g.gname like CONCAT(CONCAT('%',#{gname}),'%')")
	@ResultMap("cateMap")
	public ArrayList<Good> queryByTitle(@Param("gname")String gname,@Param("cid")int cid);
	
	//更新商品入仓、上架等的状态
	@Update("update good_category set gc_status=#{param1} where gc_id=#{param2}")
	public void updateStatus(int gc_status,String gc_id);
	
	/*@Select("select * from good g ,good_category gc where g.cid=#{cid} ")
	@ResultMap("cateMap")
	public ArrayList<Good> queryALL(int cid);*/
	
	//显示未进行分类商品的标题
	@Select("select * from good g  where cid=#{cid} and gc_id is null")
	public ArrayList<Good> queryALL(int cid);
	
	//新增分类 并返回新增的
	@Insert("insert good_category(gc_category,gc_picture,gc_status) values(#{gc_category},#{gc_picture},1)")
	@Options(useGeneratedKeys = true, keyProperty = "gc_id",keyColumn = "gc_id")
	public void insertCategory(Good_category obj);
	
	//返回未进行分类的商品的标题
	@Select("select * from good g ,good_category gc where  g.gc_id=gc.gc_id")
	@ResultMap("cateMap")
	public ArrayList<Good> queryForUpdate(int gc_id);
	
	//更新商品分类表
	@Update("update good_category set gc_category=#{param1},gc_picture=#{param2} where gc_id=#{param3}")
	public void updateCategory(String category,String fileName,String gcid);
	
	@Update("update good_category set gc_category=#{param1} where gc_id=#{param2}")
	public void updateCategory2(String category,String gcid);
	
	@Update("update good set gname=#{param2} where gc_id=#{param1}")
	public void updateGoodTitle(String gcid,String gname);
	
	//删除分类
	@Delete("delete from good_category where gc_id=#{gc_id}")
	public void deleteCategory(int gc_id);
	
	@Update("update good set gc_id=null where gc_id=#{param1} and gid=#{param2}")
	public void deleteGcid(int gc_id,int gid);
	@Delete("delete from good where gc_id=#{param1} and gid=#{param2}")
	public void deleteByGcid(int gc_id,int gid);
}
