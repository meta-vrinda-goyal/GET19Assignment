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
 * Servlet implementation class FriendServlet
 */
@WebServlet("/FriendServlet")
public class FriendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			PreparedStatement statement = MySQLCon.getConnection().prepareStatement(Queries.queryForShowFriends());
			
			statement.setInt(1, Integer.parseInt(request.getParameter("empRegId")));
			statement.setString(2, request.getParameter("empOrganization"));
			ResultSet result = statement.executeQuery();
			PrintWriter out = response.getWriter();
			request.setAttribute("friendList", result);
	        getServletContext().getRequestDispatcher("/friend.jsp").include(request, response);
//		     ArrayList<ArrayList<Comparable>> rows = new ArrayList<ArrayList<Comparable>>();
//		     ArrayList<Comparable> regId = new ArrayList<Comparable>();
//			
//			 while (result.next()) {
//				ArrayList<Comparable> row = new ArrayList<Comparable>();
//				
//				regId.add(result.getInt(1));
//				row.add(result.getString(2));
//				row.add(result.getString(3));
//
//				rows.add(row);
//				request.setAttribute("list", rows);
//				request.setAttribute("regId", regId);
//			    
//				RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/friend.jsp");
//				requestDispatcher.forward(request,response);
//
//			}
//			 
		}

		catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
