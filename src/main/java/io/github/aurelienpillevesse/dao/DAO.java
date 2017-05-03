package io.github.aurelienpillevesse.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class DAO<T> {
    protected Connection connect = null;
    protected ResultSet rs = null;
	protected PreparedStatement st = null;

    public DAO(){
        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        try {
			this.connect = DriverManager.getConnection(dbUrl);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
    public abstract T find(String isbn);
}
