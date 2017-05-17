package io.github.aurelienpillevesse;

import java.net.URI;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
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
		DAO<Book> daoFind = new BookDAO();
    	Book book = null;
    	book = daoFind.find(isbn);
    	
    	if(isbn == "-1" || quantity == -1 || book.getIsbn() == null) {
			return null;
		}
    	
    	if(quantity > book.getStock()) {
    		Client client = ClientBuilder.newClient();
        	WebTarget target = client.target("https://inf63app12.appspot.com/ws");
        	
        	String input = "{\"quantity\":" + quantity + ",\"stock\": " + book.getStock() + ",\"isbn\":\"" + book.getIsbn() + "\"}";
        	Response r = target.request().put(Entity.json(input), Response.class);

        	if(r.getStatus() == 400) {
        		return Response.status(r.getStatus()).entity(r.readEntity(CustomResponse.class).getMessage()).build();
        	}
    	} else {
    		DAO<Book> daoUpdate = new BookDAO();
    		daoUpdate.updateStock(book, quantity);
    	}
    	
    	cr.setData(null);
    	cr.setMessage("Order ready");
    	
    	return Response.status(200).entity(cr).build();
	}	
}