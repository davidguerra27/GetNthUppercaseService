import org.example.UppercaseService;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;


public class UppercaseServiceTest {
    @Test
    public void testGetNthUppercaseCharacters() {


        //INSTANTIATE THE NEEDED COMPONENTS
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        UppercaseService service = new UppercaseService(1);
        //REDIRECT STANDARD OUTPUTSTREAM INTO A OUTPUT BYTE ARRAY
        //SET THE OUTPUT STREAM INTO MY STREAM
        System.setOut(printStream);

        //CALL THE METHOD BEING TESTED
        service.getNthUppercaseCharacters("It!#INi#A#");

        //RESET THE OUTPUT STREAM
        System.setOut(System.out);

        //COLLECT THE OUTPUT IN A STRING
        String output = byteArrayOutputStream.toString();

        //ASSERT THE PRINT COUNT OUT EQUALITY USING REPLACE ALL \r\n TO MAKE IT AN EASIER FORMAT
        assertEquals("I = 2 ! = 1 # = 3 N = 1 A = 1 ", output.replaceAll("\r\n"," "));
        //ASSERT THE RETURN EQUALITY USING REPLACE ALL \r\n TO MAKE IT AN EASIER FORMAT
        assertEquals("I!#IN#A#", service.getNthUppercaseCharacters("It!#INi#A#"));


        //REPEAT THE WHOLE PROCESS FOR A NEW BATCH OF TESTS
        byteArrayOutputStream = new ByteArrayOutputStream();
        printStream = new PrintStream(byteArrayOutputStream);
        service = new UppercaseService(2);

        System.setOut(printStream);

        service.getNthUppercaseCharacters("ITCLiNicAl");

        System.setOut(System.out);

        output = byteArrayOutputStream.toString();

        assertEquals("T = 1 L = 1 N = 1 ", output.replaceAll("\r\n"," "));
        assertEquals("TLN", service.getNthUppercaseCharacters("ITCLiNicAl"));

        //REPEAT THE WHOLE PROCESS FOR A NEW BATCH OF TESTS
        service = new UppercaseService(3);
        assertEquals("CNA", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(100);
        assertEquals("", service.getNthUppercaseCharacters("ITCLiNicAl"));

        service = new UppercaseService(-1);
        assertEquals("", service.getNthUppercaseCharacters("ITCLiNicAl"));
    }
}
