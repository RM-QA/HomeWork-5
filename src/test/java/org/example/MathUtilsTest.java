package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MathUtilsTest {

    @Test
    void testAddPositiveIntegers() {
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(4, 1);
        Assertions.assertEquals(5, sum);
    }


    @Test
    void testAddPositiveNumberToZero() {
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(5, 0);
        Assertions.assertEquals(5, sum);
    }

    @Test
    void testAddPositiveNumberToNegativeNumber() {
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(5, -6);
        Assertions.assertEquals(-1, sum);
    }

    @Test
    void testAddMaxInt() {
        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(Integer.MAX_VALUE, 1);
        Assertions.assertEquals(Integer.MIN_VALUE, sum);
    }

    @Test
    void testFirstArgumentIsLarger() {
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(6, 4);
        Assertions.assertTrue(bigger);
    }

    @Test
    void testSecondArgumentIsLarger() {
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(6, 9);
        Assertions.assertFalse(bigger);
    }

    @Test
    void testBothArgumentsAreEqual() {
        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(5, 5);
        Assertions.assertFalse(bigger);
    }
}
