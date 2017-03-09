package hackerrank.datastrucutures.arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static hackerrank.datastrucutures.arrays.ArraysDS.main;
import static org.junit.Assert.*;

public class ArraysDSTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
        System.setIn(System.in);
        System.setOut(System.out);
    }

    @Test
    public void mainTest() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream("4\n1 4 3 2\n\n".getBytes());
        System.setIn(in);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main(new String[0]);
        assertEquals("2 3 4 1\n", outContent.toString());
    }
}