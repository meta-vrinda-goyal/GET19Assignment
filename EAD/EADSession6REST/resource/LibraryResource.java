package com.metacube.assignment.resource;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.metacube.assignment.enums.Status;
import com.metacube.assignment.facade.LibraryFacade;
import com.metacube.assignment.factory.Factory;
import com.metacube.assignment.model.Book;

@Path("/home")
public class LibraryResource {
	private LibraryFacade libraryFacade = Factory.createLibraryFacade();

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String showBooks() {
		List<Book> books = libraryFacade.showBookList();
		if (books.size() > 0) {
			Gson gson = new Gson();
			String booksJson = gson.toJson(books);
			return booksJson;
		} else {
			return "No books to show";
		}
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String showBookByTitle(@PathParam("title") String title) {
		
		Book book = libraryFacade.showBookByTitle(title);
		if (book.getBookId() > 0) {
			Gson gson = new Gson();
			String booksJson = gson.toJson(book);
			return booksJson;

		} else {
			return "No books Found By this title";
		}
	}
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public String deleteAllBooks() {
		Status status =  libraryFacade.deleteAllBooks();
		if (Status.DELETED.equals(status)) {
			return "All Books successfully deleted";

		} 
		else {
			return "Operation failed";
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String deleteBookById(@PathParam("id") int id) {
		Status status =  libraryFacade.deleteBookById(id);
		if (Status.DELETED.equals(status)) {
			return "Book successfully deleted";

		} 
		else {
			return "Operation failed";
		}
	}
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{title}")
	public String updateBook(@PathParam("title") String title, Book book) {
		Status status =  libraryFacade.updateBook(title,book.getPublishedYear());
		if (Status.UPDATED.equals(status)) {
			return "Book successfully updated";

		} 
		else {
			return "Operation failed";
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public String addBook(Book book) {
		Status status =  libraryFacade.addBook(book.getBookTitle(),book.getBookWriter(),book.getPublisher(),book.getPublishedYear());
		if (Status.INSERTED.equals(status)) {
			return "Book successfully ADDED";

		} 
		else {
			return "Operation failed";
		}
	}
	
}


