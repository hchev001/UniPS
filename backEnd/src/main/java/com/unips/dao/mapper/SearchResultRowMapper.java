package com.unips.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.entity.BusinessSearchResult;


public class SearchResultRowMapper implements RowMapper<BusinessSearchResult> {

	@Override
	public BusinessSearchResult mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		BusinessSearchResult business = new BusinessSearchResult();
		
		business.setUsername(rs.getString("username"));
		business.setEmail(rs.getString("email"));
		business.setPictureFeatured(rs.getString("picture_featured"));
		business.setDescription(rs.getString("description"));
		business.setName(rs.getString("name"));
		business.setPhone(rs.getLong("phone"));
		business.setPhoneBusiness(rs.getLong("phone_business"));
		business.setHours(rs.getString("hours"));
		business.setCategory(BusinessCategory.values()[rs.getInt("business_category_id")]);
		business.setRateAverage(rs.getInt("rating_average"));
		return business;
	}
}