package net.greenbudget.db.methods;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import net.greenbudget.Config.DbConfig;

public class DbConnection {
    DbConfig dbConfig = DbConfig.getInstance();

    private final String USER = dbConfig.getUsername();
    private final String PWD = dbConfig.getPwd();
    private final String DRIVER = dbConfig.getDriver();
    private final String URL = dbConfig.getUrl();

    protected Statement stmt;
    protected PreparedStatement pstmt;
    protected Connection conn = null;
    protected ResultSet resultSet;

    public Connection connect(){
        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(URL, USER, PWD);
            System.out.println("db connected");
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        return conn;
    }

   
}
