package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaLibraryTest {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream;
    private BibliotecaLibrary bibliotecaLibrary;

    @Before
    public void setPrintStream() {
        printStream = new PrintStream(byteArrayOutputStream);
        bibliotecaLibrary = new BibliotecaLibrary(new ArrayList<StringBuilder>());

    }

    @After
    public void deletePrintStream() {
        printStream = null;
    }

    @Test
    public void shouldShowWelcomeMessageOnStart() {
        bibliotecaLibrary.WelcomeMessage(printStream);
        assertEquals("Welcome", byteArrayOutputStream.toString().trim());
    }

    @Test
    public void shouldDisplayBookList(){
        StringBuilder book1 = new StringBuilder("Harry Potter");
        StringBuilder book2 = new StringBuilder("Angels and Demons");
        ArrayList<StringBuilder> bookList = new ArrayList<StringBuilder>();

        bookList.add(book1);
        bookList.add(book2);

        StringBuilder newLine = new StringBuilder("\n");
        StringBuilder expectedOutput = new StringBuilder();

        for (StringBuilder book : bookList) {
            expectedOutput.append(book);
            expectedOutput.append(newLine);
        }

        bibliotecaLibrary = new BibliotecaLibrary(bookList);
        bibliotecaLibrary.BookList(printStream);

        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

}
