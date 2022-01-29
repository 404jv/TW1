/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.messages.DAOs;

import br.edu.ifpr.messages.entities.User;
import br.edu.ifpr.messages.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class UserDAO {
    public void inserir(User u) throws SQLException {
        String sql = "INSERT INTO USUARIO (USERNAME, SENHA, NOME) VALUES (?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, u.getUsername());
        stmt.setString(2, u.getSenha());
        stmt.setString(3, u.getNome());
        
        stmt.execute();
        
        stmt.close();
        connection.close();
    }
    
    public ArrayList<User> selecionarTodos(int user_id) throws SQLException {
        ArrayList<User> retorno = new ArrayList();
        
        String sql = "SELECT ID, USERNAME, SENHA, NOME FROM USUARIO WHERE ID <> ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
 
        stmt.setInt(1, user_id);

        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            User u = new User();
            u.setId(rs.getInt("ID"));
            u.setUsername(rs.getString("USERNAME"));
            u.setSenha(rs.getString("SENHA"));
            u.setNome(rs.getString("NOME"));
            retorno.add(u);
        }
        
        stmt.close();
        connection.close();
        
        return retorno;
    }
    
    public User autenticar(String username, String senha) throws SQLException {
        User u = null;
        
        String sql = "SELECT ID, USERNAME, SENHA, NOME FROM USUARIO WHERE USERNAME = ? AND SENHA = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, username);
        stmt.setString(2, senha);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            u = new User();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setUsername(rs.getString("USERNAME"));
        }
        
        return u;
    }
    
    public User selecionarPorId(int id) throws SQLException {
        User u = null;
        
        String sql = "SELECT ID, USERNAME, SENHA, NOME FROM USUARIO WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setInt(1, id);
        
        ResultSet rs = stmt.executeQuery();
        
        while(rs.next()) {
            u = new User();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setUsername(rs.getString("USERNAME"));
        }
        
        return u;
    }
}
