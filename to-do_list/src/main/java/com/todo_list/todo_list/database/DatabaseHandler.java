package com.todo_list.todo_list.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseHandler extends Configs {
    Connection dbConnection;

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "idbc:mysql://"+ dbHost + ":"
                + dbPort + "/"
                + dbName;

        Class.forName("com")
    }
}
