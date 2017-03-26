package com.unips.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.UserInfoDao;
import com.unips.entity.UserInfo;

@Repository("userInfo.mysql")
public class UserInfoDaoMysql implements UserInfoDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static class UserRowMapper implements RowMapper<UserInfo> {

		@Override
		public UserInfo mapRow(ResultSet rs, int i) throws SQLException {
			UserInfo userInfo = new UserInfo();
			userInfo.setUsername(rs.getString("username"));
			userInfo.setPassword(rs.getString("password"));
			userInfo.setRole(rs.getString("role"));
			return userInfo;
		}
	}
	
	public UserInfo getUserInfo(String username) {
		
		String sql = "SELECT u.username username, u.password password, a.role role " + 
					 "FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`role` as a " +
					 "ON a.role_id=u.role_id " +
					 "WHERE u.status_id=? AND u.username=?";
		try {
			Object [] values = {Status.ACTIVE.ordinal(), username};
			UserInfo userInfo = jdbcTemplate.queryForObject(sql, new UserRowMapper(), values);
			return userInfo;
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

}