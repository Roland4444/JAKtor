import se.roland.impl.JAktor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AktorTest {

    @Test
    public void getPortFromURL() {
        JAktor la2=new JAktor();
        la2.setAddress("http://127.0.0.1:5555/");
        assertEquals(5555, la2.getPortFromURL(la2.Address));
    }
}