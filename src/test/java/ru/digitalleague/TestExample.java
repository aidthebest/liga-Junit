package ru.digitalleague;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.digitalleague.storage_example.Storage;

import java.sql.SQLOutput;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TestExample {

    @Before
    public void setUp() {
        Storage.addObject("apple", 3);
        Storage.addObject("pear", 7);
    }

    @After
    public void setUp2() {
        Storage.removeObject("pear");
        Storage.removeObject("apple");
        Storage.removeObject("cucumber");
    }

    @Test
    public void stockTest1() {
        Storage.addObject("apple", 3);
        Storage.addObject("pear", 7);
        Storage.removeObject("pear");
        assertFalse(Storage.isInStock("pear"));
    }

    @Test
    public void stockTest2() {
        Storage.addObject("apple", 3);
        assertTrue(Storage.isInStock("apple"));
    }

    @Test
    public void getProductAmountTest1() {
        Storage.addObject("cucumber", 10);
        int actual = Storage.getProductAmount("cucumber");
        assertEquals(actual, 10);
    }

    @Test
    public void getProductAmountTest2() {
        Storage.addObject("cucumber", 11);
        assertFalse(Storage.isInStock("cucumber"));

    }

    @Test
    public void addObjectTest1() {
        Storage.addObject("cucumber", 7);
        assertTrue(Storage.isInStock("cucumber"));
        assertEquals(7, Storage.getProductAmount("cucumber"));
    }

    @Test
    public void addObjectTest2() {
        Storage.addObject("cucumber", -1);
        int count = Storage.getProductAmount("cucumber");
        assertEquals(0, count);
    }

    @Test
    public void removeObjectTest1() {
        Storage.removeObject("apple");
        assertFalse(Storage.isInStock("apple"));
    }

    @Test
    public void removeObjectTest2() {
        Storage.removeObject("apple");
        assertTrue(Storage.isInStock("pear"));
    }

    @Test
    public void getFreePlacesTest1 () {
        int count = Storage.getFreePlaces();
        assertEquals(1, count);
    }

    @Test
    public void getFreePlacesTest2 () {
        Storage.addObject("cucumber", 10);
        Storage.addObject("apple2", 1);
        int count = Storage.getFreePlaces();
        assertEquals(0, count);
    }

    @Test
    public void addToExistObjectTest1() {
        Storage.addObject("apple", 4);
        assertEquals(7, Storage.getProductAmount("apple"));
    }

    @Test
    public void addToExistObjectTest2() {
        Storage.addObject("apple", 11);
        assertEquals(3, Storage.getProductAmount("apple"));
    }
}