
/**
 * A property to sell.
 *
 * @author POO
 * @version 03/2024
 */
public class Property {

    private static int numberOfProperties = 0;
    private final int id;
    private String description;
    private double price;

    /**
     * Constructor of class Property
     *
     * @param description The property description.
     * @param price       The property price.
     */
    public Property(String description, double price) {
        this.description = description;
        this.price = price;
        this.id = -1;
    }

    /**
     * Id selector.
     */
    public int getId() {
        return id;
    }

    /**
     * Description selector.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Description modifier.
     * 
     * @param description The new description. Must not be null.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Price selector.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Price modifier.
     * 
     * @param price The new price. Must not be negative.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        String str = "Descrição : " + description;
        str += "\nPreço     : " + price;
        return str;
    }
}
