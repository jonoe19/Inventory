import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Class representing an employee of type salesman.
 */
public class Salesman extends Employee{

    /**
     * Attributes.
     */
    private String username;
    private ArrayList<Store> customers;

    /**
     * Constructor.
     * @param username
     */
    public Salesman(String username) throws InvalidUsernameException {
        if(usernameValid(username)) {
            this.username = username;
            this.customers = new ArrayList<>();
        }else
            throw new InvalidUsernameException();
    }

    /**
     * Returns username of this salesman.
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Returns the stores associated with this salesman.
     * @return customers
     */
    public ArrayList<Store> getCustomers(){
        return customers;
    }

    /**
     * Adds a store to the customer list of this salesman.
     * @param store
     */
    public void addCustomer(Store store){
        customers.add(store);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salesman)) return false;
        Salesman salesman = (Salesman) o;
        return username.equals(salesman.username) && Objects.equals(customers, salesman.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, customers);
    }

    /**
     * Creates a new order for a specified store
     * @param store
     * @return order
     */
    public Order createOrder(Store store){
        return new Order(store, this, new HashMap<Product,Integer>());
    }
}
