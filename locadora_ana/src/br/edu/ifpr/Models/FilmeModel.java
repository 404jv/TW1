/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.ifpr.Models;

import br.edu.ifpr.Entities.Filme;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author ana
 */
public class FilmeModel extends AbstractTableModel {
    ArrayList<Filme> filmes = new ArrayList();
    String[] colunas = { "ID", "Titulo", "Aluguel" };

    // public ArrayList<Movie> getMovies() {

    // }
    
    public void create(Filme filme) {

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
