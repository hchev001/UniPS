package com.unips.controller.business;

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
@RequestMapping("/api/business/{business}/pictures")
@Api(tags={"Business-Picture"})
public class BusinessPictureController {

	@Autowired
	UserService<User> service;
	
	@ApiOperation("Gets all pictures for business")
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getAllPictures(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Add a picture for business")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<String> addPicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Gets all pictures for business uploaded by users")
	@RequestMapping(value="{user}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getAllPicturesByUser(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Gets featured picture for business")
	@RequestMapping(value="featured", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getFeaturedPicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Update featured picture for business")
	@RequestMapping(value="featured", method = RequestMethod.PUT)
	@ResponseBody
	public Response<List<String>> updateFeaturedPicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Delete featured picture for business")
	@RequestMapping(value="featured", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<List<String>> deleteFeaturedPicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	
	@ApiOperation("Gets picture for business with a picture id")
	@RequestMapping(value="{pictureId}", method = RequestMethod.GET)
	@ResponseBody
	public Response<List<String>> getPicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Updates picture for business with a picture id")
	@RequestMapping(value="{pictureId}", method = RequestMethod.PUT)
	@ResponseBody
	public Response<List<String>> updatePicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
	@ApiOperation("Deletes picture for business with a picture id")
	@RequestMapping(value="{pictureId", method = RequestMethod.DELETE)
	@ResponseBody
	public Response<List<String>> deletePicture(@PathVariable("business") String business) {
		return Response.unimplemented();
	}
	
}
