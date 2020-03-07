package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class CompanyAccount {
	private int ca_id;
	private int cid;
	private String ca_name;
	private String ca_email;
	private String ca_pwd;
	private float ca_money;

	
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
	public String getCa_email() {
		return ca_email;
	}
	public void setCa_email(String ca_email) {
		this.ca_email = ca_email;
	}
	public String getCa_pwd() {
		return ca_pwd;
	}
	public void setCa_pwd(String ca_pwd) {
		this.ca_pwd = ca_pwd;
	}
	public float getCa_money() {
		return ca_money;
	}
	public void setCa_money(float ca_money) {
		this.ca_money = ca_money;
	}
	
	
	
	
}
