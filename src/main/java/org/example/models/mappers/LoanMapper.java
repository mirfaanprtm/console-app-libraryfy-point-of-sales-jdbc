package org.example.models.mappers;

import org.example.models.Books;
import org.example.models.Loan;
import org.example.models.Users;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanMapper implements RowMapper<Loan> {

    @Override
    public Loan mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loan loan = new Loan();
        loan.setId(rs.getString("id"));
        loan.setLoan_date(rs.getDate("loan_date").toLocalDate());
        loan.setQty(rs.getInt("qty"));
        loan.setUser_id(rs.getString("user_id"));
        loan.setBook_id(rs.getString("book_id"));
        return loan;
    }
}
