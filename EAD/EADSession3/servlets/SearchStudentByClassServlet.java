package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchStudentByClassServlet
 */
@WebServlet("/SearchStudentByClassServlet")
public class SearchStudentByClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForSearchByClass());
			statement.setString(1, request.getParameter("class"));
			
			ResultSet result = statement.executeQuery();
			PrintWriter out = response.getWriter();
			int i = 0;
			out.print("<html><body>");
			out.print("<table border = '1'>");
			//out.print("<tr><th>Email</th><th>FirstName</th><th>LastName</th><th>Father'sName</th><th>Class</th><th>Age</th></tr"
			//		+ ">");
			while(result.next()){
				i++;
				out.println("<tr><td>" + result.getString(1) + "</td><td>"
						+ result.getString(2) + "</td><td>"
						+ result.getString(3) + "</td><td>"
						+ result.getString(4) + "</td><td>" + result.getInt(5)
						+ "</td><td>" + result.getInt(6) + "</td></tr>");
			}
			if(i == 0){
				out.print("No student with this class.");
			}
		} 
		
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}