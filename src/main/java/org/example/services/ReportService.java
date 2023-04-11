package org.example.services;

import org.example.models.dto.DailyReport;
import org.example.models.dto.MonthlyReport;
import org.example.repository.IReportRepository;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService implements IReportService{
    private IReportRepository reportRepository;

    public ReportService(IReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @Override
    public List<MonthlyReport> findAllByTransactionDateBetween(String startDate, String endDate) throws Exception {
        Date start = new SimpleDateFormat("yyyy-MM-dd").parse(startDate);
        Date end = new SimpleDateFormat("yyyy-MM-dd").parse(endDate);
        List<MonthlyReport> getDate = reportRepository.findAllByTransactionDateBetween(start, end);
        return getDate;
    }

    @Override
    public List<DailyReport> findByTransactionDate(String day) throws Exception {
        Date date = new SimpleDateFormat("yyyy-MM-dd").parse(day);
        List<DailyReport> getDate = reportRepository.findByTransactionDate(date);
        return getDate;
    }
}
