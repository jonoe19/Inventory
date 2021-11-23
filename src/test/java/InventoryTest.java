import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class InventoryTest {
    Inventory i = Inventory.getInstance();

    @Test
    void getInstance() {
        assertEquals(i, Inventory.getInstance());
    }

    @Test
    void addItem() {
        try {
            Product p;
            p = new Product("product1", 9000);
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
        } catch (TooFewProductsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteItem() {
        Product p;
        try {
            p = new Product("product2", 100);
            i.addItem(p,100);
            assertThrows(NoSuchElementException.class, () ->
                    i.deleteItem(new Product("FakeProduct", 100)));
            assertTrue(i.getStock().containsKey(p));
            i.deleteItem(p);
            assertFalse(i.getStock().containsKey(p));
        } catch (InvalidNameException | TooFewProductsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void removeItem() {
        Product p;
        try {
            p = new Product("product3", 100);
            assertThrows(NoSuchElementException.class, () -> i.removeItem(p, 100));
            i.addItem(p,100);
            assertThrows(TooFewProductsException.class, () -> i.removeItem(p, 200));
            i.removeItem(p, 25);
            assertEquals(75, (int) i.getStock().get(p));
            i.deleteItem(p);
        } catch (InvalidNameException | TooFewProductsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void isInStock() {
        Product p;
        try {
            p = new Product("product4", 100);
            i.addItem(p,100);
            assertTrue(i.isInStock(p));
            assertFalse(i.isInStock(new Product("FakeProduct", 10)));
            i.deleteItem(p);
            assertFalse(i.isInStock(p));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        } catch (TooFewProductsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addOrder() {
        try {
            Order o1 = new Order(
                    new Store("store1"),
                    new Salesman("sales1"),
                    new HashMap<>(0));
            Order o2 = new Order(
                    new Store("store2"),
                    new Salesman("sales2"),
                    new HashMap<>(0));
            assertTrue(i.getOrder().isEmpty());
            i.addOrder(o1);
            i.addOrder(o2);
            assertEquals(2, i.getOrder().size());
            i.deleteOrder(o1.getOrderID());
            i.deleteOrder(o2.getOrderID());
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteOrder() {
        try {
            Order o1 = new Order(
                    new Store("store1"),
                    new Salesman("sales1"),
                    new HashMap<Product,Integer>(0));
            Order o2 = new Order(
                    new Store("store2"),
                    new Salesman("sales2"),
                    new HashMap<Product,Integer>(0));
            assertThrows(NoSuchElementException.class, () ->
                    i.deleteOrder(o1.getOrderID()));
            i.addOrder(o1);
            i.addOrder(o2);
            assertEquals(2, i.getOrder().size());
            i.deleteOrder(o1.getOrderID());
            i.deleteOrder(o2.getOrderID());
            assertTrue(i.getOrder().isEmpty());
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }

    }

    @Test
    void getStock() {
        Product p = null;
        Product q = null;
        try {
            p = new Product("p", 100);
            q = new Product("q", 100);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        i.addItem(p,100);
        i.addItem(q, 50);
        HashMap<Product,Integer> prodList = new HashMap<>(2);
        prodList.put(p, 100);
        prodList.put(q, 50);
        assertEquals(prodList, i.getStock());
        try {
            i.deleteItem(p);
            i.deleteItem(q);
        } catch (TooFewProductsException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getOrder() {
        ArrayList<Order> testOrders = new ArrayList<>(2);
        try {
            Order o1 = new Order(
                    new Store("store1"),
                    new Salesman("sales1"),
                    new HashMap<Product,Integer>(0));
            Order o2 = new Order(
                    new Store("store2"),
                    new Salesman("sales2"),
                    new HashMap<Product,Integer>(0));
            testOrders.add(o1);
            testOrders.add(o2);
            i.addOrder(o1);
            i.addOrder(o2);
            assertEquals(testOrders, i.getOrder());
            i.deleteOrder(o1.getOrderID());
            i.deleteOrder(o2.getOrderID());
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
     }
}