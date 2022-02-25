/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.DAOs;

import br.edu.ifpr.Entities.Aluguel;
import br.edu.ifpr.Factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ana
 */
public class AlugueisDAO {
    public void criar(Aluguel aluguel) throws SQLException {
        String sql = "INSERT INTO ALUGUEIS (CLIENTE_ID, FILME_ID) VALUES (?, ?)";

        Connection conexao = new ConnectionFactory().getConnection();
        
        PreparedStatement smt = conexao.prepareStatement(sql);

        smt.setInt(1, aluguel.getCliente_id());
        smt.setInt(2, aluguel.getFilme_id());

        smt.execute();
        smt.close();
        conexao.close();
    }

    public ArrayList<Aluguel> listar() throws SQLException {
        ArrayList<Aluguel> alugueis = new ArrayList();

        String sql = "SELECT * FROM ALUGUEIS JOIN CLIENTES ON CLIENTES.ID = ALUGUEIS.CLIENTE_ID "
            + "JOIN FILMES ON FILMES.ID = ALUGUEIS.FILME_ID";
        
        Connection conexao = new ConnectionFactory().getConnection();
        
        PreparedStatement smt = conexao.prepareStatement(sql);
        
        ResultSet result = smt.executeQuery();
        
        while(result.next()) {
            Aluguel aluguel = new Aluguel();
            aluguel.setId(result.getInt("ID"));
            aluguel.setCliente_id(result.getInt("CLIENTE_ID"));
            aluguel.setFilme_id(result.getInt("FILME_ID"));
            aluguel.setData_entrega(result.getString("DATA_ENTREGA"));
            aluguel.setStatus(result.getString("STATUS"));
            aluguel.setTotal(result.getFloat("TOTAL"));

            aluguel.setCliente_nome(result.getString("NOME"));
            aluguel.setFilme_title(result.getString("TITULO"));
            aluguel.setAluguel(result.getFloat("ALUGUEL"));

            alugueis.add(aluguel);
        }
        
        smt.close();
        conexao.close();
        
        return alugueis;
    }

    public Aluguel procurarPorId(String id) throws SQLException {
        String sql = "SELECT * FROM ALUGUEIS JOIN CLIENTES ON CLIENTES.ID = ALUGUEIS.CLIENTE_ID "
            + "JOIN FILMES ON FILMES.ID = ALUGUEIS.FILME_ID WHERE ALUGUEIS.ID = ?";

        Connection conexao = new ConnectionFactory().getConnection();

        PreparedStatement smt = conexao.prepareStatement(sql);
        
        smt.setString(1, id);

        ResultSet result = smt.executeQuery();

        Aluguel aluguel = null;

        while(result.next()) {
            aluguel = new Aluguel();
            aluguel.setId(result.getInt("ID"));
            aluguel.setCliente_id(result.getInt("CLIENTE_ID"));
            aluguel.setFilme_id(result.getInt("FILME_ID"));
            aluguel.setData_entrega(result.getString("DATA_ENTREGA"));
            aluguel.setStatus(result.getString("STATUS"));
            aluguel.setTotal(result.getFloat("TOTAL"));

            aluguel.setCliente_nome(result.getString("NOME"));
            aluguel.setFilme_title(result.getString("TITULO"));
            aluguel.setAluguel(result.getFloat("ALUGUEL"));
        }

        smt.close();
        conexao.close();
        return aluguel;
    }

    public void atualizar(Aluguel aluguel) throws SQLException {
        String sql = "UPDATE ALUGUEIS SET TOTAL = ?, DATA_ENTREGA = ?, STATUS = ? WHERE ID = ?";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setFloat(1, aluguel.getTotal());
        query.setString(2, aluguel.getData_entrega());
        query.setString(3, aluguel.getStatus());
        query.setInt(4, aluguel.getId());

        query.execute();
        query.close();
        connection.close();
    }
}
