package com.neuesoft.commerce.pojo;

import org.springframework.stereotype.Component;

@Component
public class Good {
	private int gid;
	private int gc_id;
	private Good_category category;
	
	private String gname;
	private float gprice;
	private int gcounts;
	private String gsku;
	private float length;
	private float width;
	private float height;
	private float weight;
	private String upc;
	private String ena;
	private String model;
	private String maintain;
	private String edescription;
	private String adescription;
	
	private int cid;  //拿品牌商的cid
	
	
	public int getGid() {
		return gid;
	}
	public void setGid(int gid) {
		this.gid = gid;
	}
	public int getGc_id() {
		return gc_id;
	}
	public void setGc_id(int gc_id) {
		this.gc_id = gc_id;
	}
	public Good_category getCategory() {
		return category;
	}
	public void setCategory(Good_category category) {
		this.category = category;
	}
	public String getGname() {
		return gname;
	}
	public void setGname(String gname) {
		this.gname = gname;
	}
	public float getGprice() {
		return gprice;
	}
	public void setGprice(float gprice) {
		this.gprice = gprice;
	}
	public int getGcounts() {
		return gcounts;
	}
	public void setGcounts(int gcounts) {
		this.gcounts = gcounts;
	}
	public String getGsku() {
		return gsku;
	}
	public void setGsku(String gsku) {
		this.gsku = gsku;
	}
	public float getLength() {
		return length;
	}
	public void setLength(float length) {
		this.length = length;
	}
	public float getWidth() {
		return width;
	}
	public void setWidth(float width) {
		this.width = width;
	}
	public float getHeight() {
		return height;
	}
	public void setHeight(float height) {
		this.height = height;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public String getUpc() {
		return upc;
	}
	public void setUpc(String upc) {
		this.upc = upc;
	}
	public String getEna() {
		return ena;
	}
	public void setEna(String ena) {
		this.ena = ena;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getMaintain() {
		return maintain;
	}
	public void setMaintain(String maintain) {
		this.maintain = maintain;
	}
	public String getEdescription() {
		return edescription;
	}
	public void setEdescription(String edescription) {
		this.edescription = edescription;
	}
	public String getAdescription() {
		return adescription;
	}
	public void setAdescription(String adescription) {
		this.adescription = adescription;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	
	
	
}
