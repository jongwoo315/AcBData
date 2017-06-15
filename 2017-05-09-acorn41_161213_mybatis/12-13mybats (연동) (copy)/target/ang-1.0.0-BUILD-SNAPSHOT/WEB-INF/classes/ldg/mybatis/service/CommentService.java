package ldg.mybatis.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ldg.mybatis.model.User;
import ldg.mybatis.repository.mapper.CommentMapperRepository;

@Service
public class CommentService {
	@Autowired
	private CommentMapperRepository commentRepository;

	public List<User> selectComment(String username) {
		Map<String, Object> condition = new HashMap<String, Object>();
		condition.put("username", username);
		
		return commentRepository.selectCommentByCondition(condition);
	}

	public Integer insertComment(User user) {

		return commentRepository.insertComment(user);
	}

	public Integer deleteComment(String username) {
		return commentRepository.deleteComment(username);
	}
}
