package com.unips.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.constants.BusinessConstants.RatingValue;
import com.unips.entity.Rating;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/users/{userName}/{businessName}/ratings")
@Api(tags={"User-Rating"})
public class UserRatingController {

	@Autowired
	UserService<User> service;
	
	
	@ApiOperation("Get rating for business")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<Rating> getRating(
			@PathVariable("userName") String userName,
			@PathVariable("businessName") String businessName) {
		return service.getRating(userName, businessName);
	}
	
	@ApiOperation("Add rating for business")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<Rating> addReview(
			@PathVariable("userName") String userName,
			@PathVariable("businessName") String businessName,
			@RequestParam(value="rate", required=true) RatingValue rate){
		return service.addRating(userName, businessName, rate);
	}
	
	
	@ApiOperation("Update review by reviewId")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Response<Rating> updateReview(
			@PathVariable("userName") String userName,
			@PathVariable("businessName") String businessName,
			@RequestParam(value="rate", required=true) RatingValue rate){
		return service.updateRating(userName, businessName, rate);
	}
}
