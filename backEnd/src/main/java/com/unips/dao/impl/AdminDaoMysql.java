package com.unips.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.AdminDao;
import com.unips.dao.mapper.UserResultSetExtractor;
import com.unips.entity.User;


@Repository("admin.mysql")
public class AdminDaoMysql implements AdminDao {
	
	private static final Logger log = Logger.getLogger(AdminDaoMysql.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<User> getAllAdmins() {
		
		String sql = "(SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`picture` AS p " +
					 "ON u.user_id = p.user_id " +
					 "WHERE u.role_id = ?) " +
					 "UNION " +
					 "(SELECT * FROM `unipsdb`.`user` AS u " +
					 "RIGHT JOIN `unipsdb`.`picture` AS p " +
					 "ON u.user_id = p.user_id " +
					 "WHERE u.role_id = ?)";
		
		Object [] values = new Object[] {Roles.ROLE_ADMIN.ordinal(), 
										 Roles.ROLE_ADMIN.ordinal()};
		
		List<User> users = jdbcTemplate.query(sql, new UserResultSetExtractor(), values);
		return users;
	}

	@Override
	public User getAdmin(String username) {

		String sql = "SELECT * FROM `unipsdb`.`user` AS u " +
					 "LEFT JOIN `unipsdb`.`picture` AS p "+
					 "ON u.user_id=p.user_id " +
					 "WHERE u.username=?";
		
		List<User> user = jdbcTemplate.query(sql, new Object[]{username}, new int[]{Types.VARCHAR},
				new UserResultSetExtractor());
		
		if (user.size() == 0) 
				return null;
		
		return  user.get(0);
	}
	

	@Override
	public int addAdmin(User user) {
		
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
	public User updateAdmin(User user) {
		
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
	public int deleteAdmin(String username) {
		
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
	public int updateAdminStatus(String username, Status status) {
		
		String sql = "UPDATE `unipsdb`.`user` u SET u.status_id=? WHERE u.username=?;";
	
		return jdbcTemplate.update(sql, new Object[] {status.ordinal(), username});
	}

	@Override
	public List<String> getQuestions(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean exits(String username) {
		
		log.debug(username);
		
		final String sql = "SELECT u.username FROM `unipsdb`.`user`AS u WHERE u.username = ?";
		
		try {
			String result = jdbcTemplate.queryForObject(sql, String.class, new Object[] {username});
			return result != "";
		} catch (Exception e) {
			return false;
		}
	}
}
