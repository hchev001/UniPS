package com.unips.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api/users/{commentid}/flag")
@Api(tags={"User-Flag"})
public class UserReviewFlagController {

	@Autowired
	UserService<User> service;

	@ApiOperation("Toggles the flag for a review.")
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseBody
	public Response<CommentFlag> updateFlag(@RequestParam("commentid") Integer commentId){
		return service.updateFlag(commentId);
	}
	
}
