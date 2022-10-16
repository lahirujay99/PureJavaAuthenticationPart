package com.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
		
			String username = request.getParameter("uid");
			String password = request.getParameter("pass");
			
			boolean isTrue = CustomerDBUtil.validate(username, password);
			
			if(isTrue) {
				List<Customer> cusDetails = CustomerDBUtil.getCustomer(username);
				request.setAttribute("cusDetails", cusDetails);
				RequestDispatcher dis = request.getRequestDispatcher("userAccount.jsp");
				dis.forward(request, response);
			}else {
				out.println("<script type='text/javascript'>");
				out.println("alert('your username or password incorrect');");
				out.println("location='login.jsp'");
				out.println("</script>");
			}
			
		
	}

}
