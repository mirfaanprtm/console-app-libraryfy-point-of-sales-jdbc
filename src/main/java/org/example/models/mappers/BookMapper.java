package org.example.models.mappers;

import org.example.models.Books;
import org.example.models.Categories;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookMapper implements RowMapper<Books> {

    @Override
    public Books mapRow(ResultSet rs, int rowNum) throws SQLException {
        Books books = new Books();
        books.setId(rs.getString("id"));
        books.setAuthor(rs.getString("author"));
        books.setTitle(rs.getString("title"));
        books.setPublication_year(rs.getInt("publication_year"));
        books.setPublisher(rs.getString("publisher"));
        books.setCategory_id(rs.getString("category_id"));
        return books;
    }
}
