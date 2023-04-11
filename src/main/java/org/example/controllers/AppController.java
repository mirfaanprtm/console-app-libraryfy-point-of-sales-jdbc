package org.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class AppController {
    Scanner scanner = new Scanner(System.in);
    private UsersController usersController;
    private CategoriesController categoriesController;
    private BooksController booksController;
    private LoanController loanController;
    private ReportController reportController;

    public AppController(UsersController usersController, CategoriesController categoriesController, BooksController booksController, LoanController loanController, ReportController reportController) {
        this.usersController = usersController;
        this.categoriesController = categoriesController;
        this.booksController = booksController;
        this.loanController = loanController;
        this.reportController = reportController;
    }

    public void backToMainMenu() throws Exception {
        System.out.print("Back to main menu ? (y/n) => ");
        String yn = scanner.next();
        if(yn.equalsIgnoreCase("y")){
            runApp();
        } else {
            System.out.println("Thank You For Coming");
            System.exit(0);
        }
    }
    public void runApp() throws Exception {
        System.out.println("================== LIBRARYFY =================");
        System.out.println("1. USERS");
        System.out.println("2. BOOKS CATEGORY");
        System.out.println("3. BOOKS");
        System.out.println("4. BOOKS LOAN");
        System.out.println("5. REPORT");
        System.out.println("6. Exit");
        System.out.print("Enter Your Choice => ");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> showMenuUsers();
            case 2 -> showMenuCategories();
            case 3 -> showMenuBooks();
            case 4 -> showMenuLoan();
            case 5 -> {
                reportController.showReport();
                Integer choose = scanner.nextInt();
                scanner.nextLine();
                switch (choose) {
                    case 1:
                        reportController.showMonthlyReport();
                        backToMainMenu();
                    case 2:
                        reportController.showReportByDate();
                        backToMainMenu();
                    default:
                        System.out.println("Choose 1 or 2");
                        backToMainMenu();
                }
            }
            case 6 -> System.exit(0);
            default -> {
                System.out.println("Choose 1 - 6");
                runApp();
            }
        }
    }

    public void showMenuUsers() throws Exception {
        System.out.println("================== USERS =================");
        System.out.println("1. Add User");
        System.out.println("2. Get All User");
        System.out.println("3. Get User By Id");
        System.out.println("4. Delete User");
        System.out.println("5. Update User");
        System.out.println("6. Exit");
        System.out.print("Enter Your Choice => ");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                usersController.addUser();
                backToMainMenu();
            }
            case 2 -> {
                usersController.getAllUsers();
                backToMainMenu();
            }
            case 3 -> {
                usersController.getById();
                backToMainMenu();
            }
            case 4 -> {
                usersController.deleteUser();
                backToMainMenu();
            }
            case 5 -> {
                usersController.updateUser();
                backToMainMenu();
            }
            case 6 -> backToMainMenu();
        }
    }

    public void showMenuCategories() throws Exception {
        System.out.println("================== CATEGORIES =================");
        System.out.println("1. Add Categories");
        System.out.println("2. Get All Categories");
        System.out.println("3. Get Categories By Id");
        System.out.println("4. Delete Categories");
        System.out.println("5. Update Categories");
        System.out.println("6. Exit ");
        System.out.print("Enter Your Choice => ");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                categoriesController.addCategories();
                backToMainMenu();
            }
            case 2 -> {
                categoriesController.getAllCategories();
                backToMainMenu();
            }
            case 3 -> {
                categoriesController.getById();
                backToMainMenu();
            }
            case 4 -> {
                categoriesController.deleteCategories();
                backToMainMenu();
            }
            case 5 -> {
                categoriesController.updateCategories();
                backToMainMenu();
            }
            case 6 -> System.exit(0);
        }
    }
    public void showMenuBooks() throws Exception {
        System.out.println("================== BOOKS =================");
        System.out.println("1. Add Books");
        System.out.println("2. Get All Books");
        System.out.println("3. Get Books By Id");
        System.out.println("4. Delete Books");
        System.out.println("5. Update Books");
        System.out.println("6. Exit ");
        System.out.print("Enter Your Choice => ");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                booksController.addBooks();
                backToMainMenu();
            }
            case 2 -> {
                booksController.getAllBooks();
                backToMainMenu();
            }
            case 3 -> {
                booksController.getById();
                backToMainMenu();
            }
            case 4 -> {
                booksController.deleteBooks();
                backToMainMenu();
            }
            case 5 -> {
                booksController.updateBooks();
                backToMainMenu();
            }
            case 6 -> System.exit(0);
        }
    }
    public void showMenuLoan() throws Exception {
        System.out.println("================== LOAN =================");
        System.out.println("1. Add Loan");
        System.out.println("2. Get All Loan");
        System.out.println("3. Get Loan By Id");
        System.out.println("4. Delete Loan");
        System.out.println("5. Update Loan");
        System.out.println("6. Exit ");
        System.out.print("Enter Your Choice => ");
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> {
                loanController.addLoan();
                backToMainMenu();
            }
            case 2 -> {
                loanController.getAllLoan();
                backToMainMenu();
            }
            case 3 -> {
                loanController.getById();
                backToMainMenu();
            }
            case 4 -> {
                loanController.deleteLoan();
                backToMainMenu();
            }
            case 5 -> {
                loanController.updateLoan();
                backToMainMenu();
            }
            case 6 -> System.exit(0);
        }
    }
}
