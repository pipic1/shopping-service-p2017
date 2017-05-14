/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

public class CustomResponse {

   private Book data;
   private String message;
   
   public CustomResponse(){}  
   
   public CustomResponse(Book data, String message){ 
      this.data = data;
      this.message = message;
   }  

   public Book getData() {
      return data; 
   }
   
   public void setData(Book data) { 
      this.data = data; 
   }
   
   public String getMessage() { 
      return message; 
   } 
   
   public void setMessage(String message) { 
      this.message = message; 
   } 
   
   public String toString() {
      return "CustomResponse : " + this.getData() + ", " + this.getMessage();
   }
} 
