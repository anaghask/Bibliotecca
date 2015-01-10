package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BookTest{
    @Test
    public void shouldGetBookInformation(){
        String expected ="J K\tHarry Potter\t1992";
        assertEquals(expected , new Book("J K","Harry Potter",1992).toString());
    }


    @Test
    public void shouldCheckForEqualityOfBookIfNameIsSame(){
        assertTrue(new Book("J K", "Harry Potter", 1992).equals(new Book("J K", "Harry Potter", 2004)));
    }

    @Test
    public void shouldCheckForInequalityOfBookIfNameIsDifferent(){
        assertFalse(new Book("J K", "Harry Potter", 1992).equals(new Book("J K", "Harry", 2004)));
    }


}