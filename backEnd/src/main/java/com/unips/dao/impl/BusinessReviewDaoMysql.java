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
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.constants.BusinessConstants.Roles;
import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.BusinessDao;
import com.unips.dao.BusinessReviewDao;
import com.unips.dao.UserDao;
import com.unips.entity.Address;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;

@Repository("businessReview.mysql")
public class BusinessReviewDaoMysql implements BusinessReviewDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	
	private static class CommentRowMapper implements RowMapper<Comment> {

		@Override
		public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
			Comment comment = new Comment();
			
			comment.setId(rs.getInt("comment_id"));
			comment.setCreatedDate(rs.getDate("created_date"));
			comment.setSubject(rs.getString("subject"));
			comment.setBody(rs.getString("body"));
			comment.setFlag(CommentFlag.values()[rs.getInt("comment_flag_id")]);
			comment.setUserId(rs.getInt("user_id"));
			comment.setBussinessId(rs.getInt("business_id"));
			return comment;
		}
	}
	
	
	@Override
	public List<Comment> getAllComments() {
		
		String sql = "SELECT * FROM `unipsdb`.`comment`";
		
		List<Comment> comments = jdbcTemplate.query(sql, new CommentRowMapper());
	
		return comments;
	}
}
