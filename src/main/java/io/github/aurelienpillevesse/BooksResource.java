package io.github.aurelienpillevesse;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import io.github.aurelienpillevesse.dao.BookDAO;
import io.github.aurelienpillevesse.dao.DAO;
import io.github.aurelienpillevesse.model.Book;

/**
 * Root resource (exposed at "books" path)
 */
@Path("books")
public class BooksResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
    	DAO<Book> dao = new BookDAO();
    	List<Book> books = null;
    	books = dao.findAll();

    	return books;
    }
}
