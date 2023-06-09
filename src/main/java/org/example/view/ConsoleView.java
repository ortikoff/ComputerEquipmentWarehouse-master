package org.example.view;


import org.example.controller.ConsoleViewController;

public class ConsoleView {


    public final ConsoleViewController control = new ConsoleViewController();

    public static void main(String[] args) {
        System.out.println("Computer Equipment Warehouse (Created on April 29, 2023)");
        System.out.println("Developer: Shakhzod Ortikov (shakhzod_ortikov@student.itpu.uz)");


        System.out.println("\nAvailable commands:");
        System.out.println("1. Search products");
        System.out.println("2. List all products");
        System.out.println("3. Exit");

        ConsoleView consoleView = new ConsoleView();
        consoleView.start();
    }

    public void start() {
        control.control();
    }

}
