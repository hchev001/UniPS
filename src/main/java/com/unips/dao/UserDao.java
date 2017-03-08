package com.unips.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.unips.entity.UserInfo;

public class UserDao {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private static class UserRowMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet rs, int i) throws SQLException {
			UserInfo userInfo = new UserInfo();
			userInfo.setId(rs.getInt("id"));
			userInfo.setUsername(rs.getString("username"));
			userInfo.setPassword(rs.getString("password"));
			userInfo.setRole(rs.getString("authority"));
			return userInfo;
		}
	}
	
	public UserInfo getUserInfo(String username) {
		
		String sql = "SELECT u.id id, u.username username, u.password password, a.authority authority " + 
					 "FROM `unipsdb`.`users` AS u " +
					 "LEFT JOIN `unipsdb`.`authorities` as a " +
					 "ON a.id=u.authority_id" +
					 "WHERE u.enabled=1 AND u.username=?";
		
		UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserRowMapper(), username);
		
		return userInfo;
	}


}