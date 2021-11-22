import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * A singleton representing the inventory of the warehouse
 */
public class Inventory {
    private HashMap<Product, Integer> stock = new HashMap<Product, Integer>();
    private ArrayList<Order> orders = new ArrayList<Order>();
    private static Inventory inventory;

    /**
     * Get the instance of the inventory, or create a new one if one doesn't exist
     * @return The inventory
     */
    public static Inventory getInstance(){
        if (inventory == null)
            inventory = new Inventory();
        return inventory;
    }

    /**
     * Adds qty amount of the product p to this inventory
     * @param p The product to be added
     * @param qty The amount of times the product should be added
     */
    public void addItem(Product p, Integer qty) throws InvalidParameterException {
        if (qty < 0) throw new InvalidParameterException();
        if (stock.containsKey(p)) {
            stock.put(p, stock.get(p) + qty);
        } else {
            stock.put(p, qty);
        }
    }

    /**
     * Deletes all instnances of product p from this inventory
     * @param p the product to be deleted
     * @throws NoSuchElementException If no element in this inventory matches p
     */
    public void deleteItem(Product p) throws NoSuchElementException, TooFewProductsException{
        if (!stock.containsKey(p)){
            throw new NoSuchElementException("The product " + p.getName() + "is not present in the inventory," +
                    "and can therefore not be deleted");
        }
        removeItem(p, stock.get(p));

    }

    /**
     * Removes i items of product p from the stock
     * @param p The product to be removed
     * @param qty The amount of items to be removed
     * @throws NoSuchElementException if p is not in stock
     * @throws TooFewProductsException if trying to remove more products than present in the inventory
     */
    public void removeItem(Product p, Integer qty)
            throws NoSuchElementException, TooFewProductsException{
        if (!stock.containsKey(p)) {
            throw new NoSuchElementException("The product " + p.getName() + " is not present in the inventory, " +
                    "and can therefore not be removed");
        } else if (this.stock.get(p) < qty) {
            throw new TooFewProductsException("Tried to remove " + qty + " of " + p.getName() + ", but the inventory " +
                    "only contains " + stock.get(p));
        } else {
            stock.remove(p, qty);
        }
        if (stock.get(p) == 0){
            stock.remove(p);
        }
    }

    /**
     * Checks whether a product is in stock
     * @param p the product to test
     * @return true if p is in stock
     */
    public boolean isInStock(Product p) throws NoSuchElementException{
        if (stock.containsKey(p)){
            return stock.get(p) > 0;
        } else{
            return false;
        }
    }

    /**
     *  Adds an order to the order list
     * @param o the order to be added
     */
    public void addOrder(Order o){
        orders.add(o);
    }

    /**
     * Delete an existing order
     * @param o Order to delete
     * @throws NoSuchElementException If the order doesn't exist
     */
    public void deleteOrder(Order o) throws NoSuchElementException{
        if(!orders.contains(o)){
            throw new NoSuchElementException();
        }
        orders.remove(o);
    }

    /**
     * Returns a list of all products in stock
     * @return An arraylist of products
     */
    public HashMap<Product,Integer> getStock(){
        HashMap<Product,Integer> products = new HashMap<>();
        stock.forEach((k,v) -> {if(v != 0) products.put(k,v); });
        return products;
    }


}
