package hackerrank.datastrucutures.arrays;

import org.junit.After;
import org.junit.Test;

import java.io.*;
import java.net.URL;
import java.util.Scanner;

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

        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("array4.txt");
        assert url != null;
        String path = url.getPath();
        System.setIn(new FileInputStream(new File(path)));
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        main(new String[0]);
        assertEquals("7542539201", outContent.toString().trim());
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