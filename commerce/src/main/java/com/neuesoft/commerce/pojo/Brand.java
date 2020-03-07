package com.neuesoft.commerce.pojo;

public class Brand {
	private Integer bid;
	private Integer cid;
	private String bname;
	private String blogo;
	public Integer getBid() {
		return bid;
	}
	public void setBid(Integer bid) {
		this.bid = bid;
	}
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public String getBlogo() {
		return blogo;
	}
	public void setBlogo(String blogo) {
		this.blogo = blogo;
	}
	@Override
	public String toString() {
		return "Brand [bid=" + bid + ", cid=" + cid + ", bname=" + bname + ", blogo=" + blogo + "]";
	}
	
	
	
}
