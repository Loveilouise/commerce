package com.neuesoft.commerce.mapper;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.Good;
import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.SellerAccount;

@Mapper
public interface OrderListMapper {

	@Select("select * from good where gid=#{gid}")
	public Good queryByGid(int gid);

	@Select(" select  * from  orders where ostatus=#{ostatus}")
	@Results(id = "basemap", value = { @Result(column = "oid", property = "oid",id = true),
			@Result(column = "sid", property = "sid"), @Result(column = "ocost", property = "ocost"),
			@Result(column = "ocounts", property = "ocounts"), @Result(column = "createtime", property = "createtime"),
			@Result(column = "ostatus", property = "ostatus"), @Result(column = "orderno", property = "orderno"),
			@Result(column = "trackingno", property = "trackingno"),
			@Result(column = "gid", property = "good", one = @One(select = "com.neuesoft.commerce.mapper.OrderListMapper.queryByGid")) })
	public ArrayList<Orders> backOrderByStatus(int ostatus);

	@Select(" select  * from  orders where   ostatus=#{ostatus}")
	@ResultMap(value = "basemap")
	public ArrayList<Orders> awaitShipOrders(int ostatus);

	@Select(" select  * from  orders where   ostatus=#{ostatus}")
	@ResultMap(value = "basemap")
	public ArrayList<Orders> shipedOrders(int ostatus);

	@Select(" select  * from  orders where   ostatus=#{ostatus}")
	@ResultMap(value = "basemap")
	public ArrayList<Orders> finishedOrders(int ostatus);

	@Select(" select  * from  orders where   ostatus=#{ostatus}")	
	@ResultMap(value = "basemap")
	public ArrayList<Orders> cancelledOrders(int ostatus);
 
	//订单传值
	@Select(" select  * from  orders where   oid=#{oid}")	
	@ResultMap(value = "basemap")
	public  Orders queryByOid(int oid);
	  
	//付款后更改状态
	@Update("update orders set ostatus =1 where oid=#{oid}")
    public void updatePayStatus(int oid); 
	
	
	@Select("select * from orders o,good g where o.gid=g.gid and g.gname like CONCAT (CONCAT('%',#{gname}),'%')")
    @ResultMap(value = "basemap")
    public ArrayList<Orders> searchOrders(String gname);
	
	//显示余额
	@Select("select * from seller_account sa, orders o where o.sid=sa.sid  and o.oid=#{oid}")
	public SellerAccount queryBalanceByOid(int oid);
	
	//查询余额
	@Select("select * from seller_account where sid=#{sid}")
	public SellerAccount queryBySid(int sid);
	
	@Update("update seller_account set sa_money=#{param1} where sid=#{param2}")
	public void updateSaMoney(float money,int sid);
	
	@Select("select * from company_account where cid=#{cid}")
	public CompanyAccount queryComBalance(int cid);
	@Update("update company_account set ca_money=#{param1} where cid=#{param2}")
	public void updateComMoney(float money,int cid);
}
