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

/**
 * Servlet implementation class PassDetailServlet
 */
@WebServlet("/PassDetailServlet")
public class PassDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			PrintWriter out = response.getWriter();
			//out.print(request.getParameter("priceInINR"));
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForAddPassDetail());
			
			statement.setInt(1, Integer.parseInt(request.getParameter("regId")));
			statement.setString(2, request.getParameter("pricePlan"));
			statement.setInt(3, Integer.parseInt(request.getParameter("priceInINR")));
			statement.executeUpdate();
			request.setAttribute("regId",
					Integer.parseInt(request.getParameter("regId")));
			RequestDispatcher rd = request
					.getRequestDispatcher("HomeServlet");
			rd.forward(request, response);
			
		}
		
		catch (SQLException e) {


			e.printStackTrace();
		}
		
		
		
	}

	

}
