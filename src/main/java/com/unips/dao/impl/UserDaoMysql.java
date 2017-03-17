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

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.UserDao;
import com.unips.entity.User;

@Repository("user.mysql")
public class UserDaoMysql implements UserDao {
	
	private static class UserResultSetExtractor implements ResultSetExtractor<List<User>> {

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

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllUsers() {
		
		String sql = "(SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`picture` AS p " +
					 "ON u.user_id = p.user_id) " +
					 "UNION " +
					 "(SELECT * FROM `unipsdb`.`user` AS u " +
					 "RIGHT JOIN `unipsdb`.`picture` AS p " +
					 "ON u.user_id = p.user_id);";
		
		List<User> users = jdbcTemplate.query(sql, new UserResultSetExtractor());
		return users;
	}

	@Override
	public User getUser(String username) {

		String sql = "SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`picture` AS p "+
					 "ON u.user_id=p.user_id " +
					 "WHERE u.username=?";
		
		List<User> user = jdbcTemplate.query(sql, new Object[]{username}, new int[]{Types.VARCHAR},
				new UserResultSetExtractor());
		return  user.get(0);
	}
	

	@Override
	public int addUser(User user) {
		
		String sql = "INSERT INTO `unipsdb`.`user` (`username`, `password`, `email`,`question1`, `question2`, `status_id`, `role_id`, `token`) " +
					 "VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		
		Object[] values = {
				user.getUsername(),
				user.getPassword(),
				user.getEmail(),
				user.getQuestion1(),
				user.getQuestion2(),
				user.getStatus().ordinal(),
				user.getRole().ordinal(),
				user.getToken()
		};
		return jdbcTemplate.update(sql, values);
	}

	@Override
	public User updateUser(User user) {
		
		String sql = "UPDATE `unipsdb`.`user` u " +
					 "SET u.username = ?, u.password = ?, u.email = ?, u.question1 = ?, u.question2 = ? " +
					 "WHERE u.username = ?;";		
		
		Object[] values = {user.getUsername(),
				user.getPassword(),
				user.getEmail(),
				user.getQuestion1(),
				user.getQuestion2(),
				user.getUsername()};
		
		jdbcTemplate.update(sql, values);
		return user;
	}

	@Override
	public int deleteUser(String username) {
		
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
