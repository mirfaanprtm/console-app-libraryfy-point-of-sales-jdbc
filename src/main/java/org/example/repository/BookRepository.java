package org.example.repository;

import org.example.models.Books;
import org.example.models.mappers.BookMapper;
import org.example.utils.IRandomStringGenerator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class BookRepository implements ILibraryRepository<Books> {
    private JdbcTemplate jdbcTemplate;
    private IRandomStringGenerator randomStringGenerator;

    public BookRepository(DataSource dataSource, IRandomStringGenerator randomStringGenerator) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.randomStringGenerator = randomStringGenerator;
    }

    @Override
    public Books create(Books books) throws Exception {
        try {
            books.setId(randomStringGenerator.random());
            int result = jdbcTemplate.update("insert into books values(?,?,?,?,?,?)", books.getId(), books.getTitle(), books.getPublication_year(), books.getAuthor(), books.getPublisher(), books.getCategory_id());
            if(result <= 0){
                throw new Exception("Failed to insert books");
            }
            return books;
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Books> findAll() throws Exception {
        try {
            return jdbcTemplate.query("select * from books", new BookMapper());
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Books> findById(String id) throws Exception {
        try {
            return jdbcTemplate.query("select * from books where id=?", new BookMapper(), id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            jdbcTemplate.update("delete from books where id = ?", id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Books books, String id) throws Exception {
        try {
            jdbcTemplate.update("update books set title = ?, publication_year = ?, author = ?, publisher = ?, category_id = ?  where id = ?",
                    books.getTitle(), books.getPublication_year(), books.getAuthor(), books.getPublisher(), books.getCategory_id(), id);
        } catch (DataAccessException e){
            throw new Exception("Failed to update");
        }
    }
}
