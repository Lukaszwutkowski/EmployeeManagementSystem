package com.managementSystemProject.ConsoleMenu;

public class ConsoleMenu {


    public void startMenu() {
        System.out.println("Start Menu:\n" +
                "Choose your option\n" +
                "1.Log in as Admin\n" +
                "2.Log in as Manager\n" +
                "3.Log in as Employee\n" +
                "4.Quit");
    }

    public void managerMenu() {
        System.out.println("Welcome:\n" +
                "Choose your option\n" +
                "1.Choose Employee\n" +
                "2.Choose Manager\n" +
                "3.Send Message To Employee\n" +
                "4.Send Message To Manager\n" +
                "5.Show All Employees\n");
    }

    public void employeeMenu(){
        System.out.println("Welcome:\n" +
                "Choose your option\n" +
                "1.Choose Employee\n" +
                "2.Choose Manager\n" +
                "3.Send Employee\n" +
                "4.Send Message To Manager\n" +
                "5.Show All Employees\n");
    }

    public void adminMenu() {
        System.out.println("Welcome:\n" +
                "Choose your option\n" +
                "1.Add Employee\n" +
                "2.Add Manager\n" +
                "3.Delete Employee\n" +
                "4.Delete Manager\n" +
                "5.Show Employees\n" +
                "6.Show Managers");
    }

}
