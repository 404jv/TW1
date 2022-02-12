/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.DAOs;

import br.edu.ifpr.factories.ConnectionFactory;
import br.edu.ifpr.entities.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class TransactionDAO {
    public ArrayList<Transaction> selectByUserId(int user_id) throws SQLException {
        String sql = "SELECT * FROM TRANSACTIONS "
            + "JOIN CATEGORIES ON CATEGORIES.ID = TRANSACTIONS.CATEGORY_ID WHERE USER_ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setInt(1, user_id);

        ResultSet result = query.executeQuery();

        ArrayList<Transaction> transactions = new ArrayList();

        while(result.next()) {
            Transaction transaction = new Transaction();
            transaction.setId(result.getInt("ID"));
            transaction.setTitle(result.getString("TITLE"));
            transaction.setPrice(result.getFloat("PRICE"));
            transaction.setDate(result.getDate("DATE"));
            transaction.setType(result.getString("TYPE"));
            transaction.setCategory_name(result.getString("NAME"));

            transactions.add(transaction);
        }

        query.close();
        connection.close();

        return transactions;
    }

    public void insert(Transaction transaction) throws SQLException {
        String sql = "INSERT INTO TRANSACTIONS (TITLE, PRICE, DATE, TYPE, CATEGORY_ID, USER_ID) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, transaction.getTitle());
        stmt.setFloat(2, transaction.getPrice());
        stmt.setObject(3, transaction.getDate());
        stmt.setString(4, transaction.getType());
        stmt.setInt(5, transaction.getCategory_id());
        stmt.setInt(6, transaction.getUser_id());

        stmt.execute();
        stmt.close();
        connection.close();
    }

    public float[] selectSumByUser(int user_id) throws SQLException {
        float[] sum = { 0, 0 };

        String sqlIncome = "SELECT SUM(price) FROM TRANSACTIONS WHERE USER_ID = ? AND TYPE = 'Entrada'";
        String sqlOutcome = "SELECT SUM(price) FROM TRANSACTIONS WHERE USER_ID = ? AND TYPE = 'Saida'";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sqlIncome);

        query.setInt(1, user_id);

        ResultSet result = query.executeQuery();


        if (result.next()) {
           sum[0] = result.getFloat(1);
        }

        query = connection.prepareStatement(sqlOutcome);

        query.setInt(1, user_id);

        result = query.executeQuery();

        if (result.next()) {
           sum[1] = result.getFloat(1);
        }

        return sum;
    }
}
