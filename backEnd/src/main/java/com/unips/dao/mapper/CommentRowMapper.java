package com.unips.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.unips.constants.BusinessConstants.CommentFlag;
import com.unips.entity.Comment;

public class CommentRowMapper implements RowMapper<Comment> {

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