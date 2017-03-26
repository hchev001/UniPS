package com.unips.controller.business;

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
@RequestMapping("/api/business")
@Api(tags="Basic Business")
public class BusinessController {

	@Autowired
	BusinessService<Business> service;
	
	@ApiOperation("Gets all the business entities")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<Business>> getAllBusiness() {
		return service.getAllBusiness();
	}
	
	@ApiOperation("Get business user by username")
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Business> geBusiness(@PathVariable("username") String username){
		return Response.unimplemented();
	}
	
	@ApiOperation("Add a new business entity.")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<Business> addUser(@RequestBody Business business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Modify a business entity by username.")
	@RequestMapping(value="{username}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<Business> updateUser(@RequestBody Business business){
		return Response.unimplemented();
	}
	
	@ApiOperation("Delete a business entity by username.")
	@RequestMapping(value="{username}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Integer> updateUser(@PathVariable("username") String username){
		return Response.unimplemented();
	}
}
