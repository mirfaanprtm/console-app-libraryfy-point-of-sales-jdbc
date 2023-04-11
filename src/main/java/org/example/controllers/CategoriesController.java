package org.example.controllers;

import org.example.models.Categories;
import org.example.models.Users;
import org.example.services.ILibraryService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class CategoriesController {
    private Scanner scanner = new Scanner(System.in);
    private final ILibraryService<Categories> categoriesService;

    public CategoriesController(ILibraryService<Categories> categoriesService) {
        this.categoriesService = categoriesService;
    }

    public void addCategories() throws Exception {
        System.out.println("============= Create Categories ===============");
        System.out.print("Category Name => ");
        String name = scanner.nextLine();

        Categories categories = new Categories();
        categories.setCategory_name(name);
        this.categoriesService.create(categories);
    }
    public void updateCategories() throws Exception {
        System.out.println("============= Update Categories ===============");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.print("Update Category Name => ");
        String name = scanner.nextLine();

        Categories categories = new Categories();
        categories.setCategory_name(name);
        categoriesService.update(categories, id);
    }

    public void getById() throws Exception {
        System.out.println("========== Search Categories By Id ==========");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.println(categoriesService.findById(id));
    }

    public void deleteCategories() throws Exception {
        System.out.println("======= Delete Categories ========>");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        categoriesService.delete(id);
    }

    public void getAllCategories() throws Exception {
        System.out.println("============ All Categories =============");
        categoriesService.findAll().forEach(System.out::println);
    }
}
