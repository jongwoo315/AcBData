package ldg.mybatis.service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import ldg.mybatis.model.Comment;
import ldg.mybatis.repository.mapper.CommentMapperRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ldg.mybatis.model.User;
@Service("commentService")
public class CommentService {

	@Autowired
	private CommentMapperRepository commentRepository;

	public List<Comment>selectComment(Long commentNo){
		Map<String,Object>condition = new HashMap<String,Object>();
		condition.put("commentNo", commentNo);

		return commentRepository.selectCommentByCondition(condition);
		// CommentMapperRepository.java의 selectCommentByCondition의 값을 반환
	}

	public Integer insertComment(User user){
		return commentRepository.insertComment(user);
	}

	public Integer deleteComment(Long commentNo){
		return commentRepository.deleteComment(commentNo);
	}

}