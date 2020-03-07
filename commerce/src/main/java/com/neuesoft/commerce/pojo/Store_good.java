package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class Store_good {
	
	private int gids;
	private Good good;
	private int store_id;
	public int getGids() {
		return gids;
	}
	public void setGids(int gids) {
		this.gids = gids;
	}
	public Good getGood() {
		return good;
	}
	public void setGood(Good good) {
		this.good = good;
	}
	public int getStore_id() {
		return store_id;
	}
	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}
	
	

}
