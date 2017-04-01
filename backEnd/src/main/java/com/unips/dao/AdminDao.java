package com.unips.dao;

import java.util.List;

import com.unips.constants.BusinessConstants.Status;
import com.unips.entity.User;

public interface AdminDao {

	public List<User> getAllAdmins();

	public User getAdmin(String username);

	public int addAdmin(User user);

	public User updateAdmin(User user);
	
	public int deleteAdmin(String username);
	
	public String verifyEmail(String candidateToken);
	
	public int updateAdminStatus(String username, Status status);

	public List<String> getQuestions(String username);
	
	public boolean exits(String username);
	
	
	//Interaction with users and business
	public Status getStatus(String username);
	
	public boolean updateStatus(String username, Status status);
	
	public boolean approveBusiness(String username);
	
	public boolean approveAdmin(String username);
}
