package io.github.aurelienpillevesse.dao;

import java.sql.Connection;

public abstract class DAO<T> {
  protected Connection connect = null;
   
  public DAO(Connection conn){
    this.connect = conn;
  }
   
  /**
  * Create object
  * @param object
  * @return boolean 
  */
  public abstract boolean create(T object);

  /**
  * Delete object
  * @param object
  * @return boolean 
  */
  public abstract boolean delete(T object);

  /**
  * Update object
  * @param object
  * @return boolean
  */
  public abstract boolean update(T object);

  /**
  * Search by isbn
  * @param isbn
  * @return T
  */
  public abstract T find(int isbn);
}