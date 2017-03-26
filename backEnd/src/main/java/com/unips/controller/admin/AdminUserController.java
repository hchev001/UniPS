package com.unips.controller.admin;

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
@Api(tags={"Admin-User-Business"})
public class AdminUserController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Get status of user with username by admin")
	@RequestMapping(value="{userName}/status", method = RequestMethod.GET)
	@ResponseBody
	public Response<Business> getStatus(@PathVariable("username") String username){
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Update status of user with username by admin")
	@RequestMapping(value="{userName}/status", method = RequestMethod.PUT)
	@ResponseBody
	public Response<Business> updateAdmin(@RequestBody Business business){
		return Response.unimplemented();
	}
	

	@ApiOperation("Upload data into the system")
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	@ResponseBody
	public Response<Business> upload(@RequestBody Business business) {
		return Response.unimplemented();
	}
}
