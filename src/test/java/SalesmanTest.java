import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalesmanTest {

    Salesman s1;
    Salesman s2;
    Salesman s3;
    Salesman s4;
    Salesman nullman;
    @BeforeEach
    void setUp(){
        try {
            s1 = new Salesman("Salesman1");
            s2 = new Salesman("Salesman2");
            s3 = new Salesman("Salesman3");
            s4 = new Salesman("Salesman4");

        }catch(InvalidUsernameException e){
            e.printStackTrace();
        }
        try{
            nullman = new Salesman("");
        }catch(InvalidUsernameException e){
            nullman = null;
        }

    }

    @Test
    void getUsername() {
        assertEquals("Salesman1", s1.getUsername());
        assertEquals("Salesman2", s2.getUsername());
        assertEquals("Salesman3", s3.getUsername());
        assertEquals("Salesman4", s4.getUsername());
        assertNull(nullman);

    }

    @Test
    void getCustomers() {
        Store imerco = new Store("Imerco");
        s1.addCustomer(imerco);
        assertTrue(s1.getCustomers()
                .stream()
                .anyMatch(s -> s.toString().equals(imerco.toString())));
    }

    @Test
    void createOrder() {


    }
}