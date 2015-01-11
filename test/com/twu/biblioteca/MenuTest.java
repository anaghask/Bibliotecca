package com.twu.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;

public class MenuTest{
    private final ArrayList<Book> listOfBook = new ArrayList<Book>();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    PrintStream printStream;
    Scanner scanner = new Scanner(System.in);

    @Before
    public void setPrintStream() {
        printStream = new PrintStream(byteArrayOutputStream);

    }

    @After
    public void deletePrintStream() {
        printStream = null;
        byteArrayOutputStream = null;
    }

    @Test
    public void shouldReturnProperMenu(){
        Menu menu = Menu.getMenu(1);
        assertEquals(menu , Menu.DISPLAY);
    }

    @Test
    public void shouldDisplayBookList(){
        Menu menu = Menu.getMenu(1);

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

        assertTrue(menu.executeMenu(printStream, scanner, bookList));
        assertEquals(expectedOutput.toString(),byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToDisplayInvalidInputOnWrongSelection() {
        Menu menu = Menu.getMenu(-1);

        String expectedOutput = "Invalid Option\n";

        assertTrue(menu.executeMenu(printStream, scanner, listOfBook));
        assertEquals(expectedOutput, byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToQuitOnOptionSelection()  {
        Menu menu = Menu.getMenu(4);

        assertFalse(menu.executeMenu(printStream , scanner , listOfBook));
    }

    @Test
    public void shouldBeAbleToCheckoutBookOnValid()  {
        Menu menu = Menu.getMenu(2);

        String inputForMenu ="Harry Potter\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Book> bookList = new ArrayList<Book>();

        scanner = new Scanner(byteArrayInputStream);
        bookList.add(book1);
        bookList.add(book2);
        StringBuilder expectedOutput = new StringBuilder("");

        expectedOutput.append("Enter book name for checkout\nThank you! Enjoy the book\n");

        assertTrue(menu.executeMenu(printStream , scanner ,bookList));
        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookOnInvalidInput()  {
        Menu menu = Menu.getMenu(2);

        String inputForMenu ="Harry\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Book> bookList = new ArrayList<Book>();

        scanner = new Scanner(byteArrayInputStream);

        bookList.add(book1);
        bookList.add(book2);
        StringBuilder expectedOutput = new StringBuilder("");

        expectedOutput.append("Enter book name for checkout\nThat book is not available.\n");

        assertTrue(menu.executeMenu(printStream, scanner, bookList));
        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToReturnBookOnValidInput()  {
        Menu menu = Menu.getMenu(3);

        String inputForMenu ="Harry Potter\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());
        Book book1 = new Book("J K Rowling","Harry Potter",1992, true);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Book> bookList = new ArrayList<Book>();

        scanner = new Scanner(byteArrayInputStream);

        bookList.add(book1);
        bookList.add(book2);
        StringBuilder expectedOutput = new StringBuilder("");

        expectedOutput.append("Enter book name for return\nThank you for returning the book\n");

        menu.executeMenu(printStream, scanner, bookList);
        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

}