package org.example;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ItemListImplTest {

    private final ItemListImpl oun = new ItemListImpl(5) {
    };

    @BeforeEach
    public void setUp() {
        oun.add("one");
        oun.add("two");
        oun.add("three");
        oun.add("four");
        oun.add("five");
    }

    @Test
    void add_test() {
        int size = oun.size();
        assertEquals("six", oun.add("six"));
        assertEquals(size + 1, oun.size());
    }

    @Test
    void testAdd() {
        int size = oun.size();
        int index = 1;
        assertEquals("six", oun.add(index, "six"));
        assertEquals(index, oun.indexOf("six"));
        assertEquals(size + 1, oun.size());
    }

    @Test
    void set() {
        int size = oun.size();
        int index = 1;
        assertEquals("six", oun.set(index,"six"));
        assertEquals(index, oun.indexOf("six"));
        assertEquals(size,oun.size());
    }

    @Test
    void remove() {
        int size = oun.size();
        assertEquals("one", oun.remove("one"));
        assertEquals(size - 1, oun.size());
    }

    @Test
    void testRemove() {
        int size = oun.size();
        assertEquals("one", oun.remove(0));
        assertEquals(size - 1, oun.size());
    }

    public static Stream<Arguments> argumentsForContains() {
        return Stream.of(Arguments.of("one",0),
                Arguments.of("two",1),
                Arguments.of("three",2));
    }

    @ParameterizedTest
    @MethodSource("argumentsForContains")
    void indexOf(String item, int index) {
        assertEquals(index,oun.indexOf(item));
    }

    @ParameterizedTest
    @MethodSource("argumentsForContains")
    void get(String item, int index) {
        assertEquals(item,oun.get(index));
    }

    @Test
    void testEquals() {
        ItemListImpl test = new ItemListImpl(5);
        test.add("one");
        test.add("two");
        test.add("three");
        test.add("four");
        test.add("five");
        assertTrue(oun.equals(test));
    }

    @Test
    void size() {
    }

    @Test
    void isEmpty() {
        ItemListImpl test = new ItemListImpl(3);
        assertTrue(test.isEmpty());
    }

    @Test
    void toArray() {
        String[] test = {"one", "two", "three", "four", "five"};
        assertArrayEquals(test, oun.toArray());
    }
}