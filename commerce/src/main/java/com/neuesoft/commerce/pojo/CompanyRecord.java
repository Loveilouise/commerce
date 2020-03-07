package com.neuesoft.commerce.pojo;

public class CompanyRecord {
	
	private int cr_id;
	private int cid;
	private String cr_transact;
	private float cr_money;
	private String cr_time;
	private int cr_status;
	private String cr_type;
	private CompanyAccount ca;
	
	public int getCr_id() {
		return cr_id;
	}
	public void setCr_id(int cr_id) {
		this.cr_id = cr_id;
	}
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	public CompanyAccount getCa() {
		return ca;
	}
	public void setCa(CompanyAccount ca) {
		this.ca = ca;
	}
	public String getCr_transact() {
		return cr_transact;
	}
	public void setCr_transact(String cr_transact) {
		this.cr_transact = cr_transact;
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
