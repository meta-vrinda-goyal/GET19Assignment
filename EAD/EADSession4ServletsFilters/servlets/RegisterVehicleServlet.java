package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterVehicleServlet
 */
@WebServlet("/RegisterVehicleServlet")
public class RegisterVehicleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForAddVehicle());
			statement.setString(1, request.getParameter("emp_Id"));
			statement.setString(2, request.getParameter("vehicle_name"));
			statement.setString(3, request.getParameter("vehicle_type"));
			statement.setString(4, request.getParameter("vehicle_number"));
			statement.setString(5, request.getParameter("Identification"));
			statement.executeUpdate();
			request.setAttribute("emp_Id", request.getParameter("emp_Id"));
			request.setAttribute("typeOfVehicle", request.getParameter("vehicle_type"));
			RequestDispatcher dispatcher = request.getRequestDispatcher("passDetail.jsp") ;
			dispatcher.include( request, response ) ;
		} 
		
		catch (SQLException e) {
			PrintWriter out = response.getWriter();
			out.print("<html><body>Vehicle already exist or RegId does not exist<br><a href='log_in.html'>Log In</a></body></html>");
			e.printStackTrace();
		}
	}

	

}
