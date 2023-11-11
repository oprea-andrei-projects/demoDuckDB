package com.example.DataInterview.duckDbConn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DuckDBConnector {

    private static final String JDBC_URL = "jdbc:duckdb:C:\\WebDevelopment\\db\\myDB";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection connection) throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }





}
