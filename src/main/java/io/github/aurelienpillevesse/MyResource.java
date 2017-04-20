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
    	Statement st;
    	ResultSet rs;
    	String output = "";
    	//database connexion
    	//verification si isbn est correct
    	output += "before\n";
    	try {		
			st = getConnection().createStatement();
			rs = st.executeQuery("SELECT * FROM books;");
			output+=rs.getString("book_name");
			while (rs.next()) {
			    output += rs.getString("book_name");
			}
		} catch (Exception e) {
			e.printStackTrace();
			output += "ici\n";
		}
    	return output;
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
