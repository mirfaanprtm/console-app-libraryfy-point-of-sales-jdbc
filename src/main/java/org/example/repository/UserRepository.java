package org.example.repository;

import org.example.models.Users;
import org.example.models.mappers.UserMapper;
import org.example.utils.IRandomStringGenerator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserRepository implements ILibraryRepository<Users>{
    private JdbcTemplate jdbcTemplate;
    private IRandomStringGenerator randomStringGenerator;

    public UserRepository(DataSource dataSource, IRandomStringGenerator randomStringGenerator) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.randomStringGenerator = randomStringGenerator;
    }

    @Override
    public Users create(Users users) throws Exception {
        try {
            users.setId(randomStringGenerator.random());
            int result = jdbcTemplate.update("insert into users values(?,?,?)", users.getId(), users.getFull_name(), users.getPhone_number());
            if(result <= 0){
                throw new Exception("Failed to insert users");
            }
            return users;
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Users> findAll() throws Exception {
        try {
            return jdbcTemplate.query("select * from users", new UserMapper());
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Users> findById(String id) throws Exception {
        try {
            return jdbcTemplate.query("select * from users where id=?", new UserMapper(), id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            jdbcTemplate.update("delete from users where id = ?", id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Users users, String id) throws Exception {
        try {
            jdbcTemplate.update("update users set full_name = ?, phone_number = ?  where id = ?", users.getFull_name(), users.getPhone_number(), id);
        } catch (DataAccessException e){
            throw new Exception("Failed to update");
        }
    }


}
