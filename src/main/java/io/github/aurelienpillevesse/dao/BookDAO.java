package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import io.github.aurelienpillevesse.model.Book;

public class BookDAO extends DAO<Book> {
	public BookDAO() {
		super();
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
	
	public List<Book> findAll() {
		List<Book> books = new ArrayList<>();
		
		try {
			this.st = this.connect.prepareStatement("select * from books");
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				Book book = new Book();
				
				book.setIsbn(this.rs.getString("isbn"));
				book.setBookName(this.rs.getString("book_name"));
				
				books.add(book);
			}
			this.rs.close();
			this.st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return books;
	}

	public Book find(String isbn) {
		Book book = new Book();
		
		try {
			this.st = this.connect.prepareStatement("select * from books where isbn = ?");
			this.st.setString(1, isbn);
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				book.setIsbn(this.rs.getString("isbn"));
			}
			this.rs.close();
			this.st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
}
