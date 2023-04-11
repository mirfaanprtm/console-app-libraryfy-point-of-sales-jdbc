package org.example.models;

import java.time.LocalDate;
import java.util.List;

public class Loan {
    private String id;
    private LocalDate loan_date;
    private Integer qty;
    private String book_id;
    private String user_id;

    public Loan(String id, LocalDate loan_date, Integer qty, String book_id, String user_id) {
        this.id = id;
        this.loan_date = loan_date;
        this.qty = qty;
        this.book_id = book_id;
        this.user_id = user_id;
    }

    public Loan() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LocalDate getLoan_date() {
        return loan_date;
    }

    public void setLoan_date(LocalDate loan_date) {
        this.loan_date = loan_date;
    }

    public Integer getQty() {
        return qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public String getBook_id() {
        return book_id;
    }

    public void setBook_id(String book_id) {
        this.book_id = book_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    @Override
    public String toString() {
        return "Loan{" +
                "id=" + id +
                ", loan_date=" + loan_date +
                ", qty=" + qty +
                ", books=" + book_id +
                ", users=" + user_id +
                '}';
    }
}
