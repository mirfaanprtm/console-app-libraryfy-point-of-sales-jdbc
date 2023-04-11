package org.example.repository;

import org.example.models.Categories;
import org.example.models.mappers.CategoryMapper;
import org.example.utils.IRandomStringGenerator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class CategoriesRepository implements ILibraryRepository<Categories>{
    private JdbcTemplate jdbcTemplate;
    private IRandomStringGenerator randomStringGenerator;

    public CategoriesRepository(DataSource dataSource, IRandomStringGenerator randomStringGenerator) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.randomStringGenerator = randomStringGenerator;
    }

    @Override
    public Categories create(Categories categories) throws Exception {
        try {
            categories.setId(randomStringGenerator.random());
            int result = jdbcTemplate.update("insert into categories values(?,?)", categories.getId(), categories.getCategory_name());
            if(result <= 0){
                throw new Exception("Failed to insert categories");
            }
            return categories;
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Categories> findAll() throws Exception {
        try {
            return jdbcTemplate.query("select * from categories", new CategoryMapper());
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Categories> findById(String id) throws Exception {
        try {
            return jdbcTemplate.query("select * from categories where id=?", new CategoryMapper(), id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            jdbcTemplate.update("delete from categories where id = ?", id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Categories categories, String id) throws Exception {
        try {
            jdbcTemplate.update("update categories set category_name = ? where id = ?", categories.getCategory_name(), id);
        } catch (DataAccessException e){
            throw new Exception("Failed to update");
        }
    }
}
