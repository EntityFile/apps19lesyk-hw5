package ua.edu.ucu.stream;

import ua.edu.ucu.stream.*;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author andrii
 */
public class AsIntStreamTest {

    private IntStream intStream;
    private IntStream emptyStream;

    @Before
    public void init() {
        int[] intArr = {-5, -2, 0, 1, 11};
        int[] emptyArr = {};
        intStream = AsIntStream.of(intArr);
        emptyStream = AsIntStream.of(emptyArr);
    }

    @Test
    public void testAverage() {
        double expectedAverageInt = 1;

        double actualAverageInt = intStream.average();

        assertEquals(expectedAverageInt, actualAverageInt, 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void testAverageEmpty() {
        double actualAverageEmpty = emptyStream.average();
    }

    @Test
    public void testMin() {
        int expectedMinInt = -5;

        int actualMinInt = intStream.min();

        assertEquals(expectedMinInt, actualMinInt, 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void testMinEmpty() {
        int actualMinEmpty = emptyStream.min();
    }

    @Test
    public void testMax() {
        int expectedMaxInt = 11;

        int actualMaxInt = intStream.max();

        assertEquals(expectedMaxInt, actualMaxInt, 0.0001);
    }

    @Test(expected = NullPointerException.class)
    public void testMaxEmpty() {
        int actualMaxEmpty = emptyStream.max();
    }

    @Test
    public void testCount() {
        long expectedCountInt = 5;
        long expectedCountEmpty = 0;

        double actualCountInt = intStream.count();
        double actualCountEmpty = emptyStream.count();

        assertEquals(expectedCountInt, actualCountInt, 0.0001);
        assertEquals(expectedCountEmpty, actualCountEmpty, 0.0001);
    }

    @Test
    public void testSum() {
        int expectedSumInt = 5;
        int expectedSumEmpty = 0;

        int actualSumInt = intStream.sum();
        int actualSumEmpty = emptyStream.sum();

        assertEquals(expectedSumInt, actualSumInt, 0.0001);
        assertEquals(expectedSumEmpty, actualSumEmpty, 0.0001);
    }

    @Test
    public void testToArray() {
        int[] expectedArrayInt = {-5, -2, 0, 1, 11};
        int[] expectedArrayEmpty = {};

        int[] actualArrayInt = intStream.toArray();
        int[] actualArrayEmpty = emptyStream.toArray();

        assertArrayEquals(expectedArrayInt, actualArrayInt);
        assertArrayEquals(expectedArrayEmpty, actualArrayEmpty);
    }
}
