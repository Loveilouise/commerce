package com.neuesoft.commerce.pojo;

public class Company {
	private int cid;
	private String ccname;
	private String cename;
	private String cinfo;
	private String ctype;
	private String curl;
	private String cpassword;
	
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCcname() {
		return ccname;
	}
	public void setCcname(String ccname) {
		this.ccname = ccname;
	}
	public String getCename() {
		return cename;
	}
	public void setCename(String cename) {
		this.cename = cename;
	}
	public String getCinfo() {
		return cinfo;
	}
	public void setCinfo(String cinfo) {
		this.cinfo = cinfo;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}
	
	
	
	public String getCpassword() {
		return cpassword;
	}
	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}
	@Override
	public String toString() {
		return "Company [cid=" + cid + ", ccname=" + ccname + ", cename=" + cename + ", cinfo=" + cinfo + ", ctype="
				+ ctype + ", curl=" + curl + "]";
	}
	
	
}
