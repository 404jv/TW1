package br.edu.ifpr.DAOs;

import br.edu.ifpr.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.edu.ifpr.entities.User;
import java.sql.ResultSet;

/**
 *
 * @author alunoadm
 */
public class UserDAO {
    public void insert(User user) throws SQLException {
        String sql = "INSERT INTO USERS (NAME, PASSWORD) VALUES (?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, user.getName());
        stmt.setString(2, user.getPassword());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }

    public User auth(String name, String password) throws SQLException {
        String sql = "SELECT ID, NAME, PASSWORD FROM USERS WHERE NAME = ? AND PASSWORD = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, name);
        stmt.setString(2, password);
        
        ResultSet rs = stmt.executeQuery();
        
        User user = null;

        if (rs.next()) {
            user = new User();
            user.setId(rs.getInt("ID"));
            user.setName(rs.getString("NAME"));
            user.setPassword(rs.getString("PASSWORD"));
        }
        
        return user;
    }
}
