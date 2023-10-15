package org.example;

public class Solver {
    public int solve(int a, int b, int c) {
        float d = b * b - 4 * a * c;
        if (d < 0) {
            return 0;
        } else if (d == 0) {
            return 1;
        } else {
            return 2;
        }
    }
}
