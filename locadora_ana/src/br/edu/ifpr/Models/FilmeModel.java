/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.Models;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import br.edu.ifpr.Entities.Filme;
import br.edu.ifpr.DAOs.FilmesDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ana
 */
public class FilmeModel extends AbstractTableModel {
    ArrayList<Filme> filmes = new ArrayList();
    String[] colunas = { "ID", "Titulo", "Aluguel" };

    public FilmeModel() {
        FilmesDAO filmesDAO = new FilmesDAO();

        try {
            this.filmes = filmesDAO.listar();
        } catch (SQLException e) {
            Logger.getLogger(FilmeModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public void create(Filme filme) {
       FilmesDAO filmesDAO = new FilmesDAO();

        try {
            filmesDAO.criar(filme);
        } catch (SQLException e) {
            Logger.getLogger(FilmeModel.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    @Override
    public int getRowCount() {
        if (this.filmes == null) return 0;
        return this.filmes.size();
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
                return this.filmes.get(rowIndex).getId();
            case 1:
                return this.filmes.get(rowIndex).getTitulo();
            case 2:
                return this.filmes.get(rowIndex).getAluguel();
        }
        return null;
    }
}
