package com.unips.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.BusinessDao;
import com.unips.dao.UserDao;
import com.unips.entity.Address;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;

@Repository("business.mysql")
public class BusinessDaoMysql implements BusinessDao {
	
	private static class UserResultSetExtractor implements ResultSetExtractor<List<Business>> {

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

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Business> getAllBusiness() {
		
		String sql = "SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`address` AS a " +
					 "ON u.address_id = a.address_id " + 
					 "LEFT JOIN `unipsdb`.`picture` AS p " +
					 "ON u.user_id = p.user_id " + 
					 "RIGHT JOIN `unipsdb`.`picture` AS p1 " +
					 "ON u.user_id = p1.user_id " + 
					 "LEFT JOIN `unipsdb`.`comment` AS c " +
					 "ON u.user_id = c.business_id " + 
					 "WHERE u.role_id = ?";
		
		int role = Roles.ROLE_BUSINESS.ordinal();
		
		List<Business> business = jdbcTemplate.query(sql, new UserResultSetExtractor(),
				new Object[] {role});
	
		return business;
	}

	@Override
	public Business getBusiness(String username) {

		String sql = "SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`picture` AS p "+
					 "ON u.user_id=p.user_id " +
					 "WHERE u.username=?";
		
		List<Business> business = jdbcTemplate.query(sql, new Object[]{username}, new int[]{Types.VARCHAR},
				new UserResultSetExtractor());
		return  business.get(0);
	}
	

	@Override
	public int addBusiness(Business business) {
		
		String sql = "INSERT INTO `unipsdb`.`user` (`username`, `password`, `email`,`question1`, `question2`, `status_id`, `role_id`, `token`) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		Object[] values = {
				business.getUsername(),
				business.getPassword(),
				business.getEmail(),
				business.getQuestion1(),
				business.getQuestion2(),
				business.getStatus().ordinal(),
				business.getRole().ordinal(),
				business.getToken()
		};
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public Business updateBusiness(Business business) {
		
		String sql = "UPDATE `unipsdb`.`user` u " +
					 "SET u.username = ?, u.password = ?, u.email = ?, u.question1 = ?, u.question2 = ? " +
					 "WHERE u.username = ?;";		
		
		Object[] values = {business.getUsername(),
				business.getPassword(),
				business.getEmail(),
				business.getQuestion1(),
				business.getQuestion2(),
				business.getUsername()};
		
		jdbcTemplate.update(sql, values);
		return business;
	}

	@Override
	public int deleteBusiness(String username) {
		
		String sql = "DELETE FROM `unipsdb`.`user` WHERE username = ?";
			
		return jdbcTemplate.update(sql, new Object[]{username});
	}	


	@Override
	public String verifyEmail(String candidateToken) {
		
		String sql = "SELECT username FROM `unipsdb`.`user` u WHERE u.token=?";
		String username = jdbcTemplate.queryForObject(sql, new Object[] {candidateToken}, String.class);
		
		return username;
	}

	@Override
	public int updateUserStatus(String username, Status status) {
		
		String sql = "UPDATE `unipsdb`.`user` u SET u.status_id=? WHERE u.username=?;";
	
		return jdbcTemplate.update(sql, new Object[] {status.ordinal(), username});
	}

	@Override
	public List<String> getQuestions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
