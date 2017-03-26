package com.unips.entity;

import com.unips.constants.BusinessConstants.RatingValue;

public class Rating {
	
	private int userId;
	private RatingValue rate;
	
	
	@Override
	public String toString() {
		return "Rating [userId=" + userId + ", rate=" + rate + "]";
	}
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public RatingValue getRate() {
		return rate;
	}
	public void setRate(RatingValue rate) {
		this.rate = rate;
	}
}
