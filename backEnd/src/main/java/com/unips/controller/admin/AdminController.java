package com.unips.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.admin.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/admin")
@Api(tags="Basic Admin")
public class AdminController {

	@Autowired
	AdminService<User> service;
	
	@ApiOperation("Gets all the admins entities")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<User>> getAllAdmin() {
		return service.getAllAdmins();
	}
	
	@ApiOperation("Get admin user by username")
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	@ResponseBody
	public Response<User> getAdmin(@PathVariable("username") String username){
		return service.getAdmin(username);
	}
	
	@ApiOperation("Modify an admin by username.")
	@RequestMapping(value="{username}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<User> updateAdmin(@RequestBody User user){
		return service.updateAdmin(user);
	}
	
	@ApiOperation("Delete an admin by username.")
	@RequestMapping(value="{username}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Integer> deleteAdmin(@PathVariable("username") String username){
		return service.deleteUser(username);
	}
}
