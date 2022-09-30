package com.example.mybooklibrary;

import static org.junit.Assert.*;

import com.example.mybooklibrary.Controller.Book;
import com.example.mybooklibrary.model.Utils;

import org.junit.Before;
import org.junit.Test;

public class UtilsTest {
    Utils u;
    Book b;
    @Before
    public void setUp() throws Exception{
        System.out.print("setup");
        b=new Book(1, "The Big Bang Theory","Jessica Radloff",1000,"aa.png" , "Short desc", "Long desc");
        u=new Utils();
    }
    @Test
    public void testAddToAlreadyRead() {
        assertTrue(u.addToAlreadyRead(b));
    }

    @Test
    public void testAddTWantToRead() {
        assertTrue(u.addTWantToRead(b));
    }

    @Test
    public void testAddToFavorite() {
        assertTrue(u.addToFavorite(b));
    }

    @Test
    public void testAddToCurrentlyReadingBooks() {
        assertTrue(u.addToCurrentlyReadingBooks(b));
    }

    @Test
    public void testRemoveFromAlreadyRead() {
        assertTrue(u.removeFromAlreadyRead(b));
    }

    @Test
    public void testRemoveFromWantToRead() {
        assertTrue(u.removeFromWantToRead(b));
    }

    @Test
    public void testRemoveFromFavoriteBook() {
        assertTrue(u.removeFromFavoriteBook(b));
    }

    @Test
    public void testRemoveFromCurrentlyReading() {
        assertTrue(u.removeFromCurrentlyReading(b));
    }
}