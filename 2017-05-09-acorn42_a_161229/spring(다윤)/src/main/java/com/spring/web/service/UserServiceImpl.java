package com.spring.web.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.model.User;

import ldg.mybatis.repository.mapper.UserMapperRepository;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapperRepository userRepository;

	@Override
	public boolean isUserExist(User user) {
		// TODO Auto-generated method stub
		return selectByName(user.getName())!=null;
	}

	@Override
	public User selectByIDandPW(String id, String pw) {
		// TODO Auto-generated method stub
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("id", id);
		condition.put("pw", pw);
		
		return userRepository.selectUserCondition(condition);
	}

	@Override
	public User selectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return userRepository.selectAllUser();
	}

	@Override
	public void joinUser(User user) {
		// TODO Auto-generated method stub
		userRepository.insertUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUserByID(String id) {
		// TODO Auto-generated method stub
		userRepository.deleteUser(id);
	}

	@Override
	public void deleteAllUser() {
		// TODO Auto-generated method stub
		userRepository.deleteAllUser();
	}

}
