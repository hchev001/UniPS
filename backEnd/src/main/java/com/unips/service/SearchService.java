package com.unips.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.dao.SearchDao;
import com.unips.entity.Business;
import com.unips.entity.BusinessSearchResult;
import com.unips.response.Response;

@Service
public class SearchService<T> {
	
	@Autowired
	@Qualifier("search.mysql")
	SearchDao searchDao;

	public Response<List<BusinessSearchResult>> Search(String keyword, BusinessCategory category, Integer rating) {
		
		// Check the values
		String keywordParam = (keyword != null) ? "%" + keyword + "%" : "%";
		String categoryParam = (category != null) ? String.valueOf(category.ordinal()) : "%";
		Integer ratingParam = (rating != null) ? rating : 0;
		
		return Response.success(searchDao.search(keywordParam, categoryParam, ratingParam));
	}

}
