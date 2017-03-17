package com.unips.entity;

import java.util.Date;
import java.util.List;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;

public class Business {
	
	private int id;
	private Date createdDate;
	
	private String username;
	private String password;
	private String name;
	private long phone;
	private long phoneBusiness;
	private String email;
	private String question1;
	private String question2;
	
	private String pictureFeatured;
	private List<String> pictures;
	
	private String description;
	private String hours;
	
	private int rateAverage;
	
	private List<Comment> comments;
	private List<Rating> ratings;
	private Address address;
	
	
	private Status status;
	private Roles role;
	private String token;
	
	
	@Override
	public String toString() {
		return "Business [id=" + id + ", createdDate=" + createdDate + ", username=" + username + ", password="
				+ password + ", name=" + name + ", phone=" + phone + ", phoneBusiness=" + phoneBusiness + ", email="
				+ email + ", question1=" + question1 + ", question2=" + question2 + ", pictureFeatured="
				+ pictureFeatured + ", pictures=" + pictures + ", description=" + description + ", hours=" + hours
				+ ", rateAverage=" + rateAverage + ", comments=" + comments + ", ratings=" + ratings + ", address="
				+ address + ", status=" + status + ", role=" + role + ", token=" + token + "]";
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQuestion1() {
		return question1;
	}
	public void setQuestion1(String question1) {
		this.question1 = question1;
	}
	public String getQuestion2() {
		return question2;
	}
	public void setQuestion2(String question2) {
		this.question2 = question2;
	}
	public String getPictureFeatured() {
		return pictureFeatured;
	}
	public void setPictureFeatured(String pictureFeatured) {
		this.pictureFeatured = pictureFeatured;
	}
	public List<String> getPictures() {
		return pictures;
	}
	public void setPictures(List<String> pictures) {
		this.pictures = pictures;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
}
