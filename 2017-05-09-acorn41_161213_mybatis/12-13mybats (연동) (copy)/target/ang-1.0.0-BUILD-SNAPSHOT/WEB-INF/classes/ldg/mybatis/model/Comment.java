package ldg.mybatis.model;

import java.io.Serializable;
import java.util.Date;

@SuppressWarnings("serial")
public class Comment implements Serializable {//Serializable자동으로 형식에마춰서 처리해줌

	private Long commentNo;
	private String userId;
	private Date regDate;
	private String commentContent;
	
	public Comment() {
		
	}
	
	public Comment(Long commentNo, String userId, String commentContent, Date regDate) {
		this.commentNo = commentNo;
		this.userId = userId;
		this.commentContent = commentContent;
		this.regDate = regDate;
	}
	
	public Long getCommentNo() {
		return this.commentNo;
	}
	
	public String getUserId() {
		return this.userId;
	}
	
	public Date getRegDate() {
		return this.regDate;
	}
	
	public String getCommentContent() {
		return this.commentContent;
	}
	
	public void setCommentNo(Long commentNo) {
		this.commentNo = commentNo;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	
	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

}
