package com.managementSystemProject;

import com.managementSystemProject.ConsoleMenu.ConsoleMenu;
import com.managementSystemProject.Login.LoginAdmin;

import java.util.Scanner;

public class Test {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ConsoleMenu consoleMenu = new ConsoleMenu();
        consoleMenu.startMenu();
        SingletonCache.getInstance().getLog();

        LoginAdmin loginAdmin = new LoginAdmin();
        loginAdmin.loginActionPerformed();

    }
}

