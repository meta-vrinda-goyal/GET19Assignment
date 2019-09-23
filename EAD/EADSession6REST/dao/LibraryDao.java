package com.metacube.assignment.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.facade.LibraryFacade;
import com.metacube.assignment.model.Book;

public class LibraryDao implements BaseDao<Book> {
	private Connection connection;

	public LibraryDao() throws ClassNotFoundException, SQLException {
		connection = MySQLCon.getConnection();
	}

	@Override
	public List<Book> showBookList(String query) {
		List<Book> bookList = new ArrayList<Book>();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				Book book = new Book();
				book.setBookId(result.getInt(1));
				book.setBookTitle(result.getString(2));
				book.setBookWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));

				bookList.add(book);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return bookList;

	}

	@Override
	public Book showBookByTitle(String query) {
		Book book = new Book();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet result = statement.executeQuery();
			while (result.next()) {

				book.setBookId(result.getInt(1));
				book.setBookTitle(result.getString(2));
				book.setBookWriter(result.getString(3));
				book.setPublisher(result.getString(4));
				book.setPublishedYear(result.getInt(5));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Status deleteAllBooks(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			int result = statement.executeUpdate();
			if (result == 0){
				return Status.DELETED;
			}
			else {
				return Status.FAILED;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return Status.FAILED;
		}
		
	}


	@Override
	public Status deleteBookById(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			int result = statement.executeUpdate();
			if (result > 0){
				return Status.DELETED;
			}
			else {
				return Status.FAILED;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return Status.FAILED;
		}
		
	}

	@Override
	public Status addBook(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			int result = statement.executeUpdate();
			if (result > 0){
				return Status.INSERTED;
			}
			else {
				return Status.FAILED;
			}
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return Status.FAILED;
		}
		
	}

	@Override
	public Status updateBook(String query) {
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			if(statement.executeUpdate()>0){
				return Status.UPDATED;
			}
			
		} 
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		return Status.FAILED;
	}

}
