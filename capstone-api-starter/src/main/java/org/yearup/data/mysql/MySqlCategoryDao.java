package org.yearup.data.mysql;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.yearup.data.CategoryDao;
import org.yearup.models.Category;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
@Repository
public class MySqlCategoryDao extends MySqlDaoBase implements CategoryDao
{
    public MySqlCategoryDao(DataSource dataSource)
    {
        super(dataSource);
    }

    @Override
    public List<Category> getAllCategories(){
        ArrayList<Category> list = new ArrayList<>();
        Category category = new Category();
        try(Connection connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM categories");
            ResultSet resultSet = statement.executeQuery()){
            while(resultSet.next()){
                category.setCategoryId(resultSet.getInt("category_id"));
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                list.add(category);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public Category getById(int categoryId){
        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT name, description FROM categories WHERE category_id = ?")
        ) {
            statement.setInt(1, categoryId);
            try (ResultSet resultSet = statement.executeQuery()) {
                Category category = new Category();
                category.setCategoryId(categoryId);
                category.setName(resultSet.getString("name"));
                category.setDescription(resultSet.getString("description"));
                return category;

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Category create(Category category)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO categories (name, description) " +
                             "VALUES (?, ?);")
        ) {
            statement.setInt(1, category.getCategoryId());
            statement.setString(2, category.getName());

            statement.executeUpdate();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if(generatedKeys.next()){
                    int id = generatedKeys.getInt(1);
                    category.setCategoryId(id);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return category;
    }

    @Override
    public void update(int categoryId, Category category)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "UPDATE categories SET name = ?, description = ?" +
                             "WHERE category_id = ?")
        ) {
            statement.setString(1, category.getName());
            statement.setString(2, category.getDescription());
            statement.setInt(3, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int categoryId)
    {
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "Delete categories Where category_id = ?;")
        ) {
            statement.setInt(1, categoryId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private Category mapRow(ResultSet row) throws SQLException
    {
        int categoryId = row.getInt("category_id");
        String name = row.getString("name");
        String description = row.getString("description");

        Category category = new Category()
        {{
            setCategoryId(categoryId);
            setName(name);
            setDescription(description);
        }};
        return category;
    }

}
