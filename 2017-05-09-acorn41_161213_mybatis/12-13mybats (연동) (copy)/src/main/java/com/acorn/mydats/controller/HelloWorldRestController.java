package com.acorn.mydats.controller;

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

import com.acorn.mydats.service.UserService;

import ldg.mybatis.model.User;




@RestController
public class HelloWorldRestController {
	
	@Autowired	
	UserService userService;
	
	// 모든 사용자에 대응하는 함수
	
	@RequestMapping(value="/user/", method= RequestMethod.GET)
	public ResponseEntity<List<User>> listAllUsers(){
		List<User> users = userService.findAllUsers();
		if(users.isEmpty()){
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	}
	
	// 단일 사용자 맵핑
	@RequestMapping(value="/user/{id}" ,method=RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") long id){
		System.out.println("사용자 " + id + "대한 정보를 가져옵니다.");
		User user = userService.findById(id);
		if(user == null){
			System.out.println("사용자 " + id + "대한 정보가 없습니다.");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}
	// 사용자 생성
	@RequestMapping(value="/user/", method = RequestMethod.POST)
	public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder ucBuilder){
		System.out.println("사용자 생성" + user.getUsername());
		
		if(userService.isUserExist(user)){
			System.out.println(" 이름" + user.getUsername() + "가 이미 존재 합니다.");
			return new ResponseEntity<Void>(HttpStatus.CONFLICT);
		}
		userService.saveUser(user);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(user.getId()).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	//사용자 수정
	@RequestMapping(value="/user/{id}", method=RequestMethod.POST)
	public ResponseEntity<User> updateUser(@PathVariable("id") long id, @RequestBody User user){
		System.out.println("사용자 " + id + "수정합니다.");
		User currentUser = userService.findById(id);
		if(currentUser ==null){
			System.out.println("사용자 " + id + "정보가 없습니다..");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
			
		}
		currentUser.setUsername(user.getUsername());
		currentUser.setAddress(user.getAddress());
		currentUser.setEmail(user.getEmail());
		currentUser.setId(id);
		userService.updateUser(currentUser);
		return new ResponseEntity<User>(currentUser, HttpStatus.OK);
		
	}
	
	@RequestMapping(value="/user/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteUser(@PathVariable("id") long id){
		System.out.println("사용자 " + id + "내용을 삭제 합니다.");
		
		User user = userService.findById(id);
		if ( user == null){
			System.out.println("사용자 " + id + "내용이 없습니다.");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		userService.deleteUserById(id);
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	// 모든 사용자 삭제
	@RequestMapping(value="/user/", method=RequestMethod.DELETE)
	public ResponseEntity<User> deleteAllUser(){
		System.out.println("모든 사용자 삭제");
		
		userService.deleteAllUsers();
		return new ResponseEntity<User>(HttpStatus.NO_CONTENT);
	}
	
}
