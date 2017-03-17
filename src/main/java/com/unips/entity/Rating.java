package com.unips.entity;

import com.unips.constants.BusinessConstants.RatingValue;

public class Rating {
	
	private User creator;
	private RatingValue rate;
	
	
	@Override
	public String toString() {
		return "Rating [creator=" + creator + ", rate=" + rate + "]";
	}
	
	public User getCreator() {
		return creator;
	}
	public void setCreator(User creator) {
		this.creator = creator;
	}
	public RatingValue getRate() {
		return rate;
	}
	public void setRate(RatingValue rate) {
		this.rate = rate;
	}

	
}
