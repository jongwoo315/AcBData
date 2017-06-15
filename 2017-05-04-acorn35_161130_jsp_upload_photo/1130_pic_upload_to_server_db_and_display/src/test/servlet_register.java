package test;

import java.io.File;
// 기본 import
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
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
//import org.apache.tomcat.jni.File;


@WebServlet("/servlet_register")
public class servlet_register extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public servlet_register() {super();}
    
    static File file = null;
    
    static File getfile(String a, String b){
    	return file = new File(a, b);
    }
    
    private String tourl(){
    	return file.toString();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
							// 파일을 서버에 올리는 과정
		String name = "";
		String id = "";
		String pw = "";
		String filename = "";
		//static File dir;
		boolean check = ServletFileUpload.isMultipartContent(request);

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
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
			
			//response.setContentType("text/html; charset=utf-8");
			//PrintWriter out = response.getWriter();			
			
			// 없어도 되는 부분
			
			out.println("<html><body>");
			out.println("회원 가입할 이름: "+name+"<br/>");
			out.println("회원 가입할 아이디: "+id+"<br/>");
			out.println("회원 가입할 비번: "+pw+"<br/>");
			out.println("회원 가입할 사진 저장 경로: "+dir+"<br/>");
			out.println("회원 가입할 사진 파일 이름: "+file+"<br/>");
			
			// 없어도 되는 부분
			
			//out.println("<img src=" + dir + "/" + filename+">" );
			/*\" C:Users/USER/eclipse_workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/1130_wed/uploaddata/abc.jpg\">"*/			

			DTO dto = new DTO();
			dto.setName(name);
			dto.setId(id);
			dto.setPw(pw);
			dto.setFilename(filename);
			dto.setUrl(tourl());
			
			DAO dao = new DAO();
			boolean bool = dao.register(dto);
			
			if(bool){
				out.println("DB에 입력성공!!!");
			}
		}	// if
		
	} //doPost

} // public class
