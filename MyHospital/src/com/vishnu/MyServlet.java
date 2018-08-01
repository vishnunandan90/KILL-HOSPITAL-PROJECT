package com.vishnu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/myservlet")
public class MyServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pname = request.getParameter("pname");
		int age = Integer.parseInt(request.getParameter("age"));
		String d = request.getParameter("date");	
		int timeslot = Integer.parseInt(request.getParameter("timeslot"));
		MyModel m = new MyModel();
		if(m.isAvailable(d,timeslot)) {
			patient p = new patient(pname,age,d,timeslot);
			m.addPatient(p);	
			HttpSession session = request.getSession();
			session.setAttribute("noslot", "");
		}
		else {
			response.setContentType("text/html");
			PrintWriter pw = response.getWriter();
			pw.println("invalid");
			RequestDispatcher rd = request.getRequestDispatcher("patientreg.jsp");
			rd.include(request,response);
			
		}
		
	}

}
