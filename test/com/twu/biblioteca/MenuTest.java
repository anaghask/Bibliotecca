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
    private final ArrayList<Item> listOfBook = new ArrayList<Item>();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Scanner scanner;
    ArrayList<Item> bookList = new ArrayList<Item>();
    Library library = new Library(bookList);
    @Before
    public void setPrintStream() {
        System.setOut(new PrintStream(byteArrayOutputStream));

    }


    @After
    public void deletePrintStream() {
        byteArrayOutputStream.reset();
    }

    @Test
    public void shouldReturnProperMenu(){
        assertEquals(Menu.getMenu(1), Menu.DISPLAY);
    }

    private void addBook(){
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);

        bookList.add(book1);
        bookList.add(book2);
    }

    @Test
    public void shouldDisplayBookList(){

        addBook();

        StringBuilder newLine = new StringBuilder("\n");
        StringBuilder expectedOutput = new StringBuilder("Author\t\tBook Name\t\tYear Of Publication\n");

        for (Item book : bookList) {
            expectedOutput.append(book.toString());
            expectedOutput.append(newLine);
        }

        assertTrue(Menu.getMenu(1).executeMenu(scanner, library));
        assertEquals(expectedOutput.toString(),byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToDisplayInvalidInputOnWrongSelection() {

        String expectedOutput = "Invalid Option\n";

        assertEquals(true, Menu.getMenu(-1).executeMenu(scanner, library));
        assertEquals(expectedOutput, byteArrayOutputStream.toString());

    }

    @Test
    public void shouldBeAbleToQuitOnOptionSelection()  {

        assertFalse(Menu.getMenu(4).executeMenu(scanner, library));
    }

    @Test
    public void shouldBeAbleToCheckoutBookOnValid()  {
        bookList.add(new Book("J K","Harry",1234,false));

        String inputForMenu ="Harry\n";

        scanner = new Scanner(getByteArrayInputStream(inputForMenu));

        assertTrue(Menu.getMenu(2).executeMenu(scanner, library));
        assertEquals("" + "Enter book name for checkout\nThank you! Enjoy the book\n", byteArrayOutputStream.toString());
    }

    private ByteArrayInputStream getByteArrayInputStream(String inputForMenu) {
        return new ByteArrayInputStream(inputForMenu.getBytes());
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookOnInvalidInput()  {

        String inputForMenu ="Harry\n";

        scanner = new Scanner(getByteArrayInputStream(inputForMenu));

        assertTrue(Menu.getMenu(2).executeMenu(scanner, library));
        assertEquals("" + "Enter book name for checkout\nThat book is not available.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleToReturnBookOnValidInput()  {

        String inputForMenu ="Harry\n";

        bookList.add(new Book("J K","Harry",1234,true));
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));

        assertTrue(Menu.getMenu(3).executeMenu(scanner, library));
        assertEquals("" + "Enter book name for return\nThank you for returning the book\n", byteArrayOutputStream.toString());
    }


    @Test
    public void shouldNotBeAbleToReturnBookOnInValidInput()  {
        Menu menu = Menu.getMenu(3);

        String inputForMenu ="Harry \n";

        scanner = new Scanner(getByteArrayInputStream(inputForMenu));

        menu.executeMenu(scanner, library);
        assertEquals("" + "Enter book name for return\nThat is not a valid book to return.\n", byteArrayOutputStream.toString());
    }

}