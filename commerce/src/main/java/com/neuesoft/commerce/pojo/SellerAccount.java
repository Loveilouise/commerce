package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class SellerAccount {
	private int sa_id;//钱包id
	private int sid;  //借卖方id	 	 
	private String sa_name;
	private String sa_pwd;
	private String sa_email;
	private float sa_money;
	
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
	public String getSa_pwd() {
		return sa_pwd;
	}
	public void setSa_pwd(String sa_pwd) {
		this.sa_pwd = sa_pwd;
	}
	public String getSa_email() {
		return sa_email;
	}
	public void setSa_email(String sa_email) {
		this.sa_email = sa_email;
	}
	public float getSa_money() {
		return sa_money;
	}
	public void setSa_money(float sa_money) {
		this.sa_money = sa_money;
	}
	
	
}
