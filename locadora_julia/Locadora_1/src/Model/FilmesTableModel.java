/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Bean.Filme;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Ana Julia
 */
public class FilmesTableModel extends AbstractTableModel {
protected String[] colunas = {"Filmes:"};
protected ArrayList<Filme> dados = new ArrayList();


    @Override
    public int getRowCount() {
        return dados.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        switch(coluna){
            case 0:
                return dados.get(linha).getNome();
            default:
                return null;
        }
        
    }
@Override
    public String getColumnName(int index){
        return colunas[index];
    }
   
    public void criaFilmes(){
        Filme f1 = new Filme(1,"Alien vs Predador",false);
        Filme f2 = new Filme(2,"Pi",false);
        Filme f3 = new Filme(3,"A volta dos que não foram",false);
        Filme f4 = new Filme(4,"A incrível história de Adrian Kaiky",false);
        Filme f5 = new Filme(5,"Malu e Ana",false);
        dados.add(f1);
        dados.add(f2);
        dados.add(f3);
        dados.add(f4);
        dados.add(f5);
        
    }
    public Filme buscaFilme(String nome){
        for(int x =0;x<dados.size();x++){
            if(dados.get(x).equals(nome)){
                return dados.get(x);
            }
        }
    return null;
    }
}
