/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpr.messages.models;

import br.edu.ifpr.messages.DAOs.MessageDAO;
import br.edu.ifpr.messages.DAOs.UserDAO;
import br.edu.ifpr.messages.entities.Message;
import br.edu.ifpr.messages.entities.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joao
 */
public class SendedMessages extends AbstractTableModel {

    ArrayList<Message> mensagensEnviadas = new ArrayList();
    String[] colunas = {"Destinatario", "Corpo"};
    
    public void carregarEnviadas(int id_remetente) throws SQLException {
        MessageDAO dao = new MessageDAO();
        this.mensagensEnviadas = dao.selecionarEnviadas(id_remetente);
        this.fireTableDataChanged();
    }
    
    public String retornarNome(int id_destinatario) throws SQLException {
        UserDAO dao = new UserDAO();
        User u = dao.selecionarPorId(id_destinatario);
        
        return u.getNome();
    }

    @Override
    public int getRowCount() {
        if(this.mensagensEnviadas == null) return 0;
        return this.mensagensEnviadas.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return colunas[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
        {
            try {
                return this.retornarNome(mensagensEnviadas.get(rowIndex).getId_destinatario());
            } catch (SQLException ex) {
                Logger.getLogger(ReceivedMessages.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 1:
                return mensagensEnviadas.get(rowIndex).getCorpo();
            default:
                break;
        }
        return null;
    }
}
