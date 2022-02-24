/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.edu.ifpr.Entities.Filme;
import br.edu.ifpr.Factories.ConnectionFactory;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class FilmesDAO {
    public void criar(Filme filme) throws SQLException {
        String sql = "INSERT INTO FILMES (TITULO, ALUGUEL) VALUES (?, ?)";

        Connection conexao = new ConnectionFactory().getConnection();
        
        PreparedStatement smt = conexao.prepareStatement(sql);

        smt.setString(1, filme.getTitulo());
        smt.setFloat(2, filme.getAluguel());

        smt.execute();
        smt.close();
        conexao.close();
    }

    public ArrayList<Filme> listar() throws SQLException {
        ArrayList<Filme> filmes = new ArrayList();
    
        String sql = "SELECT * FROM FILMES";
        
        Connection conexao = new ConnectionFactory().getConnection();
        
        PreparedStatement smt = conexao.prepareStatement(sql);
        
        ResultSet result = smt.executeQuery();
        
        while(result.next()) {
            Filme filme = new Filme();
            filme.setId(result.getInt("ID"));
            filme.setTitulo(result.getString("TITULO"));
            filme.setAluguel(result.getFloat("ALUGUEL"));

            filmes.add(filme);
        }
        
        smt.close();
        conexao.close();
        
        return filmes;
    }
}
