
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.List;

/**
 * Manage a company.
 *
 * @author POO
 * @version 03/2024
 */
public class Company {

    // Clients registry
    private ArrayList<User> clients;
    // Sellers registry
    private ArrayList<User> sellers;
    // Properties registry
    private ArrayList<Property> properties;
    // Sells registry
    private ArrayList<Sell> sells;

    /**
     * Constructor of class Company
     */
    public Company() {
        this.clients = new ArrayList<>();
        this.sellers = new ArrayList<>();
        this.properties = new ArrayList<>();
        this.sells = new ArrayList<>();
    }

    /**
     * Get the list of clients.
     *
     * @return This company clients.
     */
    public List<User> getClients() {
        return clients;
    }

    /**
     * Get the list of sellers.
     *
     * @return This company sellers.
     */
    public List<User> getSellers() {
        return sellers;
    }

    /**
     * Get the list of properties.
     *
     * @return This company's properties.
     */
    public List<Property> getProperties() {
        return properties;
    }

    /**
     * Get the list of sells.
     *
     * @return This company sells.
     */
    public List<Sell> getSells() {
        return sells;
    }

    /**
     * Register a client.
     *
     * @param client to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerClient(User client) {
        if (client != null && !clients.contains(client)) {
            clients.add(client);
            return true;
        }
        return false;
    }

    /**
     * Register a seller.
     *
     * @param seller to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSeller(User seller) {
        if (seller != null && !sellers.contains(seller)) {
            sellers.add(seller);
            return true;
        }
        return false;
    }

    /**
     * Register a property.
     *
     * @param property to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerProperty(Property property) {
        if (property != null && !properties.contains(property)) {
            properties.add(property);
            return true;
        }
        return false;
    }

    /**
     * Register a sell.
     *
     * @param sell to register. Must not be null. Must not be registered.
     * @return true If the registration succeeds, false otherwise.
     */
    public boolean registerSell(Sell sell) {
        if (sell != null && !sells.contains(sell)) {
            sells.add(sell);
            return true;
        }
        return false;
    }

    /**
     * Generate a new sell and register that sell.
     *
     * @param client Must be already registered.
     * @param seller Must be already registered.
     * @param property Must be already registered.
     * @return true If the request succeeds, false otherwise.
     */
    public boolean createSell(User client, User seller, Property property) {
        if (client != null && seller != null && property != null) {
            Sell newSell = new Sell(client, seller, property);
            sells.add(newSell);
            return true;
        }
        return false;
    }

    /**
     * Calculates the total number of sells within the provided year.
     *
     * @param year
     * @return The total number of sells in the year.
     */
    public int calculateSellsOfTheYear(int year) {
        int count = 0;
        for (Sell sell : sells) {
            if (sell.getDate().getYear() == year) {
                count++;
            }
        }
        return count;
    }

    /**
     * Find the seller with more sells within the provided year.
     *
     * @param year
     * @return The name of the seller of the year.
     */
    public String findSellerOfTheYear(int year) {
        int maxSells = 0;
        String sellerOfTheYear = null;
        for (User seller : sellers) {
            int sellsCount = 0;
            for (Sell sell : sells) {
                if (sell.getSeller().equals(seller) && sell.getDate().getYear() == year) {
                    sellsCount++;
                }
            }
            if (sellsCount > maxSells) {
                maxSells = sellsCount;
                sellerOfTheYear = seller.getName();
            }
        }
        return sellerOfTheYear;
    }

}
