package com.unips.entity;

import java.util.Date;

import com.unips.constants.BusinessConstants.RatingValue;

public class Rating {
	
	private int id;
	private Date createdDate;
	private RatingValue ratingValue;
	private int userId;
	private int businessId;
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", createdDate=" + createdDate + ", ratingValue=" + ratingValue + ", userId="
				+ userId + ", businessId=" + businessId + "]";
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
	public RatingValue getRatingValue() {
		return ratingValue;
	}
	public void setRatingValue(RatingValue ratingValue) {
		this.ratingValue = ratingValue;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getBusinessId() {
		return businessId;
	}
	public void setBusinessId(int businessId) {
		this.businessId = businessId;
	}
	
}
