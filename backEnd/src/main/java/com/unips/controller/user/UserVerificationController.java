package com.unips.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;

@Controller
@Api(tags="Registration and Login")
public class UserVerificationController {
	
	@Autowired
	UserService<User> service;
	
	@RequestMapping(value="api/userVerification", method=RequestMethod.GET)
	@ResponseBody
	public Response<Boolean> verifyEmail(@RequestParam("token") String candidateToken) {
		boolean status = service.verifyEmail(candidateToken);
		return Response.success(status);
	}

}
