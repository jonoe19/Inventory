import java.util.Objects;

/**
 * Class representing an employee of type warehouse worker.
 */
public class WarehouseWorker extends Employee{

    /**
     * Attributes.
     */
    private String username;
    private Order workingOn;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseWorker)) return false;
        WarehouseWorker that = (WarehouseWorker) o;
        return username.equals(that.username) && Objects.equals(workingOn, that.workingOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, workingOn);
    }

    /**
     * Constructor.
     * @param username
     */
    public WarehouseWorker(String username) throws InvalidNameException{
        if(usernameValid(username)) {
            this.username = username;
            this.workingOn = null;
        }else
            throw new InvalidNameException();
    }

    /**
     * Returns the username of this warehouse worker.
     * @return username
     */
    @Override
    public String getUsername() {
        return username;
    }

    /**
     * Adds this order to this warehouse workers list of orders,
     * and sets the status of the specified order to "Processing"
     * @param order
     */
    public void beginOrder(Order order){
        this.workingOn = order;
        order.setOrderStatus("Processing");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WarehouseWorker)) return false;
        WarehouseWorker that = (WarehouseWorker) o;
        return username.equals(that.username) && Objects.equals(workingOn, that.workingOn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username, workingOn);
    }

}
