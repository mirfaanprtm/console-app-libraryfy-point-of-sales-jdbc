package org.example.repository;

import org.example.models.Loan;
import org.example.models.mappers.LoanMapper;
import org.example.utils.IRandomStringGenerator;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class LoanRepository implements ILibraryRepository<Loan> {
    private JdbcTemplate jdbcTemplate;
    private IRandomStringGenerator randomStringGenerator;

    public LoanRepository(DataSource dataSource, IRandomStringGenerator randomStringGenerator) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.randomStringGenerator = randomStringGenerator;
    }

    @Override
    public Loan create(Loan loan) throws Exception {
        try {
            loan.setId(randomStringGenerator.random());
            int result = jdbcTemplate.update("insert into loan values(?,?,?,?,?)", loan.getId(), loan.getLoan_date(), loan.getQty(), loan.getUser_id(), loan.getBook_id());
            if(result <= 0){
                throw new Exception("Failed to insert loan");
            }
            return loan;
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Loan> findAll() throws Exception {
        try {
            return jdbcTemplate.query("select * from loan", new LoanMapper());
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Loan> findById(String id) throws Exception {
        try {
            return jdbcTemplate.query("select * from loan where id=?", new LoanMapper(), id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            jdbcTemplate.update("delete from loan where id = ?", id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }

    }

    @Override
    public void update(Loan loan, String id) throws Exception {
        try {
            jdbcTemplate.update("update loan set loan_date = ?, qty = ?, user_id = ?, book_id = ?  where id = ?", loan.getLoan_date(), loan.getQty(), loan.getUser_id(), loan.getBook_id(), id);
        } catch (DataAccessException e){
            throw new Exception("Failed to update");
        }
    }

    @Override
    public List<Loan> findLoanByUserId(String id) throws Exception {
        try {
            return jdbcTemplate.query("select *\n" +
                    "from loan l\n" +
                    "where l.user_id = ?", new LoanMapper(), id);
        } catch (DataAccessException e){
            throw new Exception(e.getMessage());
        }
    }
}
