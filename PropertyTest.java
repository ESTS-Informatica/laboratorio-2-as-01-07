import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PropertyTest {

    @Test
    public void testConstructor() {
        Property property1 = new Property("T3 Monte Belo", 150000.0);
        assertEquals("T3 Monte Belo", property1.getDescription());
    }

    @Test
    public void testToString() {
        Property property1 = new Property("T3 Monte Belo", 150000.0);
        assertEquals("Descrição : T3 Monte Belo\nPreço     : 150000.0", property1.toString());
    }

}
