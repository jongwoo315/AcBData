package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.mybatis.spring.SqlSessionTemplate;
import ldg.mybatis.model.User;

@Repository
public class UserMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	/*private static final AtomicLong counter = new AtomicLong();*/
	/*private static List<User> users;*/
	
	/*static {
		users = populateDummyUsers();
	}*/
	
	public List<User> findAllUsers() {
		return sqlSession.getMapper(UserMapper.class).findAllUsers();
	}
	
	public User findById(long id) {
		return sqlSession.getMapper(UserMapper.class).findById(id);
	}
	
	public User findByName(String name) {
		return sqlSession.getMapper(UserMapper.class).findByName(name);
	}
	
	public void saveUser(User user) {
		sqlSession.getMapper(UserMapper.class).saveUser(user);
	}
	
	public void updateUser(User user) {
		sqlSession.getMapper(UserMapper.class).updateUser(user);
	}
	
	public void deleteUserById(long id) {
		sqlSession.getMapper(UserMapper.class).deleteUserById(id);
	}
	
	public boolean isUserExist(User user) {
		boolean check = false;
		User checkName = sqlSession.getMapper(UserMapper.class).isUserExist(user.getName());
		if (checkName != null) check=true;
		return check;
	}
	
	public void deleteAllUsers() {
		sqlSession.getMapper(UserMapper.class).deleteAllUsers();
    }
	
	/*private static List<User> populateDummyUsers() {
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(), "RED", "NY", "RED@naver.com"));
		users.add(new User(counter.incrementAndGet(), "BLUE", "LA", "BLUE@yahoo.com"));
		users.add(new User(counter.incrementAndGet(), "GREEN", "NEBRASKA", "RED@gmail.com"));
		return users;
	}*/
}
