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

import com.unips.constants.BusinessConstants.BusinessCategory;
import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.Address;
import com.unips.entity.Business;
import com.unips.entity.Comment;

public class BusinessResultSetExtractor implements ResultSetExtractor<List<Business>> {

	@Override
	public List<Business> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		Map<Long, Business> userMap = new HashMap<>();
		Map<Long, Boolean> processedComments = new HashMap<>();
		
		while(rs.next()) {
			
			Long id = rs.getLong("user_id");
			
			// If its not in the map create it
			if (!userMap.containsKey(id)) {
				Business user = new Business();
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
				user.setName(rs.getString("name"));
				user.setPhone(rs.getLong("phone"));
				user.setPhoneBusiness(rs.getLong("phone_business"));
				user.setHours(rs.getString("hours"));
				user.setCategory(BusinessCategory.values()[rs.getInt("business_category_id")]);
				
				// Add the address
				Address address = new Address();
				address.setLine1(rs.getString("line1"));
				address.setLine2(rs.getString("line2"));
				address.setCity(rs.getString("city"));
				address.setState(rs.getString("state"));
				address.setZip(rs.getLong("zip"));
				user.setAddress(address);
				
				// Instantiate the address.
				List<String> pictures = new LinkedList<>();
				pictures.add(rs.getString("picture"));
				user.setPictures(pictures);
				
				// Instantiate the comments.
				List<Comment> comments = new LinkedList<>();
				if (rs.getLong("comment_id") != 0) {
					Comment comment = new Comment();
					comment.setId(rs.getInt("comment_id"));
					comment.setCreatedDate(rs.getDate("created_date"));
					comment.setSubject(rs.getString("subject"));
					comment.setBody(rs.getString("body"));
					comment.setFlag(CommentFlag.values()[rs.getInt("comment_flag_id")]);
					comment.setUserId(rs.getInt("user_id"));
					comment.setBussinessId(rs.getInt("business_id"));
					
					comments.add(comment);
					user.setComments(comments);
					
					// Update the map of processed.
					processedComments.put((long) comment.getId(), true);
				}
				
				// Update in the map
				userMap.put(id, user);
			} else {
				userMap.get(id).getPictures().add(rs.getString("picture"));
				
				List<Comment> comments = userMap.get(id).getComments();
				
				long commentId = rs.getLong("comment_id");
				boolean processed = processedComments.containsKey(commentId);
				
				if (commentId != 0 && !processed) {
					
					Comment comment = new Comment();
					comment.setId(rs.getInt("comment_id"));
					comment.setCreatedDate(rs.getDate("created_date"));
					comment.setSubject(rs.getString("subject"));
					comment.setBody(rs.getString("body"));
					comment.setFlag(CommentFlag.values()[rs.getInt("comment_flag_id")]);
					comment.setUserId(rs.getInt("user_id"));
					comment.setBussinessId(rs.getInt("business_id"));
					
					comments.add(comment);
					userMap.get(id).setComments(comments);
				}
			}
		}
		return new ArrayList<>(userMap.values());
	}
}
