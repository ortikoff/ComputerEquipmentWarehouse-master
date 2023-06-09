package org.example.util;


import org.example.entity.ComputerEquipmentEntity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvParser {
    public static List<ComputerEquipmentEntity> storeEquipments() {
        List<ComputerEquipmentEntity> inventory = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/ComputerEquipment.csv"))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String category = fields[2];
                double price = Double.parseDouble(fields[3]);
                int quantity = Integer.parseInt(fields[4]);
                ComputerEquipmentEntity computerEquipmentEntity = new ComputerEquipmentEntity(id, name, category, price, quantity);
                inventory.add(computerEquipmentEntity);
            }
        } catch (IOException e) {
            System.err.println("Error reading ComputerEquipment.csv file: " + e.getMessage());
        }
        return inventory;
    }
}
