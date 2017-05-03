package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
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

	public Book find(int isbn) {
		Book book = new Book();
		
		try {
			this.st = this.connect.prepareStatement("select * from books where isbn = ?");
			this.st.setInt(1, isbn);
			this.rs = this.st.executeQuery();
			while (rs.next()) {
				book.setIsbn(this.rs.getInt("isbn"));
			}
			this.rs.close();
			this.st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return book;
	}
}
