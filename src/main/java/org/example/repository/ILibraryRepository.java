package org.example.repository;

import org.example.models.Users;

import java.util.List;
import java.util.Optional;

public interface ILibraryRepository<T> {
    T create(T t) throws Exception;
    List<T> findAll() throws Exception;
    List<T> findById(String id) throws Exception;
    void delete(String id) throws Exception;
    void update(T t, String id) throws Exception;
    default List<T> findLoanByUserId(String id) throws Exception {
        return null;
    }
}
