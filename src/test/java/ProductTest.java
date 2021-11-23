import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p;
    Product q;
    Product z;

    {
        try {
            p = new Product("Bazinga", 880);
            q = new Product("Bazinga", 880);
            z = new Product("Sheldon", 880);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setPrice() {
        assertTrue(p.getPrice() == 880);
        p.setPrice(200);
        assertTrue(p.getPrice() == 200);

        assertThrows(InvalidParameterException.class, () -> p.setPrice(-2));
    }

    @Test
    void getName() {
        assertThrows(InvalidNameException.class, () -> new Product("",0));
        assertTrue(p.getName().equals("Bazinga"));
    }

    @Test
    void testEquals() {
        assertEquals(p, q);
        assertNotEquals(p,z);
        q.setPrice(1);
        assertEquals(p,q);
    }

    @Test
    void testHashCode() {
        assertNotNull(p.hashCode());
    }
}