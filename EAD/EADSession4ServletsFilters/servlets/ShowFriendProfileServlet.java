package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowFriendProfileServlet
 */
@WebServlet("/ShowFriendProfileServlet")
public class ShowFriendProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		PreparedStatement statement;
		try {
			statement = MySQLCon.getConnection().prepareStatement(
					Queries.queryForShowFriendProfile());
			
			statement.setInt(1, Integer.parseInt(request.getParameter("friendRegId")));
			ResultSet result = statement.executeQuery();
			ArrayList<ArrayList<Comparable>> rows = new ArrayList<ArrayList<Comparable>>();
		    
//			PrintWriter out = response.getWriter();
//			out.print("RegId" +"\t" +"FirstName" +"\t"+ "LastName"+"\t"
//					+ "gender" +"\t"+ "email"+"\t"
//					+ "contact"+"\t"+ "organization");
//			out.print("\n");
			request.setAttribute("friendList", result);
	        getServletContext().getRequestDispatcher("/friendProfile.jsp").include(request, response);
//			while (result.next()) {
//				ArrayList<Comparable> row = new ArrayList<Comparable>();
//				row.add(result.getInt(1));
//				row.add(result.getString(2));
//				row.add(result.getString(3));
//				row.add(result.getString(4));
//				row.add(result.getString(5));
//				row.add(result.getString(6));
//				row.add(result.getString(7));
//				rows.add(row);
//				request.setAttribute("list", rows);
//				
//				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/friendProfile.jsp");
//				requestDispatcher.forward(request,response);
//			}
//			out.print(result.getInt(1) +"\t"+ result.getString(2)+"\t"
//					+ result.getString(3)+"\t" + result.getString(4)+"\t"
//					+ result.getString(5)+"\t" + result.getString(6)+"\t" +  result.getString(7));
//			out.print("\n");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
