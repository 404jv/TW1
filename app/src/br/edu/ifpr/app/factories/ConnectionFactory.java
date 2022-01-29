package br.edu.ifpr.app.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:derby://localhost:1527/messages_db");
    }
}
