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
public class ReceivedMessages extends AbstractTableModel {
    
    ArrayList<Message> mensagensRecebidas = new ArrayList();
    String[] colunas = {"Remetente", "Corpo"};
    
    public void carregarRecebidas(int id_destinatario) throws SQLException {
        MessageDAO dao = new MessageDAO();
        this.mensagensRecebidas = dao.selecionarRecebidas(id_destinatario);
        this.fireTableDataChanged();
    }
    
    public String retornarNome(int id_remetente) throws SQLException {
        UserDAO dao = new UserDAO();
        User u = dao.selecionarPorId(id_remetente);
        
        return u.getNome();
    }

    @Override
    public int getRowCount() {
        if(this.mensagensRecebidas == null) return 0;
        return this.mensagensRecebidas.size();
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
                return this.retornarNome(mensagensRecebidas.get(rowIndex).getId_remetente());
            } catch (SQLException ex) {
                Logger.getLogger(ReceivedMessages.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            case 1:
                return mensagensRecebidas.get(rowIndex).getCorpo();
            default:
                break;
        }
        return null;
    }
    
}
