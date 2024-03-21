import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class CompanyTest {
    private Company company;

    private User client1, client2, seller1, seller2;

    private List<User> clients;
    private List<User> sellers;

    @Before
    public void setUp() {
        company = new Company();
        client1 = new User("José Manuel", "911111111", "zemanel@yahoo.com");
        client2 = new User("António Francisco", "922222222", "tochico@hotmail.com");
        seller1 = new User("Fernando Fernandes", "966777101", "fefe@remax.com");
        seller2 = new User("Rodrigo Rodrigues", "966777152", "roro@remax.com");

        clients = new ArrayList<>();
        sellers = new ArrayList<>();

        clients.add(client1);
        clients.add(client2);

        sellers.add(seller1);
        sellers.add(seller2);
    }

    @Test
    public void testConstructor() {
        assertNotNull(company.getClients());
        assertNotNull(company.getSellers());
    }
}
