package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.Business;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/admin")
@Api(tags="Basic Admin")
public class AdminController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all the admins entities")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<User>> getAllAdmin() {
		return Response.unimplemented();
	}
	
	@ApiOperation("Get admin user by username")
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Business> getAdmin(@PathVariable("username") String username){
		return Response.unimplemented();
	}
	
	@ApiOperation("Add a new admin")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<Business> addAdmin(@RequestBody Business business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Modify an admin by username.")
	@RequestMapping(value="{username}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<Business> updateAdmin(@RequestBody Business business){
		return Response.unimplemented();
	}
	
	@ApiOperation("Delete an admin by username.")
	@RequestMapping(value="{username}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Integer> updateAdmin(@PathVariable("username") String username){
		return Response.unimplemented();
	}
}
