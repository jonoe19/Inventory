import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {

    @Test
    void getInstance() {
        Inventory i = Inventory.getInstance();
        assertEquals(i, Inventory.getInstance());
    }

    @Test
    void addItem() {
        Inventory i = Inventory.getInstance();
        try {
            Product p = new Product("product1", 9000);
            Integer qty1 = 1;
            Integer qty2 = 2;
            assertNotNull(p);
            try{
                i.addItem(p, qty1);
                i.addItem(p, qty2);
            } catch (InvalidParameterException e){
                e.printStackTrace();
            }
            assertTrue(i.isInStock(p));
            assertTrue(i.getStock().get(p).equals(3));
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteItem() {
    }

    @Test
    void removeItem() {
    }

    @Test
    void isInStock() {
    }

    @Test
    void addOrder() {
    }

    @Test
    void deleteOrder() {
    }

    @Test
    void getStock() {
    }
}