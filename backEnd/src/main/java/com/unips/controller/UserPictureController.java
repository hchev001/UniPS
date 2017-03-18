package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping("/api/users/{user}/pictures")
@Api(tags={"User-Picture"})
public class UserPictureController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all pictures for user")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getAllPictures(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Add a picture for user")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<String> addPicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}

	
	@ApiOperation("Gets featured picture for user")
	@RequestMapping(value="featured", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getFeaturedPicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Update featured picture for user")
	@RequestMapping(value="featured", method = RequestMethod.PUT)
	@ResponseBody
	public Response<List<String>> updateFeaturedPicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Delete featured picture for user")
	@RequestMapping(value="featured", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<List<String>> deleteFeaturedPicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Gets picture for user with a picture id")
	@RequestMapping(value="{pictureId}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getPicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Updates picture for user with a picture id")
	@RequestMapping(value="{pictureId}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<List<String>> updatePicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Deletes picture for user with a picture id")
	@RequestMapping(value="{pictureId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<List<String>> deletePicture(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Gets picture from user for business with a picture id")
	@RequestMapping(value="{businessName}/pictures/{pictureId}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getPictureForBusiness(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Updates picture from user for business with a picture id")
	@RequestMapping(value="{businessName}/pictures/{pictureId}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<List<String>> updatePictureForBusiness(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Deletes picture from user for business with a picture id")
	@RequestMapping(value="{businessName}/pictures/{pictureId}", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<List<String>> deletePictureForBusiness(@PathVariable("user") String user) {
		return Response.unimplemented();
	}
}
