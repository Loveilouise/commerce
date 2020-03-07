package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class CompanyAccountVo {
	private int ca_id;
	private String ca_pwd;
	private float money;
	public int getCa_id() {
		return ca_id;
	}
	public void setCa_id(int ca_id) {
		this.ca_id = ca_id;
	}
	public String getCa_pwd() {
		return ca_pwd;
	}
	public void setCa_pwd(String ca_pwd) {
		this.ca_pwd = ca_pwd;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	
	
	
}
