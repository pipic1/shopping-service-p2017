package io.github.aurelienpillevesse;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

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
 * Root resource (exposed at "book" path)
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
    	Boolean isbnExists = null;

    	//database connexion
    	//verification si isbn est correct
    	try {		
		Statement st = db.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM books WHERE isbn = 1418548484");
		while (rs.next()) {
		    System.out.print("Colonne 1 renvoyée ");
		    System.out.println(rs.getString(1));
		}
		rs.close();
		st.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
    	return 'yo';
    	//si oui
    	/*if(isbnExists) {
	    	Client client = ClientBuilder.newClient();
	    	WebTarget target = client.target("https://stock-service-p2017.herokuapp.com").path("bookStock");
	    	Response r = target.request(MediaType.TEXT_PLAIN).get();
	    	//return id + ", " + isbn + ", " + from + ", " + to + ", " + corr + ", response: " + r.readEntity(String.class);
	    	return "Book available";
    	}
    	
    	//else
    	//return "Book unvailable";*/
    }
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
}
