package io.github.aurelienpillevesse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;
import javax.ws.rs.DefaultValue;

import io.github.aurelienpillevesse.dao.BookDAO;
import io.github.aurelienpillevesse.dao.DAO;
import io.github.aurelienpillevesse.model.Book;
import io.github.aurelienpillevesse.model.CustomResponse;

/**
 * Root resource (exposed at "book" path)
 */
@Path("book")
public class MyResource {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public CustomResponse getBook(
    	@QueryParam("account") int id,
    	@DefaultValue("-1") @QueryParam("isbn") String isbn,
    	@QueryParam("from") String from,
    	@QueryParam("to") String to,
    	@QueryParam("corr") int corr
    )
    {
    	CustomResponse cr = new CustomResponse();
    	DAO<Book> dao = new BookDAO();
    	Book book = null;
    	book = dao.find(isbn);

    	if(book.getIsbn() == null) {
    		cr.setData(null);
        	cr.setData("Book unavailable");
        	return cr;
    	}
    	
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("https://stock-service-p2017.herokuapp.com").path("bookStock");
    	Response r = target.request().post(Entity.json(book));
    	//return r.readEntity(Book.class);
    	
    	cr.setData(r.readEntity(Book.class));
    	cr.setMessage("Book available");
    	return cr;
    }
}
