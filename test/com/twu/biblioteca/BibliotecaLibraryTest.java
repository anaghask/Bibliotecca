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
        bibliotecaLibrary.WelcomeMessage(printStream);
        assertEquals("Welcome", byteArrayOutputStream.toString().trim());
    }

    @Test
    public void shouldDisplayBookList(){

        Book book1 = new Book("J K Rowling","Harry Potter",1992);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245);
        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(book1);
        bookList.add(book2);

        StringBuilder newLine = new StringBuilder("\n");
        StringBuilder expectedOutput = new StringBuilder("Author\t\tBook Name\t\tYear Of Publication\n");

        for (Book book : bookList) {
            expectedOutput.append(book.toString());
            expectedOutput.append(newLine);
        }

        bibliotecaLibrary = new BibliotecaLibrary(bookList);
        bibliotecaLibrary.BookList(printStream);

        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayMenu(){
        bibliotecaLibrary.MenuList(printStream);
        String expectedOutput = "Menu\n1:Display\n2:Quit\n";
        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToSelectFromMenu() throws IOException {
        String inputForMenu ="1";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        bibliotecaLibrary.SelectOption(byteArrayInputStream,printStream);
        String expectedOutput = "Menu\n1:Display\n2:Quit\n";
        expectedOutput+="Author\t\tBook Name\t\tYear Of Publication\n";

        assertEquals(expectedOutput, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToDisplayInvalidInputOnWrongSelection() throws IOException {
        String inputForMenu ="3";
        InputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        bibliotecaLibrary.SelectOption(byteArrayInputStream,printStream);
    }



}
