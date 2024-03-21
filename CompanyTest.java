import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
    private Company company;

    private User client1, client2, seller1, seller2;

    private ArrayList<User> clients;
    private ArrayList<User> sellers;

    private Property property1;

    private ArrayList<Property> properties;

    @Before
    public void setUp() {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.com");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.com");

        clients = new ArrayList<>();
        sellers = new ArrayList<>();

        company.registerClient(client1);
        company.registerClient(client2);
        company.registerSeller(seller1);
        company.registerSeller(seller2);

        property1 = new Property("T3 Monte Belo", 150000.0);
        sell1 = new Sell(client1, seller1, property1);

        company.registerProperty(property1);

    }

    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
    }

    @Test
    public void testRegisterClient() {
        assertTrue(company.registerClient(new User("Maria Silva", "933333333", "maria@gmail.com")));
    }

    @Test
    public void testRegisterClients() {
        assertTrue(company.registerClient(new User("Pedro Costa", "944444444", "pedro@hotmail.com")));
        assertTrue(company.registerClient(new User("Ana Santos", "955555555", "ana@yahoo.com")));
    }

    @Test
    public void testRegisterClientDuplicate() {
        assertFalse(company.registerClient(client1));
    }

    @Test
    public void testRegisterClientNull() {
        assertFalse(company.registerClient(null));
    }

    @Test
    public void testRegisterSeller() {
        assertTrue(company.registerSeller(new User("Manuel Santos", "977777777", "manuel@gmail.com")));
    }

    @Test
    public void testRegisterSellers() {
        assertTrue(company.registerSeller(new User("Rui Almeida", "988888888", "rui@hotmail.com")));
        assertTrue(company.registerSeller(new User("Marta Pereira", "999999999", "marta@yahoo.com")));
    }

    @Test
    public void testRegisterSellerDuplicate() {
        assertFalse(company.registerSeller(seller1));
    }

    @Test
    public void testRegisterSellerNull() {
        assertFalse(company.registerSeller(null));
    }

    @Test
    public void testRegisterProperty() {
        assertTrue(company.registerProperty(new Property("T2 Campo Grande", 120000.0)));
    }

    @Test
    public void testRegisterProperties() {
        assertTrue(company.registerProperty(new Property("T4 Alvalade", 200000.0)));
        assertTrue(company.registerProperty(new Property("T1 Chiado", 180000.0)));
    }

    @Test
    public void testRegisterPropertyDuplicate() {
        assertFalse(company.registerProperty(property1));
    }

    @Test
    public void testRegisterPropertyNull() {
        assertFalse(company.registerProperty(null));
    }

}
