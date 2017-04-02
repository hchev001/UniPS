package com.unips.service.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.unips.constants.BusinessConstants.Status;
import com.unips.dao.AdminDao;
import com.unips.dao.UserInfoDao;
import com.unips.mail.SmptMailSender;
import com.unips.response.Response;

@Service
public class AdminUserService<T> {
	
	@Autowired
	@Qualifier("admin.mysql")
	AdminDao adminDao;

	@Autowired
	@Qualifier("userInfo.mysql")
	UserInfoDao userInfoDao;
	
	@Autowired
	SmptMailSender mailSender;
	
	
	public Response<Status> getStatus(String username) {
		return Response.success(adminDao.getStatus(username));
	}
	
	
	public Response<Boolean> updateStatus(String username, Status status) {
		return Response.success(adminDao.updateStatus(username, status));
	}
	
	
	public Response<Boolean> approveBusiness(String username) {
		return Response.success(adminDao.approveBusiness(username));
	}
	
	
	public Response<Boolean> approveAdmin(String username) {
		return Response.success(adminDao.approveAdmin(username));
	}
	
	
}
