package com.metacube.assignment.model;

public class Book {
	private int bookId;
	private String bookTitle;
	private String bookWriter;
	private String publisher;
	private int publishedYear;
	public Book(int bookId, String bookTitle, String bookWriter,
			String publisher, int publishedYear) {
		super();
		this.bookId = bookId;
		this.bookTitle = bookTitle;
		this.bookWriter = bookWriter;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
	}

	public Book() {
		
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	

	public int getPublishedYear() {
		return publishedYear;
	}

	public void setPublishedYear(int publishedYear) {
		this.publishedYear = publishedYear;
	}

}
