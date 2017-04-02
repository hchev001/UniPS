package com.unips.entity;

import com.unips.constants.BusinessConstants.BusinessCategory;

public class BusinessSearchResult {
	
	private String email;
	private String pictureFeatured;
	private String description;
	private String name;
	private long phone;
	private long phoneBusiness;
	private String hours;
	private int rateAverage;
	private BusinessCategory category;
	
	@Override
	public String toString() {
		return "BusinessSearchResult [email=" + email + ", pictureFeatured=" + pictureFeatured + ", description="
				+ description + ", name=" + name + ", phone=" + phone + ", phoneBusiness=" + phoneBusiness + ", hours="
				+ hours + ", rateAverage=" + rateAverage + ", category=" + category + "]";
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPictureFeatured() {
		return pictureFeatured;
	}
	public void setPictureFeatured(String pictureFeatured) {
		this.pictureFeatured = pictureFeatured;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public long getPhoneBusiness() {
		return phoneBusiness;
	}
	public void setPhoneBusiness(long phoneBusiness) {
		this.phoneBusiness = phoneBusiness;
	}
	public String getHours() {
		return hours;
	}
	public void setHours(String hours) {
		this.hours = hours;
	}
	public int getRateAverage() {
		return rateAverage;
	}
	public void setRateAverage(int rateAverage) {
		this.rateAverage = rateAverage;
	}
	public BusinessCategory getCategory() {
		return category;
	}
	public void setCategory(BusinessCategory category) {
		this.category = category;
	}
	
	
	
}
