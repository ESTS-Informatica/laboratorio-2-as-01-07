import static org.junit.Assert.assertEquals;

public class PropertyTest {

    @Test
    void testConstructor() {
        Property property1 = new Property("T3 Monte Belo", 150000.0);
        assertEquals("T3 Monte Belo", property1.getDescription());
    }

}
