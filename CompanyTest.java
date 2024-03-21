import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
    private Company company;

    private User client1, client2, seller1, seller2;

    private ArrayList<User> clients;
    private ArrayList<User> sellers;

    private Property property1, property2;

    private Sell sell1, sell2;

    private ArrayList<Sell> sells;

    @Before
    public void setUp() {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");

        clients = new ArrayList<>();

        company.registerClient(client1);
        company.registerClient(client2);

        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.com");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.com");

        sellers = new ArrayList<>();

        company.registerSeller(seller1);
        company.registerSeller(seller2);

        property1 = new Property("T3 Monte Belo", 150000.0);
        property2 = new Property("T1 Amadora", 50000.0);

        company.registerProperty(property1);
        company.registerProperty(property2);

        sell1 = new Sell(client1, seller1, property1);
        sell2 = new Sell(client2, seller2, property2);

        company.registerSell(sell1);
        company.registerSell(sell2);

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

    @Test
    public void testCreateSell() {
        User client3 = new User("Maria Silva", "933333333", "maria@gmail.com");
        User seller3 = new User("Manuel Santos", "977777777", "manuel@gmail.com");
        Property property3 = new Property("T2 Campo Grande", 120000.0);

        assertTrue(company.createSell(client3, seller3, property3));
    }

    @Test
    public void testCalculateSellsOfTheYear() {
        int year = LocalDate.now().getYear();
        assertEquals(2, company.calculateSellsOfTheYear(year));
    }

    @Test
    public void testFindSellerOfTheYear() {
        int year = LocalDate.now().getYear();
        assertEquals("Fernando Fernandes", company.findSellerOfTheYear(year));
    }

}
