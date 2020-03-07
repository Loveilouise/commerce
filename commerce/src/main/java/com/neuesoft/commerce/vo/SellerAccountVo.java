package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class SellerAccountVo {

	private int sid;
	private float money;
	private int gid;
	private int cid;
	private int oid;
	private String sa_pwd;
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public String getSa_pwd() {
		return sa_pwd;
	}
	public void setSa_pwd(String sa_pwd) {
		this.sa_pwd = sa_pwd;
	}
	
	
}
