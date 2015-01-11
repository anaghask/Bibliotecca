package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaLibraryTest {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream;
    private BibliotecaLibrary bibliotecaLibrary;
    private String menuString = "1:Display\n2:CheckOut Book\n3:Quit\n";

    @Before
    public void setPrintStream() {
        printStream = new PrintStream(byteArrayOutputStream);
        bibliotecaLibrary = new BibliotecaLibrary(new ArrayList<Book>());
    }

    @After
    public void deletePrintStream() {
        printStream = null;
        byteArrayOutputStream = null;
    }

    @Test
    public void shouldShowWelcomeMessageOnStart() {
        bibliotecaLibrary.welcomeMessage(printStream);
        assertEquals("Welcome", byteArrayOutputStream.toString().trim());
    }


    @Test
    public void shouldDisplayMenu(){
        bibliotecaLibrary.menuList(printStream);
        assertEquals(menuString, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToSelectFromMenu(){
        String inputForMenu ="1";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        bibliotecaLibrary.selectOption(byteArrayInputStream, printStream);
        String expectedOutput = menuString+"Author\t\tBook Name\t\tYear Of Publication\n"+menuString;

        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

}
