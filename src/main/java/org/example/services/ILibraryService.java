package org.example.services;

import java.util.List;
import java.util.Optional;

public interface ILibraryService<T> {
    T create(T t) throws Exception;
    List<T> findAll() throws Exception;
    List<T> findById(String id) throws Exception;
    void delete(String id) throws Exception;
    void update(T t, String t1) throws Exception;
}
