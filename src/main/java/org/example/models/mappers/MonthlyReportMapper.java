package org.example.models.mappers;

import org.example.models.dto.MonthlyReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MonthlyReportMapper implements RowMapper<MonthlyReport> {
    @Override
    public MonthlyReport mapRow(ResultSet rs, int rowNum) throws SQLException {
        MonthlyReport monthlyReport = new MonthlyReport();
        monthlyReport.setDate(rs.getString("loan_date"));
        monthlyReport.setQty(rs.getInt("qty"));
        monthlyReport.setFull_name(rs.getString("full_name"));
        monthlyReport.setTitle(rs.getString("title"));
        return monthlyReport;
    }
}
