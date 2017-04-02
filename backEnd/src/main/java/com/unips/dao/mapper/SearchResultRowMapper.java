package com.unips.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.Business;


public class SearchResultRowMapper implements RowMapper<Business> {

	@Override
	public Business mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Business business = new Business();
		
		business.setId(rs.getInt("user_id"));
		business.setCreatedDate(rs.getDate("created_date"));
		business.setUsername(rs.getString("username"));
		business.setPassword(rs.getString("password"));
		business.setEmail(rs.getString("email"));
		business.setQuestion1(rs.getString("question1"));
		business.setQuestion2(rs.getString("question2"));
		business.setPictureFeatured(rs.getString("picture_featured"));
		business.setDescription(rs.getString("description"));
		business.setStatus(Status.values() [rs.getInt("status_id")]);
		business.setRole(Roles.values() [rs.getInt("role_id")]);
		business.setName(rs.getString("name"));
		business.setPhone(rs.getLong("phone"));
		business.setPhoneBusiness(rs.getLong("phone_business"));
		business.setHours(rs.getString("hours"));
		business.setCategory(BusinessCategory.values()[rs.getInt("business_category_id")]);
		business.setRateAverage(rs.getInt("rating_average"));
		return business;
	}
}