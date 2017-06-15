package com.acorn.mydats.service;


import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ldg.mybatis.model.User;
import ldg.mybatis.service.CommentService;



@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	CommentService commentService;
	
	private static final AtomicLong counter = new AtomicLong();
	private  List<User> users;

/*	static {
		users = populateDummyUsers();
	}*/

	public List<User> findAllUsers() {
		users=commentService.selectComment(null);
		return users;
	}

	public User findById(long id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
	public User findByName(String name) {
		for (User user : users) {
			if (user.getUsername().equalsIgnoreCase(name)) {
				return user;
			}
		}
		return null;
	}

	public void saveUser(User user) {
		commentService.insertComment(user);
		/*user.setId(counter.incrementAndGet());
		users.add(user);*/
	}

	public void updateUser(User user) {
		commentService.updateComment(user);
/*		int index = users.indexOf(user);
		users.set(index, user);*/
	}

	public void deleteUserById(long id) {
		commentService.deleteComment(id);
/*		for (Iterator<User> iterator = users.iterator(); iterator.hasNext();) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
			}
		}*/
	}

	public boolean isUserExist(User user) {
		return findByName(user.getUsername()) != null;
	}

	public void deleteAllUsers() {
		users.clear();
	}

/*	public static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "잘하자", "NY", "WFW@naver.com"));
		users.add(new User(counter.incrementAndGet(), "성공", "NY", "sdfsdf@daum.net"));
		users.add(new User(counter.incrementAndGet(), "박여사", "NY", "WdfdfFW@gmail.com"));
		return users;
	}*/
}
