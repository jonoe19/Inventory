import java.util.ArrayList;

/**
 * A singleton representing the manager of the company
 */
public class Manager extends Employee{

    /**
     * Attributes.
     */
    private String username;
    private ArrayList<Employee> employees;

    /**
     * Constructor.
     * @param username
     * @throws InvalidUsernameException
     */
    public Manager(String username) throws InvalidUsernameException{
        if(usernameValid(username)) {
            this.username = username;
            this.employees = new ArrayList<>();
        }else
            throw new InvalidUsernameException();
    }

    /**
     * Returns the username of this manager.
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns a list of all employees managed by this manager.
     * @return employees
     */
    public ArrayList<Employee> getEmployees(){
        return employees;
    }

    /**
     * Orders a new product from a supplier.
     * @param product
     * @param qty
     * @param supplier
     */
    //public void orderProduct(String product, int qty, String supplier){}

    /**
     * Creates new salesman.
     * @param username
     */
    public void newSalesman(String username) throws InvalidUsernameException{
        employees.add(new Salesman(username));
    }

    /**
     * Creates new warehouse worker.
     * @param username
     */
    public void newWarehouseWorker(String username) throws InvalidUsernameException{
        employees.add(new WarehouseWorker(username));
    }

}
