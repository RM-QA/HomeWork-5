package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class MathUtilsTest {

    MathUtils mathUtils;


    @BeforeEach
    void beforeEach() {
        mathUtils = new MathUtils();
    }

    @Test
    void testAddPositiveIntegers() {
//        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(4, 1);
        Assertions.assertEquals(5, sum);
    }


    @Test
    void testAddPositiveNumberToZero() {
//        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(5, 0);
        Assertions.assertEquals(5, sum);
    }

    @Test
    void testAddPositiveNumberToNegativeNumber() {
//        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(5, -6);
        Assertions.assertEquals(-1, sum);
    }

    @Test
    void testAddMaxInt() {
//        MathUtils mathUtils = new MathUtils();
        int sum = mathUtils.add(Integer.MAX_VALUE, 1);
        Assertions.assertEquals(Integer.MIN_VALUE, sum);
    }

    @Test
    void testFirstArgumentIsLarger() {
//        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(6, 4);
        Assertions.assertTrue(bigger);
    }

    @Test
    void testSecondArgumentIsLarger() {
//        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(6, 9);
        Assertions.assertFalse(bigger);
    }

    @Test
    void testBothArgumentsAreEqual() {
//        MathUtils mathUtils = new MathUtils();
        boolean bigger = mathUtils.bigger(5, 5);
        Assertions.assertFalse(bigger);
    }


    // homework 7

    @Test
    void floatingPointDivision() {
        float divide = mathUtils.divide(1.1f, 1.2f);
        Assertions.assertEquals(1, divide, 0.1);
    }

    @Test
    void floatingPointMultiply() {
        float multiply = mathUtils.multiply(1.1f, 1.2f);
        Assertions.assertEquals(1.3, multiply, 0.2);
    }


    @ValueSource(ints = {2})
    @ParameterizedTest
    void testSquare(int num) {
        int result = mathUtils.square(num);
        Assertions.assertEquals(4, result);
    }

    // homework 8

    @ParameterizedTest
    @CsvSource({"1 , 2 , 3", "2 , 4 , 6", "5 , 6 , 11"})
    void testAddIntegers(int a, int b, int expected) {
        int sum = mathUtils.add(a, b);
        Assertions.assertEquals(expected, sum);
    }

    @CsvFileSource(resources = "/testdata.csv")
    @ParameterizedTest
    void testMultiplyTwoFloats(float a, float b, float expected) {
        float result =  mathUtils.multiply(a, b);
        Assertions.assertEquals(expected, result);
    }

}
