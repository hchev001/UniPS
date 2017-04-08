package com.unips.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.dao.impl.AdminDaoMysql;
import com.unips.entity.Business;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.BusinessService;
import com.unips.service.UserService;
import com.unips.service.admin.AdminService;

import io.swagger.annotations.Api;

@RestController
@Api(tags="Registration and Login")
public class GeneralController {
	
	@Autowired
	UserService<User> userService;
	
	@Autowired
	BusinessService<Business> businessService;
	
	@Autowired
	AdminService<User> adminServices;
	
	@RequestMapping(value="api/signupUser", method = RequestMethod.POST)
	@ResponseBody
	public Response<User> addUser(@RequestBody User user) {
		return userService.addUser(user);
	}
	
	@RequestMapping(value="api/signupBusiness", method = RequestMethod.POST)
	@ResponseBody
	public Response<Business> addBusiness(@RequestBody Business business) {
		return businessService.addBusiness(business);
	}
	
	@RequestMapping(value="api/signupAdmin", method = RequestMethod.POST)
	@ResponseBody
	public Response<User> addAdmin(@RequestBody User user) {
		return adminServices.addAdmin(user);
	}
}
