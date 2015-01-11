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
    public void shouldDisplayBookList(){

        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
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
        bibliotecaLibrary.bookList(printStream);

        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
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

    @Test
    public void shouldBeAbleToDisplayInvalidInputOnWrongSelection() {
        String inputForMenu ="10\n";
        InputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        bibliotecaLibrary.selectOption(byteArrayInputStream, printStream);
        String expectedOutput = menuString + "Invalid Option\n"+menuString;

        assertEquals(expectedOutput,byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToQuitOnOptionSelection()  {
        String inputForMenu ="3";
        InputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        bibliotecaLibrary.selectOption(byteArrayInputStream, printStream);

        assertEquals(menuString,byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToCheckoutBookOnOptionSelection()  {
        String inputForMenu ="2\nHarry Potter\n1";
        InputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(book1);
        bookList.add(book2);

        StringBuilder expectedOutput = new StringBuilder("");

        StringBuilder newLine = new StringBuilder("\n");

        bibliotecaLibrary = new BibliotecaLibrary(bookList);
        bibliotecaLibrary.selectOption(byteArrayInputStream, printStream);

        expectedOutput.append(menuString+"Enter book name for checkout\n");
        expectedOutput.append(menuString+"Author\t\tBook Name\t\tYear Of Publication\n"+"Dan Brown\tAngels and Demons\t1245\n"+menuString);
        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }



}
