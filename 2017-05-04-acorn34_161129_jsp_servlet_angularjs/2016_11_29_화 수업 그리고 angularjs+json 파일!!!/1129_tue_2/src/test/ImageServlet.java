package test;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private File image;
	
    public ImageServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = this.getServletContext();
		String path = context.getRealPath("/uploaddata");
		image = new File(path, "aaa.jpg");
		
		response.setContentType("image/jpg");
		
		DataInputStream in = new DataInputStream(new BufferedInputStream(new FileInputStream(image)));
		
		ServletOutputStream out = response.getOutputStream();
		
		byte[] data = new byte[512];
		while(true){
			int x = in.read(data, 0, data.length);
			if(x == -1) break;
			out.write(data, 0, x);
			out.flush();
		}
		in.close();
		out.close();
	}


}
