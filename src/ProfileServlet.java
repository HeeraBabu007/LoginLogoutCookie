

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ProfileServlet")
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
	    RequestDispatcher rd=request.getRequestDispatcher("header.html");
	    //rd.forward(request, response);
	    rd.include(request, response);
	    
	    Cookie c1[]=request.getCookies();
	    if(c1!=null)
	    {
	    	String name=c1[0].getName();
	    	if(!name.equals("") ||name!=null)
	    	{
	    		out.println("<br><b>Welcome to User Profile</b>");
	    		out.println("<br>Welcome "+name);
	    	}
	    }
	    else
	    {
	    	out.println("<br><b>Please Login First</b>");
	    	request.getRequestDispatcher("header.html").include(request, response);
	    }
	    out.close();
	
	
	}

	

}
