package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudentsServlet
 */

public class ShowStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("hello");
		try {
			Statement statement = MySQLCon.getConnection().createStatement();
			ResultSet result = statement.executeQuery(Queries
					.queryForShowStudents());
			PrintWriter out = response.getWriter();
			out.print("<html><body>");
			out.print("<table border = '1'>");
			out.print("<tr><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr"
					+ ">");
			while (result.next()) {

				out.print("<tr><form action = 'UpdateStudentDetailsServlet'><td id='email'>"
						+ "<input type = 'text' name='email' readonly value ="
						+ result.getString(1)
						+ "> "
						+ "</td><td id='firstName'>"
						+ "<input type = 'text' name='firstName'  value ="
						+ result.getString(2)
						+ "> "
						+ "</td><td id='lastName'>"
						+ "<input type = 'text' name='lastName'  value ="
						+ result.getString(3)
						+ "> "
						+ "</td><td id='fatherName'>"
						+ "<input type = 'text' name='fatherName' value ="
						+ result.getString(4)
						+ "> "
						+ "</td><td id='class'>"
						+ "<input type = 'text' name='class'  value ="
						+ result.getString(5)
						+ "> "
						+ "</td><td id='age'>"
						+ "<input type = 'text' name='age' value ="
						+ result.getString(6)
						+ "> "
						+ "</td><td>"
						+ "<input type='submit' name='submitButton' value = 'update'></form></td></tr>");

			}
			out.print("</table>");
			out.print("</body></html>");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
