package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class CompanyAccountRecordVo {
	
	private int ca_id;
	private int cid;
	private String ca_name;
	private int cr_id;
	private float cr_money;
	private String cr_time;
	private int cr_status;
	private String cr_type;
	public int getCa_id() {
		return ca_id;
	}
	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCa_name() {
		return ca_name;
	}
	public void setCa_name(String ca_name) {
		this.ca_name = ca_name;
	}
	public int getCr_id() {
		return cr_id;
	}
	public void setCr_id(int cr_id) {
		this.cr_id = cr_id;
	}
	public float getCr_money() {
		return cr_money;
	}
	public void setCr_money(float cr_money) {
		this.cr_money = cr_money;
	}
	public String getCr_time() {
		return cr_time;
	}
	public void setCr_time(String cr_time) {
		this.cr_time = cr_time;
	}
	public int getCr_status() {
		return cr_status;
	}
	public void setCr_status(int cr_status) {
		this.cr_status = cr_status;
	}
	public String getCr_type() {
		return cr_type;
	}
	public void setCr_type(String cr_type) {
		this.cr_type = cr_type;
	}
	
	

}
