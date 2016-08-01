package com.bitwise.Assignment1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.swing.JOptionPane;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		Map userMap= new HashMap();
		userMap.put("nitesh","ojufti");
		userMap.put("raki","captaan");
		userMap.put("kk","kapila");
		String username=request.getParameter("username");
		String pass=request.getParameter("password");
		PrintWriter out=response.getWriter();
		//out.println(userMap.containsKey(username));
		//out.println(userMap.get(username));
			if(!(userMap.containsKey(username)&& userMap.get(username).equals(pass)))
			{
				out.println("invalid credentials");
				request.getRequestDispatcher("loginform.html").include(request, response);
			}
			else
			{	
		// pass the request along the filter chain
		chain.doFilter(request, response);
			}
			
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
