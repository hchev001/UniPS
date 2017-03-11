package com.unips.entity;

import java.util.Date;
import java.util.List;

import com.unips.constants.BusinessConstants.UserRoles;
import com.unips.constants.BusinessConstants.UserStatus;

public class UserInfo {

	private int id;
	private Date createdDate;

	private String username;
	private String password;
	private String email;
	private String question1;
	private String question2;
	private String pictureFeatured;
	private List<String> pictures;
	private String description;

	private UserStatus status;
	private UserRoles authority;
	
	//Only needed for the authorization to work.
	private String role;

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", createdDate=" + createdDate + ", username=" + username + ", password="
				+ password + ", email=" + email + ", question1=" + question1 + ", question2=" + question2
				+ ", pictureFeatured=" + pictureFeatured + ", pictures=" + pictures + ", description=" + description
				+ ", status=" + status + ", role=" + role + ", authority=" + authority + "]";
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

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public UserRoles getAuthority() {
		return authority;
	}

	public void setAuthority(UserRoles authority) {
		this.authority = authority;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
