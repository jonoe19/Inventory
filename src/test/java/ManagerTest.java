import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Manager m;
    Manager m1;
    Manager m2;
    Manager m3;

    @BeforeEach
    void setUp(){
        try{
            m = new Manager("managerman");
            m1 = new Manager("1");
            m2 = new Manager("2");
            m3 = new Manager("2");
        }catch(InvalidNameException e){
            e.printStackTrace();
        }
    }
    @Test
    void getUsername(){
        Manager nullman = null;
        try{
            nullman = new Manager("");
        } catch (InvalidNameException e) {
            nullman = null;
        }
        finally {
            assertEquals("managerman", m.getUsername());
            assertNull(nullman);
        }
    }

    @Test
    void newSalesman(){
        try{
            m.newSalesman("salesman1");
        } catch (InvalidNameException e){
            System.out.println();
        } finally {
            assertThrows(InvalidNameException.class, () -> m.newSalesman(""));
            assertTrue(m.getEmployees()
                    .stream()
                    .anyMatch(s -> s.getUsername()
                                    .equals("salesman1")));
            assertFalse(m.getEmployees()
                    .stream()
                    .anyMatch(s -> s.getUsername()
                                    .equals("fake salesman")));
        }
    }

    @Test
    void newWarehouseWorker(){
        try {
            m.newWarehouseWorker("warehouse man");
        } catch (InvalidNameException e) {
            e.printStackTrace();
        }
    }

    @Test
    void getEmployees() {
        ArrayList<Employee> tests = new ArrayList<>();
        try {
            m.newSalesman("sales man");
            m.newWarehouseWorker("warehouse man");
            tests.add(new Salesman("sales man"));
            tests.add(new WarehouseWorker("warehouse man"));
        }catch (InvalidNameException e){
            e.printStackTrace();
        } finally {
            assertEquals(tests, m.getEmployees());
            assertTrue(m.getEmployees().size() == 2);
        }
    }


    //@Test
    //void orderProduct() {}
}