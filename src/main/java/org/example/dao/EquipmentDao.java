package org.example.dao;

import org.example.entity.ComputerEquipmentEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.example.util.CsvParser.storeEquipments;


public class EquipmentDao {

    public List<ComputerEquipmentEntity> search(String parameter, String value) {
        List<ComputerEquipmentEntity> inventory = storeEquipments();
        List<ComputerEquipmentEntity> results = new ArrayList<>();
        for (ComputerEquipmentEntity computerEquipmentEntity : inventory) {
            switch (parameter) {
                case "id":
                    if (computerEquipmentEntity.getId() == Integer.parseInt(value)) {
                        results.add(computerEquipmentEntity);
                    }
                    break;
                case "name":
                    if (computerEquipmentEntity.getEquipmentName().toLowerCase().contains(value)) {
                        results.add(computerEquipmentEntity);
                    }
                    break;
                case "category":
                    if (computerEquipmentEntity.getCategory().toLowerCase().contains(value)) {
                        results.add(computerEquipmentEntity);
                    }
                    break;
                case "price":
                    if (computerEquipmentEntity.getEquipmentPrice() == Double.parseDouble(value)) {
                        results.add(computerEquipmentEntity);
                    }
                    break;
                case "quantity":
                    if (computerEquipmentEntity.getEquipmentQuantity() == Integer.parseInt(value)) {
                        results.add(computerEquipmentEntity);
                    }
                    break;
                default:
                    System.out.println("Invalid search parameter.");
            }
        }
        return results;
    }

    public List<ComputerEquipmentEntity> list(String order) {
        List<ComputerEquipmentEntity> computerEquipmentEntities = storeEquipments();
        List<ComputerEquipmentEntity> sorted = new ArrayList<>(computerEquipmentEntities);
        switch (order) {
            case "id":
                Collections.sort(sorted, Comparator.comparingInt(ComputerEquipmentEntity::getId));
                break;
            case "name":
                Collections.sort(sorted, Comparator.comparing(ComputerEquipmentEntity::getEquipmentName));
                break;
            case "category":
                Collections.sort(sorted, Comparator.comparing(ComputerEquipmentEntity::getCategory));
                break;
            case "price":
                Collections.sort(sorted, Comparator.comparingDouble(ComputerEquipmentEntity::getEquipmentPrice));
                break;
            case "quantity":
                Collections.sort(sorted, Comparator.comparingInt(ComputerEquipmentEntity::getEquipmentQuantity));
                break;
            default:
                System.out.println("Invalid sort order.");
        }
        return sorted;
    }
}
