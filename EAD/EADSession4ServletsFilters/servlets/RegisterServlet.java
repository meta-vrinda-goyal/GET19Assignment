package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			if(!(request.getParameter("password").equals(request.getParameter("confirm_password")))) {
				out.print("Password does not match");
			response.sendRedirect("index.html");
			}
			else{
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForAddEmployee());
			statement.setString(1, request.getParameter("first_name"));
			statement.setString(2, request.getParameter("last_name"));
			statement.setString(3, request.getParameter("gender"));
			statement.setString(4, request.getParameter("email"));
			statement.setString(5, request.getParameter("password"));
			statement.setString(6, request.getParameter("contact"));
			statement.setString(7, request.getParameter("organization"));
			statement.executeUpdate();
			
			PreparedStatement regId = MySQLCon.getConnection().prepareStatement(Queries.queryForGetEmpRegID()); 
			ResultSet result = regId.executeQuery();
			
			result.next();
			HttpSession session = request.getSession();
			session.setAttribute("emp_id", result.getInt(1));
			getServletContext().getRequestDispatcher("/vehicleReg.jsp").include(request, response);
			}
			//request.setAttribute("regId", result.getInt(1));
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("vehicleReg.jsp") ;
			//dispatcher.include( request, response ) ;
		}
		
		
		catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.print("<html><body>User already exist<br><a href='log_in.html'>Log In</a></body></html>");
			e.printStackTrace();
		}
	}

}
