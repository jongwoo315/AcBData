package com.acorn.mydats.service;

import java.util.List;
import ldg.mybatis.model.User;




public interface UserService {
	
	User findById(long Id);
	User findByName(String name);
	
	void saveUser(User user);
	void updateUser(User user);
	void deleteUserById(long id);
	List<User> findAllUsers();
	void deleteAllUsers();
	public boolean isUserExist(User user);
}
