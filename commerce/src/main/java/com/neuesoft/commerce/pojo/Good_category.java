package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class Good_category {
	private int gc_id;
	private String gc_category;
	private String gc_picture;
	private int gc_status;
	public int getGc_id() {
		return gc_id;
	}
	public void setGc_id(int gc_id) {
		this.gc_id = gc_id;
	}
	public String getGc_category() {
		return gc_category;
	}
	public void setGc_category(String gc_category) {
		this.gc_category = gc_category;
	}
	public String getGc_picture() {
		return gc_picture;
	}
	public void setGc_picture(String gc_picture) {
		this.gc_picture = gc_picture;
	}
	public int getGc_status() {
		return gc_status;
	}
	public void setGc_status(int gc_status) {
		this.gc_status = gc_status;
	}
	
	
	
}
