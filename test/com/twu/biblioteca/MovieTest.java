package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MovieTest {

    String[] headerList= new String[]{"Movie Name","Year Of Release","Director Name","Movie Rating"};

    @Test
    public void shouldReturnHeaderForMovie() {
        assertEquals(headerList, new Movie("Harry Potter", 1992, "Random", 6.1, false).returnHeader());
    }


}
