package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import com.unips.dao.BusinessReviewDao;
import com.unips.entity.Comment;
import com.unips.response.Response;

@Service
public class BusinessReviewService<T>{

	@Autowired
	@Qualifier("businessReview.mysql")
	BusinessReviewDao businessReviewDao;

	
	@PreAuthorize("permitAll()")
	public Response<List<Comment>> getAllReviews() {
		return  Response.success(businessReviewDao.getAllComments());	
	}
}
