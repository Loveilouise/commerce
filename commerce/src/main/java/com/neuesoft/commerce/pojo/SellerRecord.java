package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class SellerRecord {
	private int sr_id;//流水id 	 
	private int sid;
	private String sr_transact;//流水号
	private float sr_money;//available money
	private String sr_time;//createtime
	private int sr_status;//资金状态
	private String sr_type;
	private SellerAccount sa;
	
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
	}
	
	
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	
	public SellerAccount getSa() {
		return sa;
	}
	public void setSa(SellerAccount sa) {
		this.sa = sa;
	}
	public String getSr_transact() {
		return sr_transact;
	}
	public void setSr_transact(String sr_transact) {
		this.sr_transact = sr_transact;
	}
	public float getSr_money() {
		return sr_money;
	}
	public void setSr_money(float sr_money) {
		this.sr_money = sr_money;
	}
	 
	public String getSr_time() {
		return sr_time;
	}
	public void setSr_time(String sr_time) {
		this.sr_time = sr_time;
	}
	public int getSr_status() {
		return sr_status;
	}
	public void setSr_status(int sr_status) {
		this.sr_status = sr_status;
	}
	public String getSr_type() {
		return sr_type;
	}
	public void setSr_type(String sr_type) {
		this.sr_type = sr_type;
	}
	
	 
	
}
