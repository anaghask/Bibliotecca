package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BibliotecaLibraryTest {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream;
    BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();

    @Before
    public void setPrintStream() {
        printStream = new PrintStream(byteArrayOutputStream);
    }

    @After
    public void deletePrintStream() {
        printStream = null;
    }

    @Test
    public void shouldShowWelcomeMessageOnStart() {
        bibliotecaLibrary.WelcomeMessage(printStream);
        assertEquals("Welcome", printStream.toString());
    }

}
