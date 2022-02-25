/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.DAOs;

import br.edu.ifpr.Entities.Cliente;
import br.edu.ifpr.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ana
 */
public class ClientesDAO {
    public void criar(Cliente cliente) throws SQLException {
        String sql = "INSERT INTO CLIENTES (NOME, ENDERECO, NUMERO_CELULAR, CPF) "
            + "VALUES (?, ?, ?, ?)";

        Connection conexao = new ConnectionFactory().getConnection();
        
        PreparedStatement smt = conexao.prepareStatement(sql);

        smt.setString(1, cliente.getNome());
        smt.setString(2, cliente.getEndereco());
        smt.setString(3, cliente.getNumero_celular());
        smt.setString(4, cliente.getCpf());

        smt.execute();
        smt.close();
        conexao.close();
    }

    public Cliente procurarPorCpf(String cpf) throws SQLException {
        String sql = "SELECT * FROM CLIENTES WHERE CPF = ?";

        Connection conexao = new ConnectionFactory().getConnection();

        PreparedStatement smt = conexao.prepareStatement(sql);
        
        smt.setString(1, cpf);

        ResultSet result = smt.executeQuery();

        Cliente cliente = null;

        while(result.next()) {
            cliente = new Cliente();
            cliente.setId(result.getInt("ID"));
            cliente.setCpf(result.getString("CPF"));
            cliente.setNome(result.getString("NOME"));
            cliente.setEndereco(result.getString("ENDERECO"));
            cliente.setNumero_celular(result.getString("NUMERO_CELULAR"));
        }
        
        smt.close();
        conexao.close();

        return cliente;
    }
}
