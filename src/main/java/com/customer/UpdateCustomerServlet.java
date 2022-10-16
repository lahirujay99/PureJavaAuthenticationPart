package com.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String username = request.getParameter("usn");
			String password = request.getParameter("pwd");
			
			boolean result = CustomerDBUtil.updateCustomer(id, name, email, phone, username, password);
			
			if(result) {
				List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
				request.setAttribute("cusDetails",cusDetails);
				RequestDispatcher rd = request.getRequestDispatcher("userAccount.jsp");
				rd.forward(request, response);
			}else {
				List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
				request.setAttribute("cusDetails",cusDetails);
				RequestDispatcher rd = request.getRequestDispatcher("userAccount.jsp");
				rd.forward(request, response);
			}
	}

}
