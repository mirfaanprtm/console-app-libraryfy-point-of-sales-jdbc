package org.example.services;

import org.example.models.dto.DailyReport;
import org.example.models.dto.MonthlyReport;

import java.util.Date;
import java.util.List;

public interface IReportService {
    List<MonthlyReport> findAllByTransactionDateBetween(String startDate, String endDate) throws Exception;
    List<DailyReport> findByTransactionDate(String day) throws Exception;
}
