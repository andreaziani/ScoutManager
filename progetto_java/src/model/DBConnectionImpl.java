package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * Implementation of DBConnection.
 *
 */
public class DBConnectionImpl implements DBConnection {
    private String dbName = "SCOUT"; 
 
    public Connection getMsSQLConnection()  {
        	String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        	String dbUri = "jdbc:sqlserver://DESKTOP-CBBL63Q;databaseName="+dbName;
        	
        	String userName = "sa";
        	String password = "andrea1997";
             
            Connection connection = null;
             try {
                 Class.forName(driver);
                 connection = DriverManager.getConnection(dbUri, userName, password);
             }
             catch (ClassNotFoundException e) {
                 new Exception(e.getMessage());
                 System.out.println("ErroreCNF"+ e.getMessage());
             }
             catch(SQLException e) {
                 new Exception(e.getMessage());
                 System.out.println("ErroreSQL"+ e.getMessage());
             }
             return connection;
         }
}
