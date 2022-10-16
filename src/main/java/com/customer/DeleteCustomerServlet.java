package com.customer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		boolean result = CustomerDBUtil.deleteCustomer(id);
		if(result) {
			RequestDispatcher rd = request.getRequestDispatcher("customerinsert.jsp");
			rd.forward(request, response);
		}else {
			List<Customer> cusDetails = CustomerDBUtil.getCustomerDetails(id);
			request.setAttribute("cusDetails",cusDetails);
			RequestDispatcher rd = request.getRequestDispatcher("userAccount.jsp");
			rd.forward(request, response);
		}
		
	}

}
