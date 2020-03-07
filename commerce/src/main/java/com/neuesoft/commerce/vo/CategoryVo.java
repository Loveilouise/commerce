package com.neuesoft.commerce.vo;

import org.springframework.stereotype.Component;

@Component
public class CategoryVo {

	private int gid;
	
	private int gcid;

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public int getGcid() {
		return gcid;
	}

	public void setGcid(int gcid) {
		this.gcid = gcid;
	}

	
	
}
