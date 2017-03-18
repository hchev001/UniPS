package com.unips.controller;

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
@RequestMapping("/api/users/{userName }/{businessName}/{reviewId}/flag")
@Api(tags={"User-Flag"})
public class UserReviewFlagController {

	@Autowired
	UserService<User> service;
	
	
	@ApiOperation("Get flag for review")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<User> getFlag(@RequestBody User user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Add flag for review")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<User> addFlag(@RequestBody User user){
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Update flag for review")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Response<Integer> updateFlag(@PathVariable("username") String username){
		return Response.unimplemented();
	}
}
