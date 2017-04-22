package io.github.aurelienpillevesse;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
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
    /*@GET
    @Path("book")
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook(
    	//@QueryParam("account") int id,
    	@QueryParam("isbn") int isbn
    	//@QueryParam("from") String from,
    	//@QueryParam("to") String to,
    	//@QueryParam("corr") int corr
    ) {
    	Boolean isbnExists = null;
    	ResultSet rs;
    	String output = "";
    	output += "isbn = "+ isbn + "\n";
    	try {		
			PreparedStatement st = getConnection().prepareStatement("select * from books where ISBN = ? ");
			st.setInt(1,isbn);
			//Statement st = getConnection().createStatement();
			rs = st.executeQuery();
			while (rs.next()) {
			    output += rs.getString("isbn") + ", ";
			    output += rs.getString("book_name") + ", ";
			    output += rs.getString("publisher_name") + "\n";
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
			output += "ici\n";
		}
    	return output;
    }*/
   
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getBook(
    	@QueryParam("account") int id,
    	@QueryParam("isbn") String isbn,
    	@QueryParam("from") String from,
    	@QueryParam("to") String to,
    	@QueryParam("corr") int corr
    ) {
    	ResultSet rs = null;
    	PreparedStatement st = null;
    	String output = null;
    	
    	try {		
			st = getConnection().prepareStatement("select * from books where isbn = ?");
			st.setString(1, isbn); 
			rs = st.executeQuery();
			while (rs.next()) {
			    output = rs.getString("isbn");
			}
			rs.close();
			st.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    
	if(output == isbn && isbn != null) {
	    	Client client = ClientBuilder.newClient();
	    	WebTarget target = client.target("https://stock-service-p2017.herokuapp.com").path("bookStock");
	    	Response r = target.request(MediaType.TEXT_PLAIN).get();
	    	return "(isbn available) - response: " + r.readEntity(String.class);
	    	//return "Book available";
    	}
    	return "Book unvailable";
    }
    
    private static Connection getConnection() throws URISyntaxException, SQLException {
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        return DriverManager.getConnection(dbUrl);
    }
    
    private static Connection getConnection2() throws URISyntaxException, SQLException {
        URI dbUri = new URI(System.getenv("DATABASE_URL"));

        String username = dbUri.getUserInfo().split(":")[0];
        String password = dbUri.getUserInfo().split(":")[1];
        String dbUrl = "jdbc:postgresql://" + dbUri.getHost() + ':' + dbUri.getPort() + dbUri.getPath();

        return DriverManager.getConnection(dbUrl, username, password);
    }
}
