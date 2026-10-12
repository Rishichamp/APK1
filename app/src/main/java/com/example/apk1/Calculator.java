package com.example.apk1;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Square, cube, square root and cube root of one number.
 * Kept free of Android types so it can be unit-tested, and it never throws:
 * every bad input comes back as a message to show the user.
 */
final class Calculator {

    // Positions in the R.array.Operators spinner.
    static final int SQUARE = 0;
    static final int CUBE = 1;
    static final int SQUARE_ROOT = 2;
    static final int CUBE_ROOT = 3;

    private Calculator() {
    }

    static String calculate(String input, int operation) {
        String text = input.trim();
        if (text.isEmpty()) {
            return "Number field can't be empty";
        }
        double a;
        try {
            a = Double.parseDouble(text);
        } catch (NumberFormatException e) {
            // e.g. a lone "." which the decimal keyboard allows
            return "Error! Please enter a valid number";
        }
        double r;
        switch (operation) {
            case SQUARE:
                r = a * a;
                break;
            case CUBE:
                r = a * a * a;
                break;
            case SQUARE_ROOT:
                if (a < 0) {
                    return "Error! A negative number has no real square root";
                }
                r = Math.sqrt(a);
                break;
            case CUBE_ROOT:
                r = Math.cbrt(a);
                break;
            default:
                return "Error! Unknown operation";
        }
        if (Double.isInfinite(r) || Double.isNaN(r)) {
            return "Error! The result is too large";
        }
        // BigDecimal avoids "-0.00" and scientific notation for large results.
        return "Answer=" + BigDecimal.valueOf(r).setScale(2, RoundingMode.HALF_UP).toPlainString();
    }
}
