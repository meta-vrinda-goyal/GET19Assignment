package com.metacube.assignment.dao;

import java.util.List;

import com.metacube.assignment.enums.Status;
import com.metacube.assignment.model.Book;

public interface BaseDao<T> {
/**
 * method to show all books
 * @param query 
 * @return list of books
 */
public abstract List<Book> showBookList(String query);

/**
 * method to show books by title
 * @param query
 * @return book 
 */
public abstract Book showBookByTitle(String query);

/**
 * method to delete all books
 * @param query
 * @return status enum 
 */
public abstract Status deleteAllBooks(String query);



/**
 * method to delete book by Id
 * @param query
 * @return status enum 
 */
public abstract Status deleteBookById(String query);

/**
 * Insert new book record
 * @param query
 * @return Status enum
 */
public abstract Status addBook(String query);

/**
 * Update book published year  by title
 * @param query
 * @return
 */
public abstract Status updateBook(String query);
}
