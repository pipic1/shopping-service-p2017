/**
 * @author Aurelio
 *
 */
package io.github.aurelienpillevesse.model;

public class CustomResponse {

   private Object obj;
   private String message;
   
   public CustomResponse(){}  
   
   public CustomResponse(Object obj, String message){ 
      this.obj = obj;
      this.message = message;
   }  

   public String getObj() {
      return obj; 
   }
   
   public void setObj(Object obj) { 
      this.obj = obj; 
   }
   
   public String getMessage() { 
      return message; 
   } 
   
   public void setMessage(String message) { 
      this.message = message; 
   } 
   
   public String toString() {
      return "CustomResponse : " + this.getObj() + ", " + this.getMessage();
   }
} 
