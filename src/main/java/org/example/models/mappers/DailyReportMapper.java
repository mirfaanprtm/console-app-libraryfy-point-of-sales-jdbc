package org.example.models.mappers;

import org.example.models.dto.DailyReport;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DailyReportMapper implements RowMapper<DailyReport> {
    @Override
    public DailyReport mapRow(ResultSet rs, int rowNum) throws SQLException {
        DailyReport dailyReport = new DailyReport();
        dailyReport.setDate(rs.getString("loan_date"));
        dailyReport.setQty(rs.getInt("qty"));
        dailyReport.setFull_name(rs.getString("full_name"));
        dailyReport.setTitle(rs.getString("title"));
        return dailyReport;
    }
}
