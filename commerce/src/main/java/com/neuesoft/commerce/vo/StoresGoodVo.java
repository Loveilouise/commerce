package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class StoresGoodVo {
	
	private String stores;
	
	private int gid;
	
	private int value;

	public String getStores() {
		return stores;
	}

	public void setStores(String stores) {
		this.stores = stores;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}
	
	
	
	

}
