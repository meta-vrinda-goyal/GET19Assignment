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
 * /** Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement = MySQLCon.getConnection()
					.prepareStatement(Queries.queryForLoginEmployee());
			statement
					.setInt(1, Integer.parseInt(request.getParameter("regId")));
			PrintWriter out = response.getWriter();
			ResultSet result2 = statement.executeQuery();
			if (result2.next()) {

				if (request.getParameter("password").equals(
						result2.getString(1))) {
					request.setAttribute("regId",
							Integer.parseInt(request.getParameter("regId")));
					HttpSession session = request.getSession();
					session.setAttribute("regId",
							Integer.parseInt(request.getParameter("regId")));
					getServletContext().getRequestDispatcher("/HomeServlet")
							.include(request, response);
					

				} else {

					out.print("password invalid");
					getServletContext().getRequestDispatcher("/login.html").include(request, response);
				}
			}
			else{
				//out.print("RegId invalid");
				getServletContext().getRequestDispatcher("/login.html").include(request, response);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

}
