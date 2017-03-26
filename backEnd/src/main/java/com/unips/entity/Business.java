package com.unips.entity;

import java.util.List;

import com.unips.constants.BusinessConstants.BusinessCategory;

public class Business  extends User{
	
	
	private String name;
	private long phone;
	private long phoneBusiness;
	
	private String hours;
	
	private int rateAverage;
	
	private List<Comment> comments;
	private List<Rating> ratings;
	private Address address;
	
	private BusinessCategory category;


	@Override
	public String toString() {
		return "Business [name=" + name + ", phone=" + phone + ", phoneBusiness=" + phoneBusiness + ", hours=" + hours
				+ ", rateAverage=" + rateAverage + ", comments=" + comments + ", ratings=" + ratings + ", address="
				+ address + ", category=" + category + ", toString()=" + super.toString() + ", getToken()=" + getToken()
				+ ", getId()=" + getId() + ", getCreatedDate()=" + getCreatedDate() + ", getUsername()=" + getUsername()
				+ ", getPassword()=" + getPassword() + ", getEmail()=" + getEmail() + ", getQuestion1()="
				+ getQuestion1() + ", getQuestion2()=" + getQuestion2() + ", getPictureFeatured()="
				+ getPictureFeatured() + ", getPictures()=" + getPictures() + ", getDescription()=" + getDescription()
				+ ", getStatus()=" + getStatus() + ", getRole()=" + getRole() + "]";
	}
	
	public BusinessCategory getCategory() {
		return category;
	}
	public void setCategory(BusinessCategory category) {
		this.category = category;
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
	public List<Comment> getComments() {
		return comments;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	public List<Rating> getRatings() {
		return ratings;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
}
