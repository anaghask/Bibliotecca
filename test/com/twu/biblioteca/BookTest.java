package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BookTest{
    @Test
    public void shouldGetBookInformation(){
        assertEquals("J K\tHarry Potter\t1992\n", new Book("J K","Harry Potter",1992, false).toString());
    }

    @Test
    public void shouldReturnHeaderForBooks(){
        assertEquals("Author\t\tBook Name\t\tYear Of Publication",new Book("J K","Harry Potter",1992, false).returnHeader());
    }


}