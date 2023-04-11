package org.example.controllers;

import org.example.models.Books;
import org.example.models.Loan;
import org.example.services.ILibraryService;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Scanner;

@Controller
public class LoanController {
    private Scanner scanner = new Scanner(System.in);
    private final ILibraryService<Loan> loanService;

    public LoanController(ILibraryService<Loan> loanService) {
        this.loanService = loanService;
    }

    public void addLoan() throws Exception {
        System.out.println("============= Create Loan ===============");
        System.out.print("Loan Date => ");
        String loanDate = scanner.nextLine();
        System.out.print("Qty => ");
        Integer qty = scanner.nextInt();
        scanner.nextLine();
        System.out.print("User Id => ");
        String userId = scanner.nextLine();
        System.out.print("Book Id => ");
        String bookId = scanner.nextLine();

        Loan loan = new Loan();
        loan.setLoan_date(LocalDate.parse(loanDate));
        loan.setQty(qty);
        loan.setUser_id(userId);
        loan.setBook_id(bookId);
        loanService.create(loan);
    }
    public void updateLoan() throws Exception {
        System.out.println("============= Update Loan ===============");
        System.out.print("id => ");
        String id = scanner.nextLine();
        System.out.print("Update Loan Date => ");
        String loanDate = scanner.nextLine();
        System.out.print("Update Qty => ");
        Integer qty = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Update User Id => ");
        String userId = scanner.nextLine();
        System.out.print("Update Book Id => ");
        String bookId = scanner.nextLine();

        Loan loan = new Loan();
        loan.setId(id);
        loan.setLoan_date(LocalDate.parse(loanDate));
        loan.setQty(qty);
        loan.setUser_id(userId);
        loan.setBook_id(bookId);
        loanService.update(loan, id);
    }

    public void getById() throws Exception {
        System.out.println("========== Search Loan By Id ==========");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.println(loanService.findById(id));
    }

    public void deleteLoan() throws Exception {
        System.out.println("======= Delete Loan ========>");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        loanService.delete(id);
    }

    public void getAllLoan() throws Exception {
        System.out.println("============ All Loan =============");
        loanService.findAll().forEach(System.out::println);
    }
}
