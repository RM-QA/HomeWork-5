package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SolverTest {

    Solver solver;

    @BeforeEach
    void beforeEach() {
        solver = new Solver();
    }

    @Test
    void noRoots() {
        int result = solver.solve(1, 1, 3);
        Assertions.assertEquals(0, result);
    }

    @Test
    void oneRoot() {
        int result = solver.solve(1, 4, 4);
        Assertions.assertEquals(1, result);
    }

    @Test
    void twoRoots() {
        int result = solver.solve(1, 20, 3);
        Assertions.assertEquals(2, result);
    }

    @ParameterizedTest
    @CsvSource({"1 ,1 ,3 ,0 ", "1, 4, 4, 1", "1, 20, 3, 2"})
    void testRootsNumbers(int a, int b, int c, int expected) {
        int result = solver.solve(a, b, c);
        Assertions.assertEquals(expected, result);
    }
}
