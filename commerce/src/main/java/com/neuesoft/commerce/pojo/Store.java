package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;


@Component
public class Store {

	private int store_id;
	private String store_name;
	private int sid;
	private int marketplaceId;
	private String mws;
	private String store_type;
	
	
	
	
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	public String getStore_name() {
		return store_name;
	}
	public void setStore_name(String store_name) {
		this.store_name = store_name;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public int getMarketplaceId() {
		return marketplaceId;
	}
	public void setMarketplaceId(int marketplaceId) {
		this.marketplaceId = marketplaceId;
	}
	public String getMws() {
		return mws;
	}
	public void setMws(String mws) {
		this.mws = mws;
	}
	public String getStore_type() {
		return store_type;
	}
	public void setStore_type(String store_type) {
		this.store_type = store_type;
	}
	
	
	
}
