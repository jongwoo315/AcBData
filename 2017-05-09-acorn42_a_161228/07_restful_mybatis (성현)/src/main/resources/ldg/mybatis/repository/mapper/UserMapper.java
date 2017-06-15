package ldg.mybatis.repository.mapper;

import java.util.List;
import ldg.mybatis.model.User;

public interface UserMapper {

	User findById(long id);
	
	User findByName(String name);
	
	void saveUser(User user);
	
	void updateUser(User user);
	
	void deleteUserById(long id);
	
	List<User> findAllUsers();
	
	void deleteAllUsers();
	
	User isUserExist(String name);
	
}
