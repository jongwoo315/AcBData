package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;
import ldg.mybatis.model.Comment;
import org.apache.ibatis.annotations.Select;

public interface commentMapper {
	List<Comment>selectCommentByCondition(Map<String,Object>condition);
	Integer insertComment(Comment comment);
	Integer deleteComment(Long commentNo);
}
