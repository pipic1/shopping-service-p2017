/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

public class Book {

   private String isbn;
   private String bookName; 
   private String publisherName;
   private int numberOfPages;
   private int stock;
   
   public Book(){}  
   
   public Book(String isbn, String bookName, String publisherName, int numberOfPages, int stock){ 
      this.isbn = isbn;
      this.bookName = bookName;
      this.publisherName = publisherName;
      this.numberOfPages = numberOfPages;
      this.stock = stock;
   }  
    
   public String getIsbn() {
      return isbn; 
   }
   
   public void setIsbn(String isbn) { 
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
   
   public int getNumberOfPages() {
	   return numberOfPages; 
   }
	   
   public void setNumberOfPages(int numberOfPages) { 
      this.numberOfPages = numberOfPages; 
   }
   
   public int getStock() {
	   return stock;
   }
	   
   public void setStock(int stock) { 
      this.stock = stock; 
   }
   
   public String toString() {
	   return "Book : " + this.getBookName() + ", " + this.getIsbn() + ", " + this.getNumberOfPages() + ", " + this.getPublisherName() + ", " + this.getStock();
   }
} 
