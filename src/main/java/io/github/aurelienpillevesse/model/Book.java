/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

import java.io.Serializable;  
import javax.xml.bind.annotation.XmlElement; 
import javax.xml.bind.annotation.XmlRootElement; 
@XmlRootElement(name = "book") 

public class Book implements Serializable {

   private static final long serialVersionUID = 1L;
   private int isbn; 
   private String bookName; 
   private String publisherName;
   private int numberOfPages;
   private int stock;
   
   public Book(){}  
   
   public Book(int isbn, String bookName, String publisherName, int numberOfPages, int stock){ 
      this.isbn = isbn;
      this.bookName = bookName;
      this.publisherName = publisherName;
      this.numberOfPages = numberOfPages;
      this.stock = stock;
   }  
    
   public int getIsbn() {
      return isbn; 
   }
   
   @XmlElement 
   public void setIsbn(int isbn) { 
      this.isbn = isbn; 
   }
   
   public String getBookName() { 
      return bookName; 
   } 
   
   @XmlElement 
   public void setBookName(String bookName) { 
      this.bookName = bookName; 
   } 
   
   public String getPublisherName() { 
      return publisherName; 
   } 
   
   @XmlElement 
   public void setPublisherName(String publisherName) { 
      this.publisherName = publisherName; 
   }
   
   public int getNumberOfPages() {
	   return numberOfPages; 
   }
	   
   @XmlElement 
   public void setNumberOfPages(int numberOfPages) { 
      this.numberOfPages = numberOfPages; 
   }
   
   public int getStock() {
	   return stock;
   }
	   
   @XmlElement 
   public void setStock(int stock) { 
      this.stock = stock; 
   }
} 