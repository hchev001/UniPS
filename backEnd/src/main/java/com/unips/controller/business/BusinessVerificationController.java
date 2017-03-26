package com.unips.controller.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.unips.entity.Business;
import com.unips.service.BusinessService;

import io.swagger.annotations.Api;

@Controller
@Api(tags="Registration and Login")
public class BusinessVerificationController {
	
	@Autowired
	BusinessService<Business> service;
	
	@RequestMapping(value="api/businessVerification", method=RequestMethod.GET)
	@ResponseBody
	public boolean verifyEmail(@RequestParam("token") String candidateToken) {
		return service.verifyEmail(candidateToken);
	}

}
