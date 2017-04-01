package com.unips.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.Business;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.admin.AdminUserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/admin")
@Api(tags={"Admin-User-Business"})
public class AdminUserController {

	@Autowired
	AdminUserService<User> service;
	
	@ApiOperation("Get status of user with username by admin")
	@RequestMapping(value="/status/{username}", method = RequestMethod.GET)
	@ResponseBody
	public Response<Status> getStatus(@PathVariable("username") String username){
		return service.getStatus(username);
	}
	
	
	@ApiOperation("Update status of user with username by admin")
	@RequestMapping(value="/status/{userName}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<Boolean> updateAdmin(
			@PathVariable("userName") String username, 
			@RequestParam("type") Status type){
		
		return service.updateStatus(username, type);
	}
	
	
	@ApiOperation("Upload data into the system")
	@RequestMapping(value="/upload", method = RequestMethod.POST)
	@ResponseBody
	public Response<Business> upload(@RequestBody Business business) {
		return Response.unimplemented();
	}
}
