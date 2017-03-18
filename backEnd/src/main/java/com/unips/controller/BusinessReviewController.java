package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.Comment;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/business/{business}/reviews")
@Api(tags={"Business-Review"})
public class BusinessReviewController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all the business reviews")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Comment>> getAllBusinessReviews(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	
}
