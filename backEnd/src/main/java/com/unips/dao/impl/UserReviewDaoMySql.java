package com.unips.dao.impl;

import java.sql.Types;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;

import com.unips.dao.UserReviewDao;
import com.unips.dao.mapper.CommentRowMapper;
import com.unips.entity.Comment;

@Repository("userReviewDao.mysql")
public class UserReviewDaoMySql implements UserReviewDao {
	
	private static final Logger log = Logger.getLogger(UserReviewDaoMySql.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Comment> getAllReviews(int userId) {
		
		final String sql = "SELECT *  FROM `unipsdb`.`comment` AS c " +
							"WHERE c.user_id=?";
		
		Object[] values = new Object[] {userId};
		int[] types = new int[] {Types.INTEGER};
		
		return jdbcTemplate.query(sql, values, types, new CommentRowMapper());
		
	}
	
	public List<Comment> getAllReviewsForBusiness(int userId, int businessId) {
		final String sql = "SELECT * FROM `unipsdb`.`comment` AS c " +
							"WHERE c.user_id=? AND c.business_id=?";
		
		Object[] values = new Object[] {userId, businessId};
		int[] types = new int[] {Types.INTEGER, Types.INTEGER};
		
		return jdbcTemplate.query(sql, values, types, new CommentRowMapper());
	}

	public Comment addReviewForBusiness(Comment review) {
		
		final String sql = "INSERT INTO `unipsdb`.`comment` " +
						   "(`subject`, `body`, `comment_flag_id`, `user_id`, `business_id`) " +
						   "(?, ?, ?, ?, ?)";

		Object [] values = new Object[] {review.getSubject(), review.getBody(), review.getFlag().ordinal(), review.getUserId(), review.getBussinessId()};
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.TINYINT, Types.INTEGER, Types.INTEGER};
		
		int result = jdbcTemplate.update(sql, values, types);
		
		if (result != 1)
			return null;
		
		return getReviewBySubjectBodyUserAndBusiness(review);
	}

	private Comment getReviewBySubjectBodyUserAndBusiness(Comment review) {
		
		final String sql = "SELECT * FROM `unipsdb`.`comment`  AS c " +
							"WHERE c.subject=? AND c.body=? AND c.user_id=? AND c.business_id=?";	
		Object[] values = new Object[] {review.getSubject(), review.getBody(), review.getUserId(), review.getBussinessId()};
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER, Types.INTEGER};
		
		List<Comment> result = jdbcTemplate.query(sql, values, types, new CommentRowMapper());
		
		if(result.size() != 1)
			return null;
		
		return result.get(0);
	}
	
	public Comment getReview(int reviewId) {
		
		final String sql = "SELECT * FROM `unipsdb`.`comment`  AS c WHERE c.comment_id=?";
		
		Object[] values = new Object[] {reviewId};
		int[] types = new int[] {Types.INTEGER};	

		List<Comment> result = jdbcTemplate.query(sql, values, types, new CommentRowMapper());

		if(result.size() != 1)
			return null;

		return result.get(0);
	}

	public Comment updateReview(Comment review) {
		
		final String sql = "UPDATE `unipsdb`.`comment` " + 
							"SET `subject` = ?, `body` = ?" +
							"WHERE `comment_id` = ?";	
		
		Object[] values = new Object[] {review.getSubject(), review.getBody(), review.getId()};
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
		
		int result = jdbcTemplate.update(sql, values, types);
		
		if (result != 1)
			return null;
		
		return getReview(review.getId());
	}

	public Boolean deleteReview(Comment review) {
		
		final String sql = "DELETE FROM `unipsdb`.`comment` WHERE `comment_id`=?";
		
		Object[] values = new Object[] {review.getSubject(), review.getBody(), review.getId()};
		int[] types = new int[] {Types.VARCHAR, Types.VARCHAR, Types.INTEGER};
		
		int result = jdbcTemplate.update(sql, values, types);
		
		if (result != 1)
			return false;
		
		return true;
	}

}
