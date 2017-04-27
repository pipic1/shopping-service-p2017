package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
import io.github.aurelienpillevesse.model.Book;

public class BookDAO extends DAO<Book> {
	public BookDAO(Connection conn) {
		super(conn);
	}
	
	public boolean create(Book object) {
		return false;
	}
	
	public boolean delete(Book object) {
		return false;
	}	
	 
	public boolean update(Book object) {
		return false;
	}
	 
	public Book find(int id) {
		Book book = new Book();      
		
		return book;
	}
}