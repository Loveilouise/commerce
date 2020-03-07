package com.neuesoft.commerce.mapper;

import java.util.ArrayList;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Param;

import com.neuesoft.commerce.pojo.Orders;

public interface OrdersMapper {
	
	
	//生成orders时：订单编号为随机字符串、总价为数量*价格、订单创建时间获取当前时间、订单状态为0(待支付)
	@Insert("insert into orders  (gid,sid,ocounts,orderno,createtime,ostatus,ocost) "
			+ "values(#{param1},#{param2},#{param3},#{param4},#{param5},#{param6},#{param3}*#{param7})")
	public void addOrders(int gid ,int sid, int ocounts, String orderno,
			String createtime,int ostatus,float gprice);
	
	
	//显示订单列表
		@Select("select * from orders o, good g where o.gid=g.gid and g.cid=#{cid} ")
		@Results(id = "resultMap", value ={
				@Result(id = true,column="oid",property="oid"),
				  @Result(column="sid",property="sid"),
				  @Result(column="ocost",property="ocost"),
				  @Result(column="createtime",property="createtime"),
				  @Result(column="trackingno",property="trackingno"),
				  @Result(column="orderno",property="orderno"),
				  @Result(column="ocounts",property="ocounts"),
				  @Result(column="ostatus",property="ostatus"),
				  @Result(property ="good",column="gid",
		            one =@One(select ="com.neuesoft.commerce.mapper.GoodMapper.queryByGid"))} )
		public ArrayList<Orders> queryAll(int cid);
		
		//根据商品标题查询
		@Select("select * from orders o,good g where o.gid=g.gid and g.cid=#{param2} and g.gname like  CONCAT(CONCAT('%',#{param1}),'%') ")
		@ResultMap("resultMap")
		public ArrayList<Orders> queryByTitle(String gname,int cid);
		
		//取消订单
		@Update("update orders set ostatus=#{ostatus} where oid=#{oid}")
		public void updateCancelStatus(@Param("oid")int oid,@Param("ostatus")int ostatus);
		
		//订单发货
		@Update("update orders set ostatus=#{ostatus},trackingno=#{trackingno} where oid=#{oid}")
		public void updateSendStatus(@Param("oid")int oid,@Param("trackingno")String trackingno,@Param("ostatus")int ostatus);
		
		//用来查询商品是否在订单中
		@Select("select * from orders o,good g where g.gid=#{gid} and o.gid=g.gid")
		@ResultMap("resultMap")
		public ArrayList<Orders> backOrderByGid(int gid);
}
