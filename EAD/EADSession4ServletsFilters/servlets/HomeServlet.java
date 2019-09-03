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
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		PreparedStatement statement2;
		try {
			statement2 = MySQLCon.getConnection().prepareStatement(
					Queries.queryForShowDetail());
			if (request.getParameter("regId") != null){
			statement2.setInt(1,
					Integer.parseInt(request.getParameter("regId")));
			}
			else {
				statement2.setInt(1,Integer.parseInt((String) request.getAttribute("regId")));
			}
			
			ResultSet result = statement2.executeQuery();
			if (result.next()) {
				request.setAttribute("regId", result.getInt(1));
				request.setAttribute("firstName", result.getString(2));
				request.setAttribute("lastName", result.getString(3));
				request.setAttribute("gender", result.getString(4));
				request.setAttribute("email", result.getString(5));
				request.setAttribute("contact", result.getString(6));
				request.setAttribute("organization", result.getString(7));
				request.setAttribute("vehicle_name", result.getString(8));
				request.setAttribute("vehicle_type", result.getString(9));
				request.setAttribute("vehicle_number", result.getString(10));
				request.setAttribute("Identification", result.getString(11));
				request.setAttribute("plan", result.getString(12));
				request.setAttribute("price", result.getInt(13));
				RequestDispatcher dispatcher = request
						.getRequestDispatcher("home.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
}
