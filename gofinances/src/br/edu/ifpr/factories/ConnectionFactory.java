package br.edu.ifpr.factories;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author alunoadm
 */
public class ConnectionFactory {
    public Connection getConnection() throws SQLException {
       return DriverManager.getConnection("jdbc:derby://localhost:1527/gofinances");
    }
}