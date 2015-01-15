package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest {
    String [] headerList = new String[]{"Author","Book Name","Year Of Publication"};
    @Test
    public void shouldReturnHeaderForBooks() {
        assertEquals(headerList, new Book("J K", "Harry Potter", 1992, false).returnHeader());
    }


}