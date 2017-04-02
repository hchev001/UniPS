package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.dao.SearchDao;
import com.unips.entity.Business;
import com.unips.response.Response;

@Service
public class SearchService<T> {
	
	@Autowired
	@Qualifier("search.mysql")
	SearchDao searchDao;

	public Response<List<Business>> Search(String keyword, BusinessCategory category, Double rating) {
		
		// Check the values
		String keywordParam = (keyword != null) ? "%" + keyword + "%" : "%";
		String categoryParam = (category != null) ? String.valueOf(category.ordinal()) : "%";
		String ratingParam = (rating != null) ? rating.toString() : "0.0";
		
		return Response.success(searchDao.search(keywordParam, categoryParam, ratingParam));
	}

}
