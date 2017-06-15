package ldg.mybatis.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ldg.mybatis.model.User;
import ldg.mybatis.repository.mapper.UserMapperRepository;

@Service
public class UserService {

	@Autowired
	private UserMapperRepository userRepository;
	
	public List<User> findAllUsers() {
		return userRepository.findAllUsers();
	}
	
	public User findById(long id) {
		return userRepository.findById(id);
	}
	
	public User findByName(String name) {
		return userRepository.findByName(name);
	}
	
	public void saveUser(User user) {
		userRepository.saveUser(user);
	}
	
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}
	
	public void deleteUserById(long id) {
		userRepository.deleteUserById(id);
	}
	
	public boolean isUserExist(User user) {
		return userRepository.isUserExist(user);
	}
	
	public void deleteAllUsers() {
		userRepository.deleteAllUsers();
	}
}
