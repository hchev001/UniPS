package com.unips.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.User;

public class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

	@Override
	public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<Long, User> userMap = new HashMap<>();
		
		while(rs.next()) {
			
			Long id = rs.getLong("user_id");
			
			// If its not in the map create it
			if (!userMap.containsKey(id)) {
				User user = new User();
				user.setId(rs.getInt("user_id"));
				user.setCreatedDate(rs.getDate("created_date"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setQuestion1(rs.getString("question1"));
				user.setQuestion2(rs.getString("question2"));
				user.setPictureFeatured(rs.getString("picture_featured"));
				user.setDescription(rs.getString("description"));
				user.setStatus(Status.values() [rs.getInt("status_id")]);
				user.setRole(Roles.values() [rs.getInt("role_id")]);
				
				List<String> pictures = new LinkedList<>();
				pictures.add(rs.getString("picture"));
				user.setPictures(pictures);
				
				userMap.put(id, user);
			} else {
				userMap.get(id).getPictures().add(rs.getString("picture"));
			}
		}
		return new ArrayList<>(userMap.values());
	}
}