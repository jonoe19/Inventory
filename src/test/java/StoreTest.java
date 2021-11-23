import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StoreTest {

    @Test
    void setName() {
        assertThrows(InvalidNameException.class, () -> s1.setName(""));
        try {
            s1.setName("Store1");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        assertTrue(s1.toString().contains("Store1"));
    }

    @Test
    void setAddress() {
    }

    @Test
    void setPhoneNr() {
        assertThrows(InvalidNameException.class, () -> s1.setPhoneNr(-1));
        try {
            s1.setPhoneNr(12345678);
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
        assertTrue(s1.toString().contains("12345678"));
    }

    @Test
    void testToString() {
    }
}