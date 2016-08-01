package com.bitwise.Assignment1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/DetailServlet")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out= response.getWriter();
		HttpSession session=request.getSession(false);
		if(session==null)
		{
			out.println("invlaid session.plz login first");
			request.getRequestDispatcher("loginform.html").include(request, response);
		}
		else{
		out.println("welcome "+ session.getAttribute("username"));
		String name= request.getParameter("uname");
		String dob=request.getParameter("dob");
		String email=request.getParameter("mailid");
		String cont=request.getParameter("contact");
		
		out.println("name- "+name);
		out.println("dob- "+dob);
		out.println("emailid- "+email);
		out.println("contact- "+cont);
		session.invalidate();
		}}
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
