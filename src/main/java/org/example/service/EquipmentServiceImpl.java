package org.example.service;


import org.example.entity.ComputerEquipmentEntity;
import org.example.dao.EquipmentDao;

import java.util.List;


public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentDao equipmentDao = new EquipmentDao();

    public void searchEquipment(String parameter, String value) {
        List<ComputerEquipmentEntity> results = equipmentDao.search(parameter, value);
        if (results.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        System.out.println("Search results:");
        for (ComputerEquipmentEntity computerEquipmentEntity : results) {
            System.out.println(computerEquipmentEntity);
        }
    }

    public void listEquipment(String order) {
        List<ComputerEquipmentEntity> sorted = equipmentDao.list(order);
        System.out.println("Product list:");
        for (ComputerEquipmentEntity equipment : sorted) {
            System.out.println(equipment);
        }
    }
}
