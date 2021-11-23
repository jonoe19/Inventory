import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.HashMap;
import java.util.NoSuchElementException;

class OrderTest {
    Order o;
    Order n;

    @BeforeEach
    void setUp() {
        try{
            n = new Order(new Store("Store1"), new Salesman("salesman1"), new HashMap<Product, Integer>(0));
            o = new Order(new Store("S"), new Salesman("salesman2"), new HashMap<Product, Integer>(0));
            o.addProduct(new Product("Pan", 3), 2);
            o.addProduct(new Product("Pot", 2), 1);
            n.addProduct(new Product("Pan", 3), 2);
            n.addProduct(new Product("Pot", 2), 1);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void orderStatus() {
        o.setOrderStatus(OrderStatus.PENDING);
        assertEquals(o.getOrderStatus(), OrderStatus.PENDING);
    }

    @Test
    void getStore(){
        assertTrue(n.getStore().toString().contains("Store1"));
    }

    @Test
    void getSalesman() {
        assertEquals(o.getSalesman().getUsername(),"salesman2");
        assertFalse(o.getSalesman().equals(n.getSalesman()));
    }

    @Test
    void getOrderID() {
        assertTrue(o.getOrderID() >= 0);
        assertNotEquals(o.getOrderID(), n.getOrderID());
    }

    @Test
    void getOrderedProducts() {
        assertFalse(o.getOrderedProducts().keySet().stream().anyMatch( s -> s.getName() == "Peter Pan"));
        assertEquals(n.getOrderedProducts(),o.getOrderedProducts());
        assertTrue(o.getOrderedProducts().size() == 2);
        assertTrue(o.getOrderedProducts().values().stream().reduce(0, Integer::sum) == 3);
    }

    @Test
    void addProduct() {
        try{
            o.addProduct(new Product("pan2", 200), 2);
            assertTrue(o.getOrderedProducts().keySet().stream().anyMatch(s -> s.getName() == "pan2"));
            o.addProduct(new Product("pan2", 200), 2);
            assertEquals(o.getOrderedProducts().get(new Product("pan2", 200)), 4);

            assertThrows(IllegalArgumentException.class, () -> o.addProduct(new Product("pan3", 200), -1));
            assertFalse(o.getOrderedProducts().containsValue(-1));

            assertThrows(IllegalArgumentException.class,()-> o.addProduct(new Product("pan4", 200), 0));
            assertFalse(o.getOrderedProducts().keySet().stream().anyMatch(s -> s.getName() == "pan4"));

            //Product can be named null
            assertDoesNotThrow(() -> o.addProduct(new Product(null, 200), 1));
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void deleteProduct() {
        assertTrue(o.getOrderedProducts().keySet().stream().anyMatch(s -> s.getName() == "Pan") );
        o.deleteProduct("Pan");
        assertFalse(o.getOrderedProducts().keySet().stream().anyMatch(s -> s.getName() == "Pan") );

        assertDoesNotThrow(() -> o.deleteProduct("Pot"));
        assertThrows(NoSuchElementException.class, () -> o.deleteProduct("Pat"));
    }
}