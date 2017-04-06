package com.unips.dao;

import java.util.List;

import com.unips.entity.BusinessSearchResult;

public interface SearchDao {
	
	List<BusinessSearchResult> search(String keyword, String category, Integer rating);
}
