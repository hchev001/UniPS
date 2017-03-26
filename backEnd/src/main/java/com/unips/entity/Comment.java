package com.unips.entity;

import java.sql.Date;

import com.unips.constants.BusinessConstants.CommentFlag;

public class Comment {
	
	private int id;
	private Date createdDate;
	private String subject;
	private String body;
	private CommentFlag flag;
	private int userId;
	private int bussinessId;
	
	
	@Override
	public String toString() {
		return "Comment [id=" + id + ", createdDate=" + createdDate + ", subject=" + subject + ", body=" + body
				+ ", flag=" + flag + ", userId=" + userId + ", bussinessId=" + bussinessId + "]";
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
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public CommentFlag getFlag() {
		return flag;
	}
	public void setFlag(CommentFlag flag) {
		this.flag = flag;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBussinessId() {
		return bussinessId;
	}
	public void setBussinessId(int bussinessId) {
		this.bussinessId = bussinessId;
	}
	
}
