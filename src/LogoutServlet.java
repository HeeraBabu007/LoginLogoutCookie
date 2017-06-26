

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
	    RequestDispatcher rd=request.getRequestDispatcher("header.html");
	    rd.include(request, response);
	    Cookie c1=new Cookie("name","");
	    c1.setMaxAge(0);
	    response.addCookie(c1);
	    out.println("You are logged out !");
	    
	}

}
