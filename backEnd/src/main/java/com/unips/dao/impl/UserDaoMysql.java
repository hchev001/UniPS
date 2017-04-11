package com.unips.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.RatingValue;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.UserDao;
import com.unips.dao.mapper.RatingRowMapper;
import com.unips.dao.mapper.UserResultSetExtractor;
import com.unips.entity.Rating;
import com.unips.entity.User;


@Repository("user.mysql")
public class UserDaoMysql implements UserDao {
	
	private static final Logger log = Logger.getLogger(UserDaoMysql.class);
	
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
		
		if (user.size() == 0) 
				return null;
		
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

	
	
	@Override
	public CommentFlag getFlag(Integer commentId) {
		
		final String sql = "SELECT c.comment_flag_id " +
				   		   "FROM `unipsdb`.`comment` AS c " +
				   		   "WHERE c.comment_id = ?";
		
		return CommentFlag.values()[jdbcTemplate.queryForObject(sql, Integer.class, new Object[] {commentId})];
	}

	@Override
	public CommentFlag updateFlag(Integer commentId, CommentFlag flag) {
		
		final String sql = "UPDATE `unipsdb`.`comment` AS c " +
							"SET c.comment_flag_id = ? " +
							"WHERE c.comment_id = ?";
		
		Object[] values = new Object[] {flag.ordinal(), commentId};
		int[] types = new int[] {Types.TINYINT, Types.INTEGER};
		
		jdbcTemplate.update(sql, values, types);
		
		return getFlag(commentId);
	}
	
	// Interaction with ratings

	@Override
	public Rating getRating(int userId, int businessId) {
		
		final String sql = "SELECT * FROM `unipsdb`.`rating` AS r " +
							"WHERE r.user_id=? AND r.business_id=?";
		
		Object[] values = new Object[] {userId, businessId};
		int[] types = new int[] {Types.INTEGER, Types.INTEGER};
		
		List<Rating> list = jdbcTemplate.query(sql, values, types, new RatingRowMapper());
		
		if (list.isEmpty())
			return null;
		
		return list.get(0);
	}

	
	@Override
	public Rating addRating(int userId, int businessId, RatingValue rate) {

		final String sql = "INSERT INTO `unipsdb`.`rating` " +
							"(`rating_value_id`, `user_id`, `business_id`) " +
							" VALUES " +
							"(?, " + 
							"(SELECT u.user_id FROM `unipsdb`.`user` AS u WHERE u.username=?), " + 
							"(SELECT b.user_id FROM `unipsdb`.`user` AS b WHERE b.username=?))";
		
		Object[] values = new Object[] {rate.ordinal(), userId, businessId};
		int[] types = new int[] {Types.TINYINT, Types.VARCHAR, Types.VARCHAR};
		
		System.out.println(sql);
		jdbcTemplate.update(sql, values, types);
		
		return getRating(userId, businessId);
	}

	
	@Override
	public Rating updateRating(int userId, int businessId, RatingValue rate) {
		
		final String sql = "UPDATE `unipsdb`.`rating` AS r " +
							"SET r.rating_value_id = ? " + 
							"WHERE r.user_id = (SELECT u.user_id FROM `unipsdb`.`user` AS u WHERE u.username=?) " +
							"AND r.business_id = (SELECT b.user_id FROM `unipsdb`.`user` AS b WHERE b.username=?)";		
		
		Object[] values = new Object[] {rate.ordinal(), userId, businessId};
		int[] types = new int[] {Types.TINYINT, Types.VARCHAR, Types.VARCHAR};
		
		jdbcTemplate.update(sql, values, types);
		
		return getRating(userId, businessId);
	}

}
