package org.example.models.mappers;

import org.example.models.Categories;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<Categories> {
    @Override
    public Categories mapRow(ResultSet rs, int rowNum) throws SQLException {
        Categories categories = new Categories();
        categories.setId(rs.getString("id"));
        categories.setCategory_name(rs.getString("category_name"));
        return categories;
    }
}
