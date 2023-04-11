package org.example.controllers;

import org.example.models.Books;
import org.example.models.Categories;
import org.example.models.Users;
import org.example.services.ILibraryService;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Controller
public class BooksController {
    private Scanner scanner = new Scanner(System.in);
    private final ILibraryService<Books> booksService;

    public BooksController(ILibraryService<Books> booksService) {
        this.booksService = booksService;
    }

    public void addBooks() throws Exception {
        System.out.println("============= Create Books ===============");
        System.out.print("Title => ");
        String title = scanner.nextLine();
        System.out.print("Publication Year => ");
        Integer pubYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Author => ");
        String author = scanner.nextLine();
        System.out.print("Publisher => ");
        String publisher = scanner.nextLine();
        System.out.print("Category Id => ");
        String catId = scanner.nextLine();

        Books books = new Books();
        books.setTitle(title);
        books.setPublication_year(pubYear);
        books.setAuthor(author);
        books.setPublisher(publisher);
        books.setCategory_id(catId);
        booksService.create(books);
    }
    public void updateBooks() throws Exception {
        System.out.println("============= Update Books ===============");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.print("Update Title => ");
        String title = scanner.nextLine();
        System.out.print("Update Publication Year => ");
        Integer pubYear = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Update Author => ");
        String author = scanner.nextLine();
        System.out.print("Update Publisher => ");
        String publisher = scanner.nextLine();
        System.out.print("Update Category Id => ");
        String catId = scanner.nextLine();

        Books books = new Books();
        books.setId(id);
        books.setTitle(title);
        books.setPublication_year(pubYear);
        books.setAuthor(author);
        books.setPublisher(publisher);
        books.setCategory_id(catId);
        booksService.update(books, id);
    }

    public void getById() throws Exception {
        System.out.println("========== Search Book By Id ==========");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.println(booksService.findById(id));
    }

    public void deleteBooks() throws Exception {
        System.out.println("======= Delete Book ========>");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        booksService.delete(id);
    }

    public void getAllBooks() throws Exception {
        System.out.println("============ All Books =============");
        booksService.findAll().forEach(System.out::println);
    }
}
