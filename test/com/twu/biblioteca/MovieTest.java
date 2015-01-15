package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    @Test
    public void shouldGetBookInformation(){
        assertEquals("Harry Potter\t1992\tRandom\t6.1\n", new Movie("Harry Potter",1992,"Random",6.1,false).toString());
    }

    @Test
    public void shouldReturnHeaderForMovie(){
        assertEquals("Movie Name\t\tYear Of Publication\t\tDirector Name\t\t Movie Rating",new Movie("Harry Potter",1992,"Random",6.1,false).returnHeader());
    }



}
