package com.unips.dao;

import com.unips.entity.UserInfo;

public interface UserDao {
	
	public UserInfo getUserInfo(String username);
	
	public int addUserInfo(UserInfo user);

}
