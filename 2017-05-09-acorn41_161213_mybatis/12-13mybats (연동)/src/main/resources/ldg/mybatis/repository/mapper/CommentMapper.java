package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;

import ldg.mybatis.model.User;



public interface CommentMapper {
	
	List<User>selectCommentByCondition(Map<String,Object>condition);
	Integer insertComment(User User);
	Integer deleteComment(long id);
	Integer updateComment(User user);
}
