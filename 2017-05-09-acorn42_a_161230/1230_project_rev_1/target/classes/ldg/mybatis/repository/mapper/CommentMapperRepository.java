package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;



import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ldg.mybatis.model.User;

@Repository
public class CommentMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;

	public List<User> selectCommentByCondition(Map<String, Object> condition) {
		return sqlSession.getMapper(CommentMapper.class).selectCommentByCondition(condition);
	}

	public Integer insertComment(User user) {
		Integer result = sqlSession.getMapper(CommentMapper.class).insertComment(user);
		return result;
	}

	public Integer deleteComment(long id) {
		Integer result = sqlSession.getMapper(CommentMapper.class).deleteComment(id);
		return result;
	}
	public Integer updateComment(User user) {
		Integer result = sqlSession.getMapper(CommentMapper.class).updateComment(user);
		return result;
	}
}
