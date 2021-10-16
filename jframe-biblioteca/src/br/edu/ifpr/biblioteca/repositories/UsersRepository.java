package br.edu.ifpr.biblioteca.repositories;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import br.edu.ifpr.biblioteca.models.User;

public class UsersRepository extends AbstractTableModel{
    ArrayList<User> repository = new ArrayList<>();
    String[] columns = { "Nome", "Idade", "Email", "Senha", "Curso"};
    
    public void addUser(User user){
        repository.add(user);
        this.fireTableDataChanged();
    }

    public User getUserByIndex(Integer index) {
        return this.repository.get(index);
    }

    public void alterUser(User user, String nome, Integer idade, String email, String senha, String curso) {
        System.out.println(this.repository.get(0).getNome() + " " + nome);
        
        user.setNome(nome);
        user.setIdade(idade);
        user.setEmail(email);
        user.setSenha(senha);
        user.setCurso(curso);    

        System.out.println(this.repository.get(0).getNome());
    }

    public void removeUser(User user) {
        this.repository.remove(user);
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


