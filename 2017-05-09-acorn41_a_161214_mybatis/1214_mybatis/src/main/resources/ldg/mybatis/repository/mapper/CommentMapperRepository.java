package ldg.mybatis.repository.mapper;
import java.util.List;
import java.util.Map;

import ldg.mybatis.model.Comment;

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

	public Integer insertComment(Comment comment){
		Integer result = sqlSession.getMapper(CommentMapper.class).insertComment(comment);
		return result;
	}

	public Integer deleteComment(Long commentNo){
		Integer result = sqlSession.getMapper(CommentMapper.class).deleteComment(commentNo);
		return result;
	}
}
