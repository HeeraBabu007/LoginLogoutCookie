

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet 
{
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
	throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
	    RequestDispatcher rd=request.getRequestDispatcher("header.html");
	    //rd.forward(request, response);
	    rd.include(request, response);
	    
	    String uname=request.getParameter("username");
	    String upass=request.getParameter("pass");
	    if(upass.equals("root"))
	    {
	    	out.println("You have successfully logged In...");
	    	out.println("<br><h1>Welcome "+uname+"</h1>");
	    	
	    	Cookie c1 = new Cookie("name",uname);
	    	response.addCookie(c1);
	    }
	    else
	    {
	    	out.println("Please check Username or Password !");
	    	request.getRequestDispatcher("index.html").include(request, response);;
	    }
	    
	    out.close();
	}

}
