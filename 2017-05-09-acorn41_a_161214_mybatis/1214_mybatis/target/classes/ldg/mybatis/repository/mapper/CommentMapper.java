package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;
import ldg.mybatis.model.Comment;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper {
	List<Comment>selectCommentByCondition(Map<String,Object>condition);
	Integer insertComment(Comment comment);
	Integer deleteComment(Long commentNo);
}

//map은 generic이고, template이다. 따라서, <> 내에 데이터형을 지정해준다.
