package org.example;

import org.example.config.Config;
import org.example.controller.AuthController;
import org.example.db.DataBase;
import org.example.db.InitDataBase;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        DataBase.initTable();

        ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        InitDataBase initDataBase = (InitDataBase) context.getBean("initDataBase");

        initDataBase.adminInit();
        initDataBase.addCompanyCard();

        AuthController authController = (AuthController) context.getBean("authController");
        authController.start();
    }
}
