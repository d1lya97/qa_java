package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    @Mock
    Feline feline;

    @Test
    public void testGetFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }

    @Test
    public void testGetKittens() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        Mockito.when(feline.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }

    @Test
    public void testDoesHaveManeMale() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeFemale() throws Exception {
        Lion lion = new Lion(feline, "Самка");
        assertTrue(!lion.doesHaveMane());
    }

    @Test
    public void testConstructorInvalidSex() {
        try {
            new Lion(feline, "Неверный пол");
            fail("Expected Exception was not thrown");
        } catch (Exception e) {
            assertEquals("Используйте допустимые значения пола животного - самец или самка", e.getMessage());
        }
    }
}