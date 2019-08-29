package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForAddStudent());
			statement.setString(1, request.getParameter("email"));
			statement.setString(2, request.getParameter("first_name"));
			statement.setString(3, request.getParameter("last_name"));
			statement.setString(4, request.getParameter("father_name"));
			statement.setInt(5, Integer.parseInt(request.getParameter("class")));
			statement.setInt(6, Integer.parseInt(request.getParameter("age")));
			statement.executeUpdate();
			PrintWriter out = response.getWriter();
			out.println("Student details Submitted successfully");
			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
