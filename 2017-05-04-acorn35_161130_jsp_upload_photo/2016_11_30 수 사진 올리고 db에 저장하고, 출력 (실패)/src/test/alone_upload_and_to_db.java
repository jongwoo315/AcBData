package test;

// 기본 import
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// upload import
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletContext;
import java.io.File;
import java.util.ArrayList;

// db import
import java.io.PrintWriter;
import java.sql.*;
import javax.sql.*;
import javax.naming.*;

@WebServlet("/alone_upload_and_to_db")
public class alone_upload_and_to_db extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public alone_upload_and_to_db() {super();}
    
//    static File dir = null;
    
//    static File diraa(String a){
//    	dir = new File(a);
//    	return dir;
//    }    
    static File file = null;
    static File getfile(String a, String b){
    	return file = new File(a, b);
    }
    private String tourl(){
    	return file.toString();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							// 파일을 서버에 올리는 과정
		response.setContentType("text/html;charset=utf-8");
		String name = "";
		String id = "";
		String pw = "";
		String filename = "";
		//static File dir;
		boolean check = ServletFileUpload.isMultipartContent(request);
		//PrintWriter out = response.getWriter();
		
		if(check){
			ServletContext context = this.getServletContext();
			//ServletContext is used to get configuration information from Deployment Descriptor(web.xml)
			String path = context. getRealPath("/uploaddata");
			//getRealPath: Gets the real path corresponding to the given virtual path
			File dir = new File(path);
			//dir = new File(path);
			// java.io.File;
			if(!dir.exists()) {dir.mkdir();}
			// java.io.File.exists() method	//java.io.File.mkdir() method
			try{
				DiskFileItemFactory factory = new DiskFileItemFactory();
				factory.setSizeThreshold(10 * 1024);
				factory.setRepository(dir);
				ServletFileUpload upload = new ServletFileUpload(factory);
				upload.setSizeMax(10 * 1024 * 1024);
				upload.setHeaderEncoding("UTF-8");
				
				ArrayList items = (ArrayList)upload.parseRequest(request);
				for(int i = 0; i < items.size(); ++i){
					FileItem item = (FileItem)items.get(i);
					String value = item.getString("UTF-8");
					
					if(item.isFormField()){
						if(item.getFieldName().equals("name")) name = value;
						else if(item.getFieldName().equals("id")) id = value;
						else if(item.getFieldName().equals("pw")) pw = value;
					}
					else{
						if(item.getFieldName().equals("picture")){
							filename = item.getName();
							if(filename == null || filename.trim().length()==0) continue;
							filename = filename.substring(filename.lastIndexOf("\\")+1);
							file = new File(dir, filename);	// 이놈이 주소의 전체 경로다!!!!!!!!!!
                			item.write(file);
                			//PrintWriter aaa = response.getWriter();
                			//aaa.println("path_maybe"+file);
                			// 파일을 upload 경로에 실제로 저장한다.
                			// fileitem 객체를 통해 바로 출력 저장할 수 있다.							
						}
					}
				}							
			}catch(FileUploadException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace(); 	// 사진 업로드와 관련된 exception 처리. 없으면 item.write(file)에서 오류발생
			}
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			
			out.println("<html><body>");
			out.println("회원 가입할 이름: "+name+"<br/>");
			out.println("회원 가입할 아이디: "+id+"<br/>");
			out.println("회원 가입할 비번: "+pw+"<br/>");
			out.println("회원 가입할 사진 저장 경로: "+dir+"<br/>");
			out.println("회원 가입할 사진 파일 이름: "+file+"<br/>");
			//out.println("<img src=" + dir + "/" + filename+">" );
			/*\" C:Users/USER/eclipse_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/1130_wed/uploaddata/abc.jpg\">"*/
			
		}	// if

		
		
							///////////////////////////////////// 파일을 DB에 저장하는 과정 /////////////////////////////////////////
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<html><body><center><h3>");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String query = "insert into upload values(?, ?, ?, ?, ?)";
		
		try{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/myconn"); // web.xml에서 리턴받기로 설정한 값
			conn = source.getConnection();
		}catch(Exception e){
			out.println("접속오류!!!!!!");
			out.println();
		}
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, pw);
			pstmt.setString(4, filename);
			pstmt.setString(5, tourl());
			
			int res = pstmt.executeUpdate();
			if(res > 0){out.println("저장성공");}
			pstmt.close();
			conn.close();			
		}catch(Exception e){
			out.print("SQL Process Error: "+e.getMessage());
		}
		
		out.println("</h3></center></body></html>");
		
	} //doPost

} // public class
