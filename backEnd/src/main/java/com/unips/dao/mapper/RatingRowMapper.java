package com.unips.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.unips.constants.BusinessConstants.RatingValue;
import com.unips.entity.Rating;

public class RatingRowMapper implements RowMapper<Rating> {

	@Override
	public Rating mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Rating rating = new Rating();
		
		rating.setId(rs.getInt("rating_id"));
		rating.setCreatedDate(rs.getDate("created_date"));
		rating.setRatingValue(RatingValue.values() [rs.getInt("rating_value_id")]);
		rating.setUserId(rs.getInt("user_id"));
		rating.setBusinessId(rs.getInt("business_id"));
		
		return rating;
	}
}