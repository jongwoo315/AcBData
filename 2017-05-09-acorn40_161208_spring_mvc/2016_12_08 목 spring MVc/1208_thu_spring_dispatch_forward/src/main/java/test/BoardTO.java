package test;

public class BoardTO {
	private int seq;
	private String subject;
	private String content;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	// BoardTO와 엮기 위해서는 xml파일이 필요하다
}
