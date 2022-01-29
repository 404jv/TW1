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

    public Object[] list() throws SQLException {
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

        return categories.toArray();
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
}
