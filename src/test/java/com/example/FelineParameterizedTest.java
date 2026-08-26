package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineParameterizedTest {

    private final int kittensCount;
    private final int expected;

    public FelineParameterizedTest(int kittensCount, int expected) {
        this.kittensCount = kittensCount;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getKittensData() {
        return new Object[][]{
                {5, 5} // достаточно одного набора
        };
    }

    @Test
    public void testGetKittensWithCount() {
        Feline feline = new Feline();
        assertEquals(expected, feline.getKittens(kittensCount));
    }
}