/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

public class Book {

   private String isbn;
   private String bookName; 
   private String publisherName;
   private int stock;
   
   public Book(){}  
   
   public Book(String isbn, String bookName, String publisherName, int stock){ 
      this.isbn = isbn;
      this.bookName = bookName;
      this.publisherName = publisherName;
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
   
   public int getStock() {
	   return stock;
   }
	   
   public void setStock(int stock) { 
      this.stock = stock; 
   }
   
   public String toString() {
	   return "Book : " + this.getBookName() + ", " + this.getPublisherName() + ", " + this.getStock();
   }
} 
