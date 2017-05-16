package io.github.aurelienpillevesse;

import java.net.URI;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.github.aurelienpillevesse.dao.BookDAO;
import io.github.aurelienpillevesse.dao.DAO;
import io.github.aurelienpillevesse.model.Book;
import io.github.aurelienpillevesse.model.CustomResponse;


@Path("/buy")
public class BuyBook {
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response buyOne(
    	@DefaultValue("-1") @QueryParam("isbn") String isbn,
    	@DefaultValue("-1") @QueryParam("quantity") int quantity
    ) {    			
		CustomResponse cr = new CustomResponse();
    	DAO<Book> dao = new BookDAO();
    	Book book = null;
    	book = dao.find(isbn);
    	
    	if(isbn == "-1" || quantity == -1 || book.getIsbn() == null) {
			return null;
		}
    	
    	if(quantity > book.getStock()) {
    		//commander de nouveaux livres
    	} else {
    		dao.updateStock(book);
    	}
    	
    	cr.setData(null);
    	cr.setMessage("Order ready");
    	
    	return Response.status(200).entity(cr).build();
	}	
}