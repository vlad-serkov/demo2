package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void getFirst() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addBefore(2);
        integers.addBefore(4);
        integers.addBefore(5);
        integers.addBefore(6);
        integers.addBefore(10);
        integers.addBefore(10);
        integers.forEach(System.out::println);
    }

    @Test
    void getLast() {
        LinkedList<Integer> integers = new LinkedList<>();
        integers.addBefore(2);
        integers.addBefore(4);
        integers.addBefore(5);
        integers.addBefore(6);
        integers.addBefore(10);
        integers.addBefore(10);

        assertEquals(integers.get(0), 10);
        assertEquals(integers.get(2), 6);
        assertThrows(IndexOutOfBoundsException.class, () -> integers.get(12));
    }

    @Test
    void removeFirst() {
    }

    @Test
    void removeLast() {
    }

    @Test
    void addLast() {
    }

    @Test
    void addBefore() {
    }
}