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

	private static final int VALID_MAX_COUNT_ONE = 1;

	@Autowired
	@Qualifier("businessReview.mysql")
	BusinessReviewDao businessReviewDao;

	
	@PreAuthorize("permitAll()")
	public Response<List<Comment>> getAllReviews() {
		try {
			return  Response.success(businessReviewDao.getAllComments());
		} catch (Exception e) {
			return Response.failure(e.getMessage());
		}	
	}
}
