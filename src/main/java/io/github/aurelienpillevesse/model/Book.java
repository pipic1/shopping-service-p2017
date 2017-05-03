/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

public class Book {

   private Integer isbn;
   private String bookName; 
   private String publisherName;
   private Integer numberOfPages;
   private Integer stock;
   
   public Book(){}  
   
   public Book(Integer isbn, String bookName, String publisherName, Integer numberOfPages, Integer stock){ 
      this.isbn = isbn;
      this.bookName = bookName;
      this.publisherName = publisherName;
      this.numberOfPages = numberOfPages;
      this.stock = stock;
   }  
    
   public Integer getIsbn() {
      return isbn; 
   }
   
   public void setIsbn(Integer isbn) { 
      this.isbn = isbn; 
   }
   
   public String getBookName() { 
      return bookName; 
   } 
   
   public void setBookName(String bookName) { 
      this.bookName = bookName; 
   } 
   
   public String getPublisherName() { 
      return publisherName; 
   } 
   
   public void setPublisherName(String publisherName) { 
      this.publisherName = publisherName; 
   }
   
   public Integer getNumberOfPages() {
	   return numberOfPages; 
   }
	   
   public void setNumberOfPages(Integer numberOfPages) { 
      this.numberOfPages = numberOfPages; 
   }
   
   public Integer getStock() {
	   return stock;
   }
	   
   public void setStock(Integer stock) { 
      this.stock = stock; 
   }
   
   public String toString() {
	   return "Book : " + this.getBookName() + ", " + this.getIsbn() + ", " + this.getNumberOfPages() + ", " + this.getPublisherName() + ", " + this.getStock();
   }
} 
