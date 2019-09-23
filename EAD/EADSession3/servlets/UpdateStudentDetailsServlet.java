package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateStudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		try {
			PrintWriter out = response.getWriter();
			out.print("Updated Successfully");
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForUpdateStudent());
			statement.setString(1, request.getParameter("firstName"));
			statement.setString(2, request.getParameter("lastName"));
			statement.setString(3, request.getParameter("fatherName"));
			statement.setInt(4, Integer.parseInt(request.getParameter("class")));
			statement.setInt(5, Integer.parseInt(request.getParameter("age")));
			statement.setString(6, request.getParameter("email"));
			statement.executeUpdate();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
