package br.edu.ifpr.DAOs;

import br.edu.ifpr.entities.Category;
import br.edu.ifpr.factories.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author joao
 */
public class CategoryDAO {

    public ArrayList<Category> list() throws SQLException {
        String sql = "SELECT ID, NAME FROM CATEGORIES";
        
        Connection connection = new ConnectionFactory().getConnection();

        PreparedStatement query = connection.prepareStatement(sql);

        ResultSet result = query.executeQuery();

        ArrayList<Category> categories = new ArrayList();

        while(result.next()) {
            Category category = new Category();
            category.setId(result.getInt("ID"));
            category.setName(result.getString("NAME"));
         
            categories.add(category);
        }

        query.close();
        connection.close();

        return categories;
    }

    public void seed() throws SQLException {
        String[] categories = { "Saúde", "Alimentação", "Estudos", "Compras", "Salário", "Carro", "Lazer", "Outro" };
        
        Connection connection = new ConnectionFactory().getConnection();
        
        for (String category: categories) {
            String sql = "INSERT INTO CATEGORIES (NAME) VALUES (?)";

            PreparedStatement query = connection.prepareStatement(sql);
            query.setString(1, category);

            query.execute();
            query.close();
        }
        
        connection.close();
    }

    public Category findByName(String name) throws SQLException {
        String sql = "SELECT * FROM CATEGORIES WHERE NAME = ?";
        
        Connection connection = new ConnectionFactory().getConnection();
        
        PreparedStatement stmt = connection.prepareStatement(sql);
        
        stmt.setString(1, name);
        
        ResultSet result = stmt.executeQuery();
        
        Category category = null;

        if (result.next()) {
            category = new Category();
            category.setId(result.getInt("ID"));
            category.setName(result.getString("NAME"));
        }
        
        return category;
    }
}
