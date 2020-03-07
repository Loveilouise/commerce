package com.neuesoft.commerce.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neuesoft.commerce.common.Resource;
import com.neuesoft.commerce.common.Result;
import com.neuesoft.commerce.mapper.OrderListMapper;
import com.neuesoft.commerce.pojo.CompanyAccount;
import com.neuesoft.commerce.pojo.Orders;
import com.neuesoft.commerce.pojo.SellerAccount;
import com.neuesoft.commerce.vo.SellerAccountVo;

@Service
public class PayService {
	@Autowired
	private OrderListMapper bvoOrdersMapper;
	
    public Orders backOrderPayment(int oid) {
    	return bvoOrdersMapper.queryByOid(oid);
    }
	
    public SellerAccount backBalance(int oid) {
    	System.out.println(oid);
    	return bvoOrdersMapper.queryBalanceByOid(oid);
    }

    
    public String checkBalance(SellerAccountVo obj) {	
    	SellerAccount saccount=bvoOrdersMapper.queryBySid(obj.getSid());   	
    	//int said=saccount.getSa_id();
    	if(obj.getSa_pwd().equals(saccount.getSa_pwd())) {
    		if(saccount.getSa_money()<obj.getMoney()) {
        		return "余额不足!";
        	}else {
        		//借卖方的余额=目前的余额-要付的钱
        		float  paymoney=saccount.getSa_money()-obj.getMoney();
        		CompanyAccount ca=bvoOrdersMapper.queryComBalance(obj.getCid());
        		//品牌商的余额=目前的余额+借卖方付的钱
        		float totalmoney=ca.getCa_money()+obj.getMoney();
        		System.out.println(totalmoney+"zongjia");        		
        		//把订单的代付款状态改成已付款
        		bvoOrdersMapper.updatePayStatus(obj.getOid());
        		//将钱包里的钱口扣除
        		bvoOrdersMapper.updateSaMoney(paymoney, obj.getSid());
        		//品牌商的钱包的钱增加
        		bvoOrdersMapper.updateComMoney(totalmoney, obj.getCid());
        		return "付款成功!";
        	}
    	}
    	else {
    		return "密码错误,请重新输入！";
    		}	
	 }
}
