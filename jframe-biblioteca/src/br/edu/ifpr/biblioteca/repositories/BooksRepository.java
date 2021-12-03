package br.edu.ifpr.biblioteca.repositories;

import br.edu.ifpr.biblioteca.factories.ConnectionFactory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import br.edu.ifpr.biblioteca.models.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BooksRepository extends AbstractTableModel {
    static ArrayList<Book> repository = new ArrayList<>();
    String[] columns = { "Titulo", "Autor", "Editora", "Páginas", "Ano de Publicação", "Gênero" };
    
    public BooksRepository() throws SQLException {
       repository = this.all();
    }

    public ArrayList<Book> all() throws SQLException {
        ArrayList<Book> retorno = new ArrayList();

        String sql = "SELECT ID, TITULO, AUTOR, EDITORA, PAGINAS, ANO, GENERO FROM BOOKS";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        ResultSet result = query.executeQuery();

        while (result.next()) {
            Book book = new Book();
            book.setId(result.getInt("ID"));
            book.setTitulo(result.getString("TITULO"));
            book.setAutor(result.getString("AUTOR"));
            book.setEditora(result.getString("EDITORA"));
            book.setPaginas(result.getInt("PAGINAS"));
            book.setAnoPubli(result.getInt("ANO"));
            book.setGenero(result.getString("GENERO"));
            retorno.add(book);
        }
        
        query.close();
        connection.close();

        return retorno;
    }

    public void addBook(Book book) throws SQLException {
       String sql = "INSERT INTO BOOKS (TITULO, AUTOR, EDITORA, PAGINAS, ANO, GENERO)"
                    + "VALUES (?, ?, ?, ?, ?, ?)";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, book.getTitulo());
        query.setString(2, book.getAutor());
        query.setString(3, book.getEditora());
        query.setInt(4, book.getPaginas());
        query.setInt(5, book.getAnoPubli());
        query.setString(6, book.getGenero());
        query.execute();
        query.close();

        connection.close();

        repository.add(book);
        this.fireTableDataChanged();
    }
    
    public Book getBookByIndex(int index) {
        return this.repository.get(index);
    }

    public void alterBook(
        Book book, 
        String titulo, 
        String autor, 
        String editora, 
        int paginas, 
        int anoPubli,
        String genero
    ) throws SQLException {
        String sql = "UPDATE BOOKS SET TITULO = ?, AUTOR = ?, EDITORA = ?, PAGINAS = ?, ANO = ?, GENERO = ?"
            + "WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, titulo);
        query.setString(2, autor);
        query.setString(3, editora);
        query.setInt(4, paginas);
        query.setInt(5, anoPubli);
        query.setString(6, genero);
        query.setInt(7, book.getId());
        query.execute();
        query.close();

        book.setTitulo(titulo);
        book.setAutor(autor);
        book.setEditora(editora);
        book.setPaginas(paginas);
        book.setAnoPubli(anoPubli);
        book.setGenero(genero);

        connection.close();

        this.fireTableDataChanged();
    }

    public void removeBook(Book book) throws SQLException {
        String sql = "DELETE FROM BOOKS WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setInt(1, book.getId());
        query.execute();
        query.close();
        
        repository.remove(book);
        this.fireTableDataChanged();

        connection.close();
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
