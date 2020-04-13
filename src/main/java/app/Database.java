package app;

import java.io.Closeable;
import java.io.IOException;
import java.sql.*;

/**
 * Database connection managing class
 */
public class Database implements Closeable {
    private static Database db;
    private Connection conn;
    private String url;
    private String username;
    private String  password;

    private Database(String url, String username, String  password){
        this.url = url;
        this.username = username;
        this.password = password;
    }

    /**
     * Registers the current connection to the db and Instantiates the Database singleton
     * @param url database adress
     * @param username .
     * @param password .
     */
    public static void setInstance(String url, String username, String  password){
        Database.db = new Database(url, username, password);
    }

    /**
     * Instantiates the Connection to the database on the first call, returns the current active Database
     * @return
     * @throws SQLException
     */
    public static Database getInstance() throws SQLException {
        if (Database.db == null)
            throw new SQLException();
        if (Database.db.conn == null){
            Database.db.conn = DriverManager.getConnection(Database.db.url, Database.db.username, Database.db.password);
            //Database.db.conn.setAutoCommit(false);
        }
        return Database.db;
    }

    public Connection getConn() {
        return conn;
    }

    /**
     * Useful for auto-closing the connection
     * Also needed for rollback, we could not rollback after each individual statement so we rollback on close
     */
    @Override
    public void close() throws IOException {
        if (Database.db != null){
            try {
                //Database.db.conn.rollback();
                Database.db.conn.close();
                Database.db = null;
            } catch (SQLException e) {
                throw new IOException(e.getMessage());
            }
        }
    }
}