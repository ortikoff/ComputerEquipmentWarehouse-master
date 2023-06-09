import org.example.dao.EquipmentDao;
import org.example.entity.ComputerEquipmentEntity;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ComputerEquipmentTest {


    @Test
    public void testSearchByName() {

        String parameter = "name";
        String value = "monitor";
        EquipmentDao manager = new EquipmentDao();

        List<ComputerEquipmentEntity> results = manager.search(parameter, value);

        // Assert
        Assert.assertEquals(1, results.size());
        Assert.assertEquals("Monitor", results.get(0).getEquipmentName());
    }

    @Test
    public void testSearchByCategory() {
        String parameter = "category";
        String value = "gaming";
        EquipmentDao manager = new EquipmentDao();

        List<ComputerEquipmentEntity> results = manager.search(parameter, value);

        // Assert
        Assert.assertEquals(1, results.size());
        Assert.assertEquals("Headset", results.get(0).getEquipmentName());
    }

    @Test
    public void testSearchByPrice() {
        String parameter = "price";
        String value = "50.00";
        EquipmentDao manager = new EquipmentDao();

        List<ComputerEquipmentEntity> results = manager.search(parameter, value);

        // Assert
        Assert.assertEquals(2, results.size());
        Assert.assertEquals("Headset", results.get(0).getEquipmentName());
        Assert.assertEquals("Webcam", results.get(1).getEquipmentName());
    }


    @Test
    public void testInvalidParameter() {
        String parameter = "invalid";
        String value = "value";
        EquipmentDao manager = new EquipmentDao();

        List<ComputerEquipmentEntity> results = manager.search(parameter, value);

        // Assert
        Assert.assertEquals(0, results.size());
    }

    @Test
    public void testListOrderById() {
        // Arrange
        String order = "id";
        ComputerEquipmentEntity expected = new ComputerEquipmentEntity(1, "Keyboard", "Wireless Keyboard", 25.00, 10);

        // Act
        EquipmentDao equipmentDao = new EquipmentDao();
        List<ComputerEquipmentEntity> result = equipmentDao.list(order);

        // Assert
        Assertions.assertNotEquals(expected, result.get(0));
    }
}
