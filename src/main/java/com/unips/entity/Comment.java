package com.unips.entity;

import java.sql.Date;

import com.unips.constants.BusinessConstants.CommentFlag;

public class Comment {
	
	private User creator;
	private String subject;
	private String body;
	
	private Date creationDate;
	private CommentFlag flag;
	
	
	@Override
	public String toString() {
		return "Comment [creator=" + creator + ", subject=" + subject + ", body=" + body + ", creationDate="
				+ creationDate + ", flag=" + flag + "]";
	}
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
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
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public CommentFlag getFlag() {
		return flag;
	}
	public void setFlag(CommentFlag flag) {
		this.flag = flag;
	}	
}
