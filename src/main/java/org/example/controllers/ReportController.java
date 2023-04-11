package org.example.controllers;

import org.example.models.Loan;
import org.example.models.dto.DailyReport;
import org.example.models.dto.MonthlyReport;
import org.example.services.IReportService;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ReportController {
    private Scanner scanner = new Scanner(System.in);
    private final IReportService reportService;

    public ReportController(IReportService reportService) {
        this.reportService = reportService;
    }

    public void showReport() throws Exception {
        System.out.println("======= Show Report ========>");
        System.out.println("1. Show Monthly Report");
        System.out.println("2. Show Daily Report");
        System.out.print("Choose => ");
    }
    public void showMonthlyReport() throws Exception {
        System.out.println("======= Show Monthly Report ========>");
        System.out.print("Start Date => ");
        String startDate = scanner.nextLine();
        System.out.print("End Date => ");
        String endDate = scanner.nextLine();

        showReportByMonth(startDate, endDate);
    }
    public void showReportByDate() throws Exception {
        System.out.println("======= Show Daily Report ========>");
        System.out.print("Date => ");
        String byDate = scanner.nextLine();

        showReportByDate(byDate);
    }

    public void showReportByMonth(String startDate, String endDate) throws Exception{
        List<MonthlyReport> monthlyReports = reportService.findAllByTransactionDateBetween(startDate, endDate);
        monthlyReports.stream().forEach(monthlyReport -> {
            System.out.println("Date : " + monthlyReport.getDate());
            System.out.println("Total Book Borrowed : " + monthlyReport.getQty());
            System.out.println("Title : " + monthlyReport.getTitle());
            System.out.println("Name : " + monthlyReport.getFull_name());
            System.out.println("=====================================");
        });
    }
    public void showReportByDate(String date) throws Exception{
        List<DailyReport> dailyReports = reportService.findByTransactionDate(date);
        dailyReports.stream().forEach(dailyReport -> {
            System.out.println("Total Book Borrowed : " + dailyReport.getQty());
            System.out.println("Title : " + dailyReport.getTitle());
            System.out.println("Name : " + dailyReport.getFull_name());
            System.out.println("=====================================");
        });
    }
}
