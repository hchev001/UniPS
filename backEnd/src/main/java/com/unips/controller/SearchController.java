package com.unips.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.entity.Business;
import com.unips.entity.BusinessSearchResult;
import com.unips.entity.User;
import com.unips.response.Response;
import com.unips.service.SearchService;
import com.unips.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;


@RestController
@RequestMapping("/api/search")
@Api(tags={"Search"})
public class SearchController {

	@Autowired
	SearchService<List<Business>> service;
	
	@ApiOperation("Search for business entities")
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public Response<List<BusinessSearchResult>> search(
			@RequestParam(value="keyword", required=false) String keyword,
			@RequestParam(value="category", required=false) BusinessCategory category,
			@RequestParam(value="rating", required=false) Integer rating
			) {
		
		return service.Search(keyword, category, rating);
	}
}
