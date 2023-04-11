package org.example.services;

import org.example.models.Books;
import org.example.models.Categories;
import org.example.models.Users;
import org.example.repository.ILibraryRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

public class BookService implements ILibraryService<Books> {
    private final ILibraryRepository<Books> bookRepository;

    public BookService(ILibraryRepository<Books> bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Books create(Books books) throws Exception {
        try {
            List<Books> booksUpdate = bookRepository.findAll();
            if(booksUpdate.stream().anyMatch(existingBook -> existingBook.getTitle().equalsIgnoreCase(books.getTitle()))){
                throw new DataIntegrityViolationException("Book Title Already Exist");
            }
            bookRepository.create(books);
            System.out.println("Create Success");
            return books;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Books> findAll() throws Exception {
        try {
            List<Books> books = bookRepository.findAll();
            if(books.isEmpty()){
                throw new Exception("Data Book Not Found!");
            }
            return bookRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Books> findById(String id) throws Exception {
        try {
            List<Books> book = bookRepository.findById(id);
            if(book.isEmpty()){
                throw new Exception("ID Not Found");
            }
            return bookRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            List<Books> book = bookRepository.findById(id);
            if(book.isEmpty()){
                throw new Exception("ID Not Found");
            }
            bookRepository.delete(id);
            System.out.println("Delete Success");
        } catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public void update(Books books, String id) throws Exception {
        try {
            List<Books> books1 = bookRepository.findById(id);
            if(books1.isEmpty()){
                throw new Exception("ID Not Found");
            }
            List<Books> booksUpdate = bookRepository.findAll();
            if(booksUpdate.stream().anyMatch(existingBook -> existingBook.getTitle().equalsIgnoreCase(books.getTitle()))){
                throw new DataIntegrityViolationException("Book Title Already Exist");
            }
            Books existBook = books1.get(0);
            existBook.setTitle(books.getTitle());
            bookRepository.update(books, id);
            System.out.println("Update Success");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

}
