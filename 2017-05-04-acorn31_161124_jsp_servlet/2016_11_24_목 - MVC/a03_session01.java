package test;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;
//import org.apache.catalina.servlet4preview.RequestDispatcher;


@WebServlet("/a03_session01")
public class a03_session01 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public a03_session01() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setAttribute("data1", "bbba");

		HttpSession session = request.getSession(true);
			// data2
			session.setAttribute("data2", "자바");
			// data3
			Calendar data3 = Calendar.getInstance();
			session.setAttribute("data3", data3);
		
		ServletContext context = this.getServletContext();
		RequestDispatcher dispatcher = context.getRequestDispatcher("/a04_session02");
		dispatcher.forward(request, response);
	}

}
