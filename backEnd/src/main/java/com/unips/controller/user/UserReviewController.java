package com.unips.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.Comment;
import com.unips.response.Response;
import com.unips.service.UserReviewService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/users/{userName}/reviews")
@Api(tags={"User-Review"})
public class UserReviewController {

	@Autowired
	UserReviewService<Comment> service;
	
	@ApiOperation("Gets all reviews from user")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Comment>> getAllReviews(
			@PathVariable("userName") String userName) {
		return service.getAllReviews(userName);
	}
	
	@ApiOperation("Get all reviews from user to business")
	@RequestMapping(value="{businessName}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Comment>> getAllReviewsForBusiness(
			@PathVariable("userName") String userName,
			@PathVariable("businessName") String businessName){
		return service.getAllReviewsForBusiness(userName, businessName);
	}
	
	
	@ApiOperation("Add reviews from user to business")
	@RequestMapping(value="{businessName}", method = RequestMethod.POST)
	@ResponseBody
	public Response<Comment> addReviewForBusiness(
			@PathVariable("userName") String userName,
			@PathVariable("businessName") String businessName){
		return service.addReviewForBusiness(userName, businessName);
	}
	
	
	@ApiOperation("Get review by reviewId.")
	@RequestMapping(value="/id/{reviewId}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Comment> getReview(
			@PathVariable("userName") String userName,
			@PathVariable("reviewId") Integer reviewId) {
		return service.getReview(userName, reviewId);
	}
	
	@ApiOperation("Update review by reviewId")
	@RequestMapping(value="/id/{reviewId}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<Comment> updateReview(
			@PathVariable("userName") String userName,
			@PathVariable("reviewId") Integer reviewId){
		return service.updateReview(userName, reviewId);
	}
	
	@ApiOperation("Delete review by reviewId")
	@RequestMapping(value="/id/{reviewId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Boolean> deleteReview(
			@PathVariable("userName") String userName,
			@PathVariable("reviewId") Integer reviewId){
		return service.deleteReview(userName, reviewId);
	}
}
