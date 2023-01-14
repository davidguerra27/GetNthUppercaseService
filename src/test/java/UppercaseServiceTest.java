import org.example.UppercaseService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UppercaseServiceTest {
    @Test
    public void testGetNthUppercaseCharacters() {
        UppercaseService service = new UppercaseService(1);
        assertEquals("ITCLNA", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(2);
        assertEquals("TLN", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(3);
        assertEquals("CNA", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(100);
        assertEquals("", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(-1);
        assertEquals("", service.getNthUppercaseCharacters("ITCLiNicAl"));
    }
}
