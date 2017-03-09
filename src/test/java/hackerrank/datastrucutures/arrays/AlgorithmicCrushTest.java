package hackerrank.datastrucutures.arrays;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static hackerrank.datastrucutures.arrays.AlgorithmicCrush.main;
import static org.junit.Assert.*;

public class AlgorithmicCrushTest extends AlgorithmicCrushTestData {
    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void mainTest() throws Exception {
        assertEquals("200", runMain(ARRAY1).toString().trim());
        assertEquals("882", runMain(ARRAY2).toString().trim());
        assertEquals("8628", runMain(ARRAY3).toString().trim());
    }

    private ByteArrayOutputStream runMain(String s) {
        ByteArrayInputStream in = new ByteArrayInputStream(s.getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main(new String[0]);
        return outContent;
    }

}