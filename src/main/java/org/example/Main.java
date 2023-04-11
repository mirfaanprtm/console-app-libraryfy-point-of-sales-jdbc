package org.example;

import org.example.config.BeanConfigruation;
import org.example.controllers.AppController;
import org.example.controllers.UsersController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfigruation.class);
        AppController appController = context.getBean(AppController.class);
        appController.runApp();

    }
}