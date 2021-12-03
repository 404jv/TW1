package br.edu.ifpr.biblioteca.repositories;

import br.edu.ifpr.biblioteca.factories.ConnectionFactory;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import br.edu.ifpr.biblioteca.models.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersRepository extends AbstractTableModel{
    static ArrayList<User> repository = new ArrayList<>();
    String[] columns = { "Nome", "Idade", "Email", "Senha", "Curso"};
    
    public UsersRepository() throws SQLException {
       repository = this.all();
    }

    public ArrayList<User> all() throws SQLException {
        ArrayList<User> retorno = new ArrayList();

        String sql = "SELECT ID, NOME, IDADE, EMAIL, SENHA, CURSO FROM USERS";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        ResultSet result = query.executeQuery();

        while (result.next()) {
            User user = new User();
            user.setId(result.getInt("ID"));
            user.setNome(result.getString("NOME"));
            user.setIdade(result.getInt("IDADE"));
            user.setEmail(result.getString("EMAIL"));
            user.setSenha(result.getString("SENHA"));
            user.setIdade(result.getInt("IDADE"));
            user.setCurso(result.getString("CURSO"));
            retorno.add(user);
        }
        
        query.close();
        connection.close();

        return retorno;
    }

    public void addUser(User user) throws SQLException {
        String sql = "INSERT INTO USERS (NOME, IDADE, EMAIL, SENHA, CURSO)"
                    + "VALUES (?, ?, ?, ?, ?)";

        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        query.setString(1, user.getNome());
        query.setInt(2, user.getIdade());
        query.setString(3, user.getEmail());
        query.setString(4, user.getSenha());
        query.setString(5, user.getCurso());
        query.execute();
        query.close();

        repository.add(user);
        this.fireTableDataChanged();

        System.out.printf("✅ Usuário %s, criado com sucesso!", user.getNome());

        connection.close();
    }

    public User getUserByIndex(Integer index) {
        return this.repository.get(index);
    }

    public void alterUser(User user, String nome, Integer idade, String email, String senha, String curso) throws SQLException {
        String sql = "UPDATE USERS SET NOME = ?, IDADE = ?, EMAIL = ?, SENHA = ?, CURSO = ?"
                + "WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setString(1, nome);
        query.setInt(2, idade);
        query.setString(3, email);
        query.setString(4, senha);
        query.setString(5, curso);
        query.setInt(6, user.getId());
        query.execute();
        query.close();
        
        user.setNome(nome);
        user.setIdade(idade);
        user.setEmail(email);
        user.setSenha(senha);
        user.setCurso(curso);

        this.fireTableDataChanged();

        connection.close(); 
    }

    public void removeUser(User user) throws SQLException {
        String sql = "DELETE FROM USERS WHERE ID = ?";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);
        
        query.setInt(1, user.getId());
        query.execute();
        query.close();
        
        repository.remove(user);
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
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return repository.get(rowIndex).getNome();
            case 1:
                return repository.get(rowIndex).getIdade();
            case 2:
                return repository.get(rowIndex).getEmail();
            case 3:
                return repository.get(rowIndex).getSenha();
            case 4:
                return repository.get(rowIndex).getCurso();
            default:
                break;
        }
        return null;
    }
    
}


