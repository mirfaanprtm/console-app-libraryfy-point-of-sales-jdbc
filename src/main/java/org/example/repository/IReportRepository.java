package org.example.repository;

import org.example.models.dto.DailyReport;
import org.example.models.dto.MonthlyReport;

import java.util.Date;
import java.util.List;

public interface IReportRepository<M> {
    List<MonthlyReport> findAllByTransactionDateBetween(Date startDate, Date endDate) throws Exception;
    List<DailyReport> findByTransactionDate(Date day) throws Exception;
}
