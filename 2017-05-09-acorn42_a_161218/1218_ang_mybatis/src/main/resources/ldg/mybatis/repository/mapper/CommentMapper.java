package ldg.mybatis.repository.mapper;

import java.util.List;
import java.util.Map;
import ldg.mybatis.model.Comment;
import ldg.mybatis.model.User;
import org.apache.ibatis.annotations.Select;

public interface CommentMapper {
	List<Comment>selectCommentByCondition(Map<String,Object>condition);
	Integer insertComment(User user);
	Integer deleteComment(Long commentNo);
	void saveUser(User user);
	User findById(long id);
	User findByName(String name);
	void updateUser(User user);
	void deleteUserById(long id);
	List<User> findAllUsers(Map<String, Object> condition);

}

//map은 generic이고, template이다. 따라서, <> 내에 데이터형을 지정해준다.