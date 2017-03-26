package com.unips.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.BusinessDao;
import com.unips.dao.BusinessReviewDao;
import com.unips.dao.UserDao;
import com.unips.dao.UserInfoDao;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;
import com.unips.entity.UserInfo;
import com.unips.mail.SmptMailSender;
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
