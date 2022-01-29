/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.app.DAOs;

import br.edu.ifpr.app.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import br.edu.ifpr.app.entities.User;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class UserDAO {
    public void create(User user) throws SQLException {
        String sql = "INSERT INTO Usuario (NOME, SENHA, USERNAME) "
                + "VALUES (?, ?, ?)";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, user.getName());
        query.setString(2, user.getPassword());
        query.setString(3, user.getUsername());

        query.execute();
        query.close();
        connection.close();
    }

    public User login(String username, String password) throws SQLException {
        String sql = "SELECT * FROM USUARIO WHERE USERNAME = ? AND SENHA = ?";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, username);
        query.setString(2, password);

        ResultSet result = query.executeQuery();

        if (result.next() == false) {
            return null; 
        }

        User userExists = new User();

        userExists.setId(result.getInt("ID"));
        userExists.setName(result.getString("NOME"));
        userExists.setPassword(result.getString("SENHA"));
        userExists.setUsername(result.getString("USERNAME"));

        query.close();
        connection.close();
       
        return userExists;
    }

    public ArrayList<User> selectAllContatcts() throws SQLException {
        ArrayList<User> contatcts = new ArrayList();

        String sql = "SELECT * FROM USUARIO";
     
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        //query.setInt(1, user_id);

        ResultSet result = query.executeQuery();

        while(result.next()) {
            User user = new User();
            user.setId(result.getInt("ID"));
            user.setName(result.getString("NOME"));
            user.setPassword(result.getString("SENHA"));
            user.setUsername(result.getString("USERNAME"));
            contatcts.add(user);
        }

        query.close();
        connection.close();

        return contatcts;
    }
}
