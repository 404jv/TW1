/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.models;

import br.edu.ifpr.DAOs.CategoryDAO;
import br.edu.ifpr.DAOs.TransactionDAO;
import br.edu.ifpr.entities.Category;
import br.edu.ifpr.entities.Transaction;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author joao
 */
public class TransactionsModel extends AbstractTableModel {
    ArrayList<Transaction> transactions = new ArrayList();
    String[] columns = {"Titulo", "Tipo", "Preço", "Categoria", "Data"};

    public float[] loadData(int user_id) {
        TransactionDAO transacionDAO = new TransactionDAO();

        try {
            this.transactions = transacionDAO.selectByUserId(user_id);
 
            this.fireTableDataChanged();

            float[] sum = transacionDAO.selectSumByUser(user_id);

            return sum;
        } catch (SQLException e) {
            Logger.getLogger(TransactionsModel.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void create(Transaction transaction) {
       CategoryDAO categoryDAO = new CategoryDAO();
       TransactionDAO transactionDAO = new TransactionDAO();

       try {
           Category category = categoryDAO.findByName(transaction.getCategory_name());

           if (category == null) return;

           transaction.setCategory_id(category.getId());

           transactionDAO.insert(transaction);

       } catch (SQLException e) {
            Logger.getLogger(TransactionsModel.class.getName()).log(Level.SEVERE, null, e);
       }
    }

    @Override
    public int getRowCount() {
        if(this.transactions == null) return 0;
        return this.transactions.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.transactions.get(rowIndex).getTitle();
            case 1:
                return this.transactions.get(rowIndex).getType();
            case 2:
                return this.transactions.get(rowIndex).getPrice();
            case 3:
                return this.transactions.get(rowIndex).getCategory_name();
            case 4:
                return this.transactions.get(rowIndex).getDate();
        }
        return null;
    }

}
