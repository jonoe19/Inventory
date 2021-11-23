import java.util.Objects;

public class Product {
    private String name;
    private int price;

    /**
     * Constructor for a product
     * @param name
     * @param price
     */
    public Product(String name, int price) throws InvalidNameException{
        if(isValidName(name)) {
            this.name = name;
            this.price = price;
        } else
            throw new InvalidNameException();
    }

    /**
     * Sets the price to the given value
     * @param price
     */
    public void setPrice(int price) {
        this.price = price;
    }

    /**
     * Getter for price
     * @return
     */
    public int getPrice() {
        return price;
    }

    /**
     * Getter for name
     * @return
     */
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return name.equals(product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Boolean isValidName(String name){
        return name != "";
    }
}
