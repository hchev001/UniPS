package com.unips.dao;

import java.util.List;

import com.unips.entity.Comment;


public interface BusinessReviewDao {
	
	public List<Comment> getAllComments();
	
	public Comment getComment(Integer commentid);
	
}
