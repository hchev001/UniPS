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
import com.unips.dao.mapper.CommentRowMapper;
import com.unips.entity.Address;
import com.unips.entity.Business;
import com.unips.entity.Comment;
import com.unips.entity.User;

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
