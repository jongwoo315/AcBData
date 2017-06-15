package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import com.spring.web.model.User;

public interface UserMapper {
	
	User selectUserCondition(Map<String, Object> condition);
	List<User> selectAllUser();
	
	int insertUser(User user);
	int updateUser(User user);
	
	int deleteUser(String id);
	int deleteAllUser();

}
