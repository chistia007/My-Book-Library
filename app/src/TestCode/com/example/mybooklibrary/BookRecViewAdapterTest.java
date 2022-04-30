package com.example.mybooklibrary;

import static org.junit.Assert.*;

import com.example.mybooklibrary.Controller.Book;
import com.example.mybooklibrary.Controller.BookRecViewAdapter;

import org.junit.Before;
import org.junit.Test;

public class BookRecViewAdapterTest {
    BookRecViewAdapter r;
    @Before
    public void setUp() throws Exception{
       r=new BookRecViewAdapter(null, null);
    }
    @Test
    public void testgetItemCount() {
        assertEquals(0, r.getItemCount());

    }
}