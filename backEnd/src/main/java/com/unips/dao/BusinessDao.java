package com.unips.dao;

import java.util.List;

import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.Business;


public interface BusinessDao {
	
	public List<Business> getAllBusiness();

	public Business getBusiness(String username);

	public int addBusiness(Business business);

	public Business updateBusiness(Business business);
	
	public int deleteBusiness(String username);
	
	public String verifyEmail(String candidateToken);
	
	public int updateUserStatus(String username, Status status);

	public List<String> getQuestions(String username);
	
	public boolean exits(String username);
	
}
