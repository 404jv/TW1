/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.messages.DAOs;

import br.edu.ifpr.messages.entities.Message;
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
public class MessageDAO {
    public void inserir(Message m) throws SQLException {
        String sql = "INSERT INTO MENSAGEM (CORPO, ID_REMETENTE, ID_DESTINATARIO) VALUES (?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setString(1, m.getCorpo());
        query.setInt(2, m.getId_remetente());
        query.setInt(3, m.getId_destinatario());
        
        query.execute();
        
        query.close();
        connection.close();
    }
    
    public ArrayList<Message> selecionarTodos() throws SQLException {
        ArrayList<Message> users = new ArrayList();
        
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO FROM MENSAGEM";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        ResultSet result = query.executeQuery();
        
        while(result.next()) {
            Message m = new Message();
            m.setId(result.getInt("ID"));
            m.setCorpo(result.getString("CORPO"));
            m.setId_remetente(result.getInt("ID_REMETENTE"));
            m.setId_destinatario(result.getInt("ID_DESTINATARIO"));
            users.add(m);
        }
        
        query.close();
        connection.close();
        
        return users;
    }
    
    public ArrayList<Message> selecionarRecebidas(int id_destinatario) throws SQLException {
        ArrayList<Message> messages = new ArrayList();
        
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO FROM MENSAGEM WHERE ID_DESTINATARIO = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setInt(1, id_destinatario);
        
        ResultSet result = query.executeQuery();
        
        while(result.next()) {
            Message m = new Message();
            m.setId(result.getInt("ID"));
            m.setCorpo(result.getString("CORPO"));
            m.setId_remetente(result.getInt("ID_REMETENTE"));
            m.setId_destinatario(result.getInt("ID_DESTINATARIO"));
            messages.add(m);
        }
        
        query.close();
        connection.close();
        
        return messages;
    }
    
    public ArrayList<Message> selecionarEnviadas(int id_remetente) throws SQLException {
        ArrayList<Message> messages = new ArrayList();
        
        String sql = "SELECT ID, CORPO, ID_REMETENTE, ID_DESTINATARIO FROM MENSAGEM WHERE ID_REMETENTE = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setInt(1, id_remetente);
        
        ResultSet rs = query.executeQuery();
        
        while(rs.next()) {
            Message m = new Message();
            m.setId(rs.getInt("ID"));
            m.setCorpo(rs.getString("CORPO"));
            m.setId_remetente(rs.getInt("ID_REMETENTE"));
            m.setId_destinatario(rs.getInt("ID_DESTINATARIO"));
            messages.add(m);
        }
        
        query.close();
        connection.close();
        
        return messages;
    }
}
