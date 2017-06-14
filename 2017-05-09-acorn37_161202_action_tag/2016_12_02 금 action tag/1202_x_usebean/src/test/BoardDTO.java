package test;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * 페이지 상간의 데이터 이동을 담당하는 DTO 클래스이다. 
 * content_num과 content_regdate는 DB에 저장시 자동으로 할당된다. 
 * content_regdate의 경우에는 값이 저장될 때 원하는 형태로 변형시켜야 한다.ㄴ
 * 
 * @author kimsh
 *
 */
public class BoardDTO implements Serializable {
	private int content_num;
	private String content_title;
	private String content_writer;
	private String content_contents;
	private String content_regdate;
	
	public BoardDTO() {}

	public int getContent_num() {
		return content_num;
	}
	
	public void setContent_num(int contentNum) {
		content_num = contentNum;
	}
	
	public String getContent_title() {
		return content_title;
	}

	public void setContent_title(String contentTitle) {
		content_title = contentTitle;
	}

	public String getContent_writer() {
		return content_writer;
	}

	public void setContent_writer(String contentWriter) {
		content_writer = contentWriter;
	}

	public String getContent_contents() {
		return content_contents;
	}

	public void setContent_contents(String contentContents) {		
		content_contents = contentContents;
	}
	
	public String getContent_regdate() {
		return content_regdate;
	}
	
	public void setContent_regdate(java.sql.Timestamp regdate) {
		//content_regdate에 값이 할당될 때 해당 값을 원하는 날짜 값으로 변경한다.
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		content_regdate = format.format(new java.util.Date(regdate.getTime()));
	}
}