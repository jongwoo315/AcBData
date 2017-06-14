package ldg.mybatis.repository.mapper;
import java.util.List;
import java.util.Map;
import ldg.mybatis.model.Comment;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommentMapperRepository {
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public List<Comment>selectCommentByCondition(Map<String, Object>condition){
		return sqlSession.getMapper(commentMapper.class).selectCommentByCondition(condition);
	}
	
	public Integer insertComment(Comment comment){
		Integer result = sqlSession.getMapper(commentMapper.class).insertComment(comment);
		return result;
	}
	
	public Integer deleteComment(Long commentNo){
		Integer result = sqlSession.getMapper(commentMapper.class).deleteComment(commentNo);
		return result;
	}
}
