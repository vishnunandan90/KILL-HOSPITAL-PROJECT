package com.vishnu;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class empservlet
 */
@WebServlet("/empservlet")
public class empservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tempname;
		String temppwd;
		if(request.getParameter("empusername").equals("vishnunandan90@gmail.com") && request.getParameter("emppwd").equals("PLhv@123")){
			response.setContentType("text/html");
			response.sendRedirect("emphome.jsp");
		}
		else {
			response.setContentType("text/html");
			response.getWriter().println("please enter a valid username and password");
			request.getRequestDispatcher("employee.html").include(request, response);			
		}
			
	}

}
