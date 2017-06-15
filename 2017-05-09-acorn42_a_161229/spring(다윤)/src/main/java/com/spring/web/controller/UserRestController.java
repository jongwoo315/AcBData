package com.spring.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.web.model.User;
import com.spring.web.service.UserService;

@RestController
public class UserRestController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public ResponseEntity<List<User>> selectAllUser() {
		List<User> users = userService.selectAllUser();
		
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	@RequestMapping(value="/join/{id}", method=RequestMethod.GET)
	public ResponseEntity<User> selectUser(@PathVariable("id")String id) {
		System.out.println("id="+id);
		User user = userService.selectByIDandPW(id, "1234");
		
		if(user == null) {
			System.out.println("No id="+id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<User>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value="/join/", method=RequestMethod.POST)
	public ResponseEntity<Void> insertUser(@RequestBody User user, UriComponentsBuilder ucBuilder) {
		System.out.println("insertUser="+user.getName());
		if(userService.isUserExist(user)) {
			System.out.println("name="+user.getName()+" is already exist");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		
		userService.joinUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/join/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.POST)
	public ResponseEntity<User> updateUser(@PathVariable("id")String id, @RequestBody User user) {
		System.out.println("updateUser id="+id);
		User currentUser = userService.selectByIDandPW(id, "1234");
		
		if(currentUser==null) {
			System.out.println("No id="+id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		currentUser.setName(user.getName());
		currentUser.setPw(user.getPw());
		
		userService.updateUser(currentUser);
		
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id")String id) {
		System.out.println("deleteUser id="+id);
		User user = userService.selectByIDandPW(id, "1234");
		
		if(user==null) {
			System.out.println("No id="+id);
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		
		userService.deleteUserByID(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
	
	public ResponseEntity<User> deleteAllUser() {
		System.out.println("deleteAllUser");
		
		userService.deleteAllUser();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}

}
