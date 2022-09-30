package com.example.mybooklibrary;

import static org.junit.Assert.*;

import com.example.mybooklibrary.Controller.Book;

import org.junit.Before;
import org.junit.Test;

public class BookTest {

    Book b;
    @Before
    public void setUp() throws Exception{
        System.out.print("setup");
        b=new Book(1, "The Big Bang Theory","Jessica Radloff",1000,"aa.png" , "Short desc", "Long desc");

    }

    @Test
    public void testGetId() {
        assertEquals(1, b.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("The Big Bang Theory", b.getName());
    }

    @Test
    public void testGetAuthor() {
        assertEquals("Jessica Radloff", b.getAuthor());
    }

    @Test
    public void testGetPages() {
        assertEquals(1000, b.getPages());
    }

    @Test
    public void testGetImageUrl() {
        assertEquals("aa.png", b.getImageUrl());
    }

    @Test
    public void testGetShortDesc() {
        assertEquals("Short desc", b.getShortDesc());
    }

    @Test
    public void testGetLongDesc() {
        assertEquals("Long desc", b.getLongDesc());
    }
}