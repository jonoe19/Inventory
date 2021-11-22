import java.util.HashMap;
import java.util.NoSuchElementException;

public class Order {
    private static int firstAvailableID = 0;
    private int orderID;
    private HashMap<Product,Integer> orderedProducts;
    private Store store;
    private Salesman salesman;
    private String orderStatus;

    /**
     * Constructs a new order
     * @param store
     * @param salesman
     * @param orderedProducts
     */
    public Order(Store store, Salesman salesman, HashMap<Product,Integer> orderedProducts){
        store = this.store;
        salesman = this.salesman;
        orderedProducts = this.orderedProducts;
        orderStatus = "Pending";
        orderID = firstAvailableID;
        firstAvailableID++;

    }

    /**
     * Sets order status
     * @param orderStatus
     */
    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    /**
     * Gets order status
     * @return
     */
    public String getOrderStatus() {
        return orderStatus;
    }

    /**
     * Gets store
     * @return
     */
    public Store getStore() {
        return store;
    }

    /**
     * Gets salesman
     * @return
     */
    public Salesman getSalesman() {
        return salesman;
    }

    public int getOrderID(){
        return orderID;
    }

    /**
     * Gets a hashmap of the ordered products
     * @return
     */
    public HashMap<Product, Integer> getOrderedProducts() {
        return (HashMap<Product, Integer>) orderedProducts.clone();
    }

    /**
     * add a new product to this order
     * If the product is already in the map, it will replace it with an incremented value
     * @param product
     * @param amount
     */
    public void addProduct(Product product, int amount){
        if(orderedProducts.containsKey(product))
            orderedProducts.replace(product, orderedProducts.get(product) + amount);
        else
            orderedProducts.put(product,amount);
    }

    /**
     * Delete a product from this order
     * @param product
     * @throws NoSuchElementException If the product is not in the order
     */
    public void deleteProduct(Product product) throws NoSuchElementException {
        if(!orderedProducts.containsKey(product)) throw new NoSuchElementException();
        orderedProducts.remove(product);
    }

    //public void transferOrder(Int id, Salesman salesman);

}
