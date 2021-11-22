import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    Product p;

    {
        try {
            p = new Product("Bazinga", 880);
        } catch (InvalidProductNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void setPrice() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void getName() {
    }

    @Test
    void testEquals() {
    }

    @Test
    void testHashCode() {
    }
}