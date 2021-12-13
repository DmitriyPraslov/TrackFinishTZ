package com.example.trackfinishtz.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionManager {

    private volatile static ConnectionManager instance;
    private Connection connection;

    private ConnectionManager (){
        try {
            InitialContext ctx = new InitialContext();
            DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/companyDB");
            if (ds == null){
                throw new IllegalArgumentException("DataSource not found");
            } else {
                connection = ds.getConnection();
            }
        } catch (NamingException | SQLException e) {
            e.printStackTrace();
        }
    }

    public static ConnectionManager getInstance() {
        ConnectionManager localInstance = instance;
        if (localInstance == null){
            synchronized (ConnectionManager.class){
                localInstance = instance;
                if (localInstance == null){
                    instance = localInstance = new ConnectionManager();
                }
            }
        }
        return localInstance;
    }

    public Connection getConnection() {
        return connection;
    }
}
