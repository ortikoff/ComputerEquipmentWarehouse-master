package org.example.controller;

import org.example.service.EquipmentServiceImpl;

import java.util.Scanner;

public class ConsoleViewController {

    private final EquipmentServiceImpl equipmentService = new EquipmentServiceImpl();

    public void control() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("\nEnter command (1-3): ");
            int command = scanner.nextInt();
            scanner.nextLine();
            switch (command) {
                case 1:
                    System.out.print("Enter search parameter (ID, name, category, price, or quantity): ");
                    String parameter = scanner.nextLine().trim().toLowerCase();
                    System.out.print("Enter search value: ");
                    String value = scanner.nextLine().trim().toLowerCase();
                    equipmentService.searchEquipment(parameter, value);
                    break;
                case 2:
                    System.out.print("Enter sort order (ID, name, category, price, or quantity): ");
                    String order = scanner.nextLine().trim().toLowerCase();
                    equipmentService.listEquipment(order);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
