package com.unips.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.unips.dao.BusinessReviewDao;
import com.unips.dao.mapper.CommentRowMapper;
import com.unips.entity.Comment;

@Repository("businessReview.mysql")
public class BusinessReviewDaoMysql implements BusinessReviewDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public List<Comment> getAllComments() {
		
		String sql = "SELECT * FROM `unipsdb`.`comment`";
		
		List<Comment> comments = jdbcTemplate.query(sql, new CommentRowMapper());
	
		return comments;
	}
}
