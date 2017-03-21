package hackerrank.datastructures.arrays;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TwoDArrayDSTest {
    final String ARRAY1 =
            "1 1 1 0 0 0\n" +
            "0 1 0 0 0 0\n" +
            "1 1 1 0 0 0\n" +
            "0 0 2 4 4 0\n" +
            "0 0 0 2 0 0\n" +
            "0 0 1 2 4 0\n\n";
    final String ARRAY2 =
            "1 1 1 0 0 0\n" +
            "0 1 0 0 0 0\n" +
            "1 1 1 0 0 0\n" +
            "0 9 2 -4 -4 0\n" +
            "0 0 0 -2 0 0\n" +
            "0 0 -1 -2 -4 0";

    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void mainTest() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(ARRAY1.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        TwoDArrayDS.main(new String[0]);
        assertEquals("19", outContent.toString().trim());
        System.setIn(new ByteArrayInputStream(ARRAY2.getBytes()));
        outContent.reset();
        TwoDArrayDS.main(new String[0]);
        assertEquals("13", outContent.toString().trim());
    }
}