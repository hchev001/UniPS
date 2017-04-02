package com.unips.dao;

import java.util.List;

import com.unips.entity.Business;

public interface SearchDao {
	
	List<Business> search(String keyword, String category, Integer rating);
}
