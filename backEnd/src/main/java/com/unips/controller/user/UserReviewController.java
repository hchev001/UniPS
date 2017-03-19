package com.unips.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/api/users/{user}/reviews")
@Api(tags={"User-Review"})
public class UserReviewController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all reviews from user")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Comment>> getAllReviews() {
		return Response.unimplemented();
	}
	
	@ApiOperation("Get all reviews from user to business")
	@RequestMapping(value="{business}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Comment>> getAllReviewsForBusiness(@PathVariable("business") String business){
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Add reviews from user to business")
	@RequestMapping(value="{business}", method = RequestMethod.POST)
	@ResponseBody
	public Response<Comment> addReviewForBusiness(@PathVariable("business") String business){
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Get review by reviewId.")
	@RequestMapping(value="{reviewId}", method = RequestMethod.GET)
	@ResponseBody
	public Response<User> getReview(@RequestBody User user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Update review by reviewId")
	@RequestMapping(value="{reviewId}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<User> updateReview(@RequestBody User user){
		return Response.unimplemented();
	}
	
	@ApiOperation("Delete review by reviewId")
	@RequestMapping(value="{reviewId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Integer> deleteReview(@PathVariable("username") String username){
		return Response.unimplemented();
	}
}
