import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ReverseTest {
    private Reverse reverse;

    @Before
    public void beforeTest() {
        reverse = new Reverse();
    }

    @Test(expected = IOException.class)
    public void testReadFile_forIOExceptions() throws IOException {
        reverse.readFile("xyz.txt");
    }

    @Test
    public void testReadFile_forCorrectInput() throws IOException {
        List<String> expectedResult = getResultOfReadFile();
        List<String> actualResult = reverse.readFile("sample.txt");
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse() {
        String expectedResult = getResultOfReverse();
        String actualResult = reverse.reverse(getResultOfReadFile());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse_forArrayListWithSingleValue() {
        String expectedResult = getResultOfReverse_forSingleValue();
        String actualResult = reverse.reverse(getResultOfReadFile_forSingleValue());
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testReverse_forEmptyArrayListWithNoValue() {
        String actualResult = reverse.reverse(new ArrayList<String>());
        assertEquals("", actualResult);
    }

    private String getResultOfReverse() {
        return "7,5,3,1\n67,565,23,65,234\n7,67,45,-345\n";
    }

    private String getResultOfReverse_forSingleValue() {
        return "9\n";
    }

    private List<String> getResultOfReadFile() {
        return new ArrayList<String>(){{
            add("1,3,5,7");
            add("234,65,23,565,67");
            add("-345,45,67,7");
        }};
    }

    private List<String> getResultOfReadFile_forSingleValue() {
        return new ArrayList<String>(){{
            add("9");
        }};
    }
}
