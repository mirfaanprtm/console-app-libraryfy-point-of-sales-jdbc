package org.example.repository;

import org.example.models.dto.DailyReport;
import org.example.models.dto.MonthlyReport;
import org.example.models.mappers.DailyReportMapper;
import org.example.models.mappers.MonthlyReportMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;

public class ReportRepository implements IReportRepository {
    private JdbcTemplate jdbcTemplate;

    public ReportRepository(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<MonthlyReport> findAllByTransactionDateBetween(Date startDate, Date endDate) throws Exception {
        try {
            return jdbcTemplate.query("select l.loan_date, l.qty, u.full_name, b.title from books as b " +
                    "join loan as l on b.id = l.book_id join users as u on l.user_id = u.id " +
                    "where loan_date between ? and ?", new MonthlyReportMapper(), startDate, endDate);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<DailyReport> findByTransactionDate(Date day) throws Exception {
        try {
            return jdbcTemplate.query("select l.loan_date, l.qty, u.full_name, b.title from books as b " +
                    "join loan as l on b.id = l.book_id join users as u on l.user_id = u.id " +
                    "where loan_date = ?", new DailyReportMapper(), day);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
