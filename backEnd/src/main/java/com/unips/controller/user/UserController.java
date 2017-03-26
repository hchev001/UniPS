package com.unips.controller.user;

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
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/users")
@Api(tags="Basic User")
public class UserController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all the users")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<User>> getAllUsers() {
		return service.getAllUsers();
	}
	
	@ApiOperation("Get user by username")
	@RequestMapping(value="{username}", method = RequestMethod.GET)
	@ResponseBody
	public Response<User> getUserByUsername(@PathVariable("username") String username){
		return service.getUser(username);
	}
	
	@ApiOperation("Add a new user.")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<User> addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@ApiOperation("Modify a user by username.")
	@RequestMapping(value="{username}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<User> updateUser(@RequestBody User user){
		return service.updateUser(user);
	}
	
	@ApiOperation("Delete a user by username.")
	@RequestMapping(value="{username}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<Integer> deleteUser(@PathVariable("username") String username){
		return service.deleteUser(username);
	}
}
