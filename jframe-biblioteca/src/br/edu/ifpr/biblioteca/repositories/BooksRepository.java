package br.edu.ifpr.biblioteca.repositories;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import br.edu.ifpr.biblioteca.models.Book;

public class BooksRepository extends AbstractTableModel {
    ArrayList<Book> repository = new ArrayList<>();
    String[] columns = { "Titulo", "Autor", "Editora", "Páginas", "Ano de Publicação", "Gênero" };
    
    public void addBook(Book book){
        repository.add(book);
        this.fireTableDataChanged();
    }
    
    @Override
    public int getRowCount() {
        return repository.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }
    
    @Override
    public String getColumnName(int column){
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return repository.get(rowIndex).getTitulo();
            case 1:
                return repository.get(rowIndex).getAutor();
            case 2:
                return repository.get(rowIndex).getEditora();
            case 3:
                return repository.get(rowIndex).getPaginas();
            case 4:
                return repository.get(rowIndex).getAnoPubli();
            case 5:
                return repository.get(rowIndex).getGenero();
            default:
                break;
            }
        return null;
    }
}
