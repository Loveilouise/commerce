package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class SellerAccountRecordVo {
	
	private int sa_id;//钱包id
	private int sid;  //借卖方id	 	 
	private String sa_name;
	private int sr_id;//流水id 	 
	private float sr_money;//available money
	private String sr_time;//createtime
	private int sr_status;//资金状态
	private String sr_type;
	public int getSa_id() {
		return sa_id;
	}
	public void setSa_id(int sa_id) {
		this.sa_id = sa_id;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSa_name() {
		return sa_name;
	}
	public void setSa_name(String sa_name) {
		this.sa_name = sa_name;
	}
	public int getSr_id() {
		return sr_id;
	}
	public void setSr_id(int sr_id) {
		this.sr_id = sr_id;
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
