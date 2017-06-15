package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.web.model.User;

@Repository
public class UserMapperRepository{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	public User selectUserCondition(Map<String, Object> condition) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).selectUserCondition(condition);
	}

	public List<User> selectAllUser() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).selectAllUser();
	}


	public int insertUser(User user) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).insertUser(user);
	}


	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).updateUser(user);
	}


	public int deleteUser(String id) {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).deleteUser(id);
	}


	public int deleteAllUser() {
		// TODO Auto-generated method stub
		return sqlSession.getMapper(UserMapper.class).deleteAllUser();
	}

}
