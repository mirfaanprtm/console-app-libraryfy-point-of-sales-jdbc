package org.example.models.mappers;

import org.example.models.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<Users> {

    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users users = new Users();
        users.setId(rs.getString("id"));
        users.setFull_name(rs.getString("full_name"));
        users.setPhone_number(rs.getString("phone_number"));

        return users;
    }
}
