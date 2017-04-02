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

	private Map<Long, Business> userMap = new HashMap<>();
	private Map<Long, Boolean> processedComments = new HashMap<>();
	private Map<String, Boolean> processedPictures = new HashMap<>();
	
	private Long userId;
	private Long commentId;
	private String pictureId;
	
	@Override
	public List<Business> extractData(ResultSet rs) throws SQLException, DataAccessException {
		
		
		while(rs.next()) {
			
			userId = rs.getLong("user_id");
			commentId = rs.getLong("comment_id");
			pictureId = rs.getString("picture");
			
			// If its not in the map create it
			if (!userMap.containsKey(userId)) {
				
				Business user = new Business();
				addUserBasicInformation(rs, user);
				addUserAddress(rs, user);
				
				// Instantiate non-simple objects for the first time..
				List<Comment> comments = new LinkedList<>();
				List<String> pictures = new LinkedList<>();
				
				
				// Add the first picture.
				pictures.add(pictureId);
				user.setPictures(pictures);
				processedPictures.put(pictureId, true);
				
				
				// Instantiate the comments.
				if (commentId != 0) {
					addUserComment(rs, user, comments);
				}
				
				// Update in the map
				userMap.put(userId, user);
				
			} else {
				
				Business user = userMap.get(userId);
				
				if (!processedPictures.containsKey(pictureId)) {
					List<String> pictures = user.getPictures();
					pictures.add(pictureId);
					processedPictures.put(pictureId, true);
				}
			
				if (commentId != 0 && !processedComments.containsKey(commentId)) {
					List<Comment> comments = userMap.get(userId).getComments();
					addUserComment(rs, user, comments);
				}
			}
		}
		return new ArrayList<>(userMap.values());
	}


	private void addUserComment(ResultSet rs, Business user, List<Comment> comments) throws SQLException {
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
		processedComments.put(commentId, true);
	}
	

	private void addUserAddress(ResultSet rs, Business user) throws SQLException {
		// Add the address
		Address address = new Address();
		address.setLine1(rs.getString("line1"));
		address.setLine2(rs.getString("line2"));
		address.setCity(rs.getString("city"));
		address.setState(rs.getString("state"));
		address.setZip(rs.getLong("zip"));
		user.setAddress(address);
	}

	
	private void addUserBasicInformation(ResultSet rs, Business user) throws SQLException {
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
		user.setRateAverage(rs.getInt("rating_average"));
	}
}
