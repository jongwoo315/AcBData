package com.spring.web.service;

import java.util.List;

import com.spring.web.model.User;

public interface UserService {
	
	public boolean isUserExist(User user);
	
	User selectByIDandPW(String id, String pw);
	User selectByName(String name);
	List<User> selectAllUser();
	
	void joinUser(User user);
	void updateUser(User user);
	void deleteUserByID(String id);
	void deleteAllUser();

}
