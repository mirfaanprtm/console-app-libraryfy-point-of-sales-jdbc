package org.example.controllers;

import org.example.models.Users;
import org.example.services.ILibraryService;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class UsersController {

    private Scanner scanner = new Scanner(System.in);
    private ILibraryService<Users> userService;

    public UsersController(ILibraryService<Users> userService) {
        this.userService = userService;
    }
    public void addUser() throws Exception {
        System.out.println("============= Create User ===============");
        System.out.print("Full Name => ");
        String name = scanner.nextLine();
        System.out.print("Phone Number => ");
        String phoneNumber = scanner.nextLine();

        Users users = new Users();
        users.setFull_name(name);
        users.setPhone_number(phoneNumber);
        userService.create(users);
    }
    public void updateUser() throws Exception {
        System.out.println("============= Update User ===============");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.print("Update Full Name => ");
        String name = scanner.nextLine();
        System.out.print("Update Phone Number => ");
        String phoneNumber = scanner.nextLine();

        Users users = new Users();
        users.setFull_name(name);
        users.setPhone_number(phoneNumber);
        userService.update(users, id);
    }

    public void getById() throws Exception {
        System.out.println("========== Search User By Id ==========");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        System.out.println(userService.findById(id));
    }

    public void deleteUser() throws Exception {
        System.out.println("======= Delete User ========>");
        System.out.print("Id => ");
        String id = scanner.nextLine();
        userService.delete(id);
    }

    public void getAllUsers() throws Exception {
        System.out.println("============ All Users =============");
        userService.findAll().forEach(System.out::println);
    }
}
