package io.github.aurelienpillevesse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("book")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook(
    	@QueryParam("account") int id,
    	@QueryParam("isbn") int isbn,
    	@QueryParam("from") String from,
    	@QueryParam("to") String to,
    	@QueryParam("corr") int corr
    ) {    	
    	Client client = ClientBuilder.newClient();
    	WebTarget target = client.target("https://stock-service-p2017.herokuapp.com").path("bookStock");
    	 
    	Response r = target.request(MediaType.TEXT_PLAIN).get();
        return id + ", " + isbn + ", " + from + ", " + to + ", " + corr + ", response: " + r.readEntity(String.class);
    }
}
