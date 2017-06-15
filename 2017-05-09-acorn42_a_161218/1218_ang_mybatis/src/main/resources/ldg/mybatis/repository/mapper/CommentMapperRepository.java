package ldg.mybatis.repository.mapper;
import java.util.List;
import java.util.Map;

import ldg.mybatis.model.Comment;
import ldg.mybatis.model.User;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;

@Repository
public class CommentMapperRepository {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	//어노테이션(@Autowired)로 di를 했기 때문에 아래에서 사용가능// bean에 있는 것을 자동으로 가져오게 설계를 했기 때문에 사용가능
	// bean의 종류: singleton, prototype
	
	public List<Comment> selectCommentByCondition(Map<String, Object>condition){
		return sqlSession.getMapper(CommentMapper.class).selectCommentByCondition(condition);
	}

	public Integer insertComment(User user){
		Integer result = sqlSession.getMapper(CommentMapper.class).insertComment(user);
		return result;
	}

	public Integer deleteComment(Long commentNo){
		Integer result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentNo);
		return result;
	}
	

	
	public User findById(long id) {
		return sqlSession.getMapper(CommentMapper.class).findById(id);
	}

	public User findByName(String name) {
		return sqlSession.getMapper(CommentMapper.class).findByName(name);
	}

	public void saveUser(User user) {
		sqlSession.getMapper(CommentMapper.class).saveUser(user);
	}
	
	public void updateUser(User user) {
		sqlSession.getMapper(CommentMapper.class).updateUser(user);
	}

	public void deleteUserById(long id) {
		sqlSession.getMapper(CommentMapper.class).deleteUserById(id);
		
	}

	public List<User> findAllUsers(Map<String, Object> condition) {
		return sqlSession.getMapper(CommentMapper.class).findAllUsers(condition);
	}

	public void clear() {
	}
}