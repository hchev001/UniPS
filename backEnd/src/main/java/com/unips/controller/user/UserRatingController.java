package com.unips.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/users/{userName }/{businessName}/ratings")
@Api(tags={"User-Rating"})
public class UserRatingController {

	@Autowired
	UserService<User> service;
	
	
	@ApiOperation("Get rating for business")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<User> getRating(@RequestBody User user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Add rating for business")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<User> updateReview(@RequestBody User user){
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Update review by reviewId")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Response<Integer> deleteReview(@PathVariable("username") String username){
		return Response.unimplemented();
	}
}
