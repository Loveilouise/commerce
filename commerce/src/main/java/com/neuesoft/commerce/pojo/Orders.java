package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class Orders {

	private int oid;

	private Good good;
	private int cid;
	private int sid;
	private int ocounts;
	private String createtime;
	private int ostatus;
	private String trackingno;
	private String orderno;
	private float ocost;
	private Seller seller;
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getOcounts() {
		return ocounts;
	}
	public void setOcounts(int ocounts) {
		this.ocounts = ocounts;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public int getOstatus() {
		return ostatus;
	}
	public void setOstatus(int ostatus) {
		this.ostatus = ostatus;
	}
	public String getTrackingno() {
		return trackingno;
	}
	public void setTrackingno(String trackingno) {
		this.trackingno = trackingno;
	}
	public String getOrderno() {
		return orderno;
	}
	public void setOrderno(String orderno) {
		this.orderno = orderno;
	}
	public float getOcost() {
		return ocost;
	}
	public void setOcost(float ocost) {
		this.ocost = ocost;
	}
	public Seller getSeller() {
		return seller;
	}
	public void setSeller(Seller seller) {
		this.seller = seller;
	}
	
	
}
