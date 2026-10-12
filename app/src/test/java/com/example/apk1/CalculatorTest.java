package com.example.apk1;

import static com.example.apk1.Calculator.CUBE;
import static com.example.apk1.Calculator.CUBE_ROOT;
import static com.example.apk1.Calculator.SQUARE;
import static com.example.apk1.Calculator.SQUARE_ROOT;
import static com.example.apk1.Calculator.calculate;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void powers() {
        assertEquals("Answer=6.25", calculate("2.5", SQUARE));
        assertEquals("Answer=27.00", calculate("3", CUBE));
    }

    @Test
    public void roots() {
        assertEquals("Answer=1.41", calculate("2", SQUARE_ROOT));
        assertEquals("Answer=3.00", calculate("27", CUBE_ROOT));
        assertEquals("Answer=-2.00", calculate("-8", CUBE_ROOT));
    }

    @Test
    public void negativeSquareRootIsAnError() {
        assertEquals("Error! A negative number has no real square root", calculate("-4", SQUARE_ROOT));
    }

    @Test
    public void badInputIsAnErrorNotACrash() {
        assertEquals("Number field can't be empty", calculate("", SQUARE));
        assertEquals("Error! Please enter a valid number", calculate(".", SQUARE));
        assertEquals("Error! The result is too large", calculate("1e200", CUBE));
    }
}
