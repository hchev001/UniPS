package com.unips.entity;

import com.unips.constants.BusinessConstants.RatingCategory;

public class Rating {
	
	private User creator;
	private RatingCategory rate;
	
	
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
	public RatingCategory getRate() {
		return rate;
	}
	public void setRate(RatingCategory rate) {
		this.rate = rate;
	}

	
}
