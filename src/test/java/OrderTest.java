import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;

class OrderTest {
    Order o = null;
    Order n = null;
    HashMap<Product, Integer> hm = new HashMap<Product, Integer>();

    @BeforeEach
    void setUp(){
        try {
            hm.put(new Product("Pan", 3), 2);
            hm.put(new Product("Pot", 2), 2);
            hm.put(new Product("Peter Pan", 1), 1);
            n = new Order(new Store("Store1"), new Salesman("salesman1"), hm);
            o = new Order(new Store("S"), new Salesman("salesman2"), hm);
        } catch (InvalidUsernameException | InvalidProductNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderStatus() {
        o.setOrderStatus("Pending");
        assertEquals(o.getOrderStatus(), "Pending");
        assertThrows(Exception.class, () -> o.setOrderStatus("lol"));
    }

    @Test
    void getStore() {
        assertTrue(o.getStore().toString().contains("Store1"));
    }

    @Test
    void getSalesman() {
        assertEquals(o.getSalesman().getUsername(),"salesman1");
        assertFalse(o.getSalesman().equals(n.getSalesman()));
    }

    @Test
    void getOrderID() {
        assertTrue(o.getOrderID() >= 0);
        assertNotEquals(o.getOrderID(), n.getOrderID());
    }

    @Test
    void getOrderedProducts() {
        assertTrue(o.getOrderedProducts().containsKey("Peter Pan"));
        assertEquals(n.getOrderedProducts(),o.getOrderedProducts());
        assertTrue(o.getOrderedProducts().size() == 3);
        assertTrue(o.getOrderedProducts().values().stream().reduce(0, Integer::sum) == 5);
    }

    @Test
    void addProduct() {
        try{

            o.addProduct(new Product("pan2", 200), 2);
            assertTrue(o.getOrderedProducts().containsKey("pan2"));

            o.addProduct(new Product("pan3", 200), -1);
            assertFalse(o.getOrderedProducts().containsValue(-1));

            o.addProduct(new Product("pan4", 200), 0);
            assertFalse(o.getOrderedProducts().containsKey("pan4"));

            o.addProduct(new Product("Pan", 200), 0);
            o.addProduct(new Product(null, 200), 1);
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteProduct() {

    }
}