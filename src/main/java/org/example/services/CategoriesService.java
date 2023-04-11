package org.example.services;

import org.example.models.Categories;
import org.example.models.Users;
import org.example.repository.ILibraryRepository;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.List;
import java.util.Optional;

public class CategoriesService implements ILibraryService<Categories> {
    private final ILibraryRepository<Categories> categoriesRepository;

    public CategoriesService(ILibraryRepository<Categories> categoriesRepository) {
        this.categoriesRepository = categoriesRepository;
    }

    @Override
    public Categories create(Categories categories) throws Exception {
        try {
            List<Categories> categories1 = categoriesRepository.findAll();
            if(categories1.stream().anyMatch(existingCategory -> existingCategory.getCategory_name().equalsIgnoreCase(categories.getCategory_name()))){
                throw new DataIntegrityViolationException("Category Already Exist");
            }
            categoriesRepository.create(categories);
            System.out.println("Create Categories Success");
            return categories;
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Categories> findAll() throws Exception {
        try {
            List<Categories> categories = categoriesRepository.findAll();
            if(categories.isEmpty()){
                throw new Exception("Data Category Not Found!");
            }
            return categoriesRepository.findAll();
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public List<Categories> findById(String id) throws Exception {
        try {
            List<Categories> categories = categoriesRepository.findById(id);
            if(categories.isEmpty()){
                throw new Exception("ID Not Found");
            }
            return categoriesRepository.findById(id);
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }

    @Override
    public void delete(String id) throws Exception {
        try {
            List<Categories> categories = categoriesRepository.findById(id);
            if(categories.isEmpty()){
                throw new Exception("ID Not Found");
            }
            categoriesRepository.delete(id);
            System.out.println("Delete Success");
        } catch (Exception e){
            throw new Exception();
        }
    }

    @Override
    public void update(Categories categories, String id) throws Exception {
        try {
            List<Categories> categories1 = categoriesRepository.findById(id);
            if(categories1.isEmpty()){
                throw new Exception("ID Not Found");
            }
            List<Categories> categoriesUpdate = categoriesRepository.findAll();
            if(categoriesUpdate.stream().anyMatch(existingCategory -> existingCategory.getCategory_name().equalsIgnoreCase(categories.getCategory_name()))){
                throw new DataIntegrityViolationException("Category Already Exist");
            }
            Categories existCategory = categories1.get(0);
            existCategory.setCategory_name(categories.getCategory_name());
            categoriesRepository.update(categories, id);
            System.out.println("Update Success");
        } catch (Exception e){
            throw new Exception(e.getMessage());
        }
    }
}
