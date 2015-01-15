package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class LibraryManagerTest {

    private final String loginMessage = "Enter Library Number:\n" + "Enter Password\n";
    private final String successfulBookCheckout = "Enter book name for checkout\nThank you! Enjoy the book\n";
    private final String successfulMovieCheckout = "Enter movie name for checkout\nThank you! Enjoy the movie\n";
    private final String unsuccessfulBookCheckOut = "Enter book name for checkout\nThat book is not available.\n";
    private final String unsuccessfulMovieCheckOut = "Enter movie name for checkout\nThat movie is not available.\n";
    private final String successfulBookReturn = "Enter book name for return\nThank you for returning the book\n";
    private final String successfulMovieReturn = "Enter movie name for return\nThank you for returning the movie\n";
    private final String unsuccessfulBookReturn = "Enter book name for return\nThat is not a valid book to return.\n";
    private final String unsuccessfulMovieReturn = "Enter movie name for return\nThat is not a valid movie to return.\n";
    private final String validUserName = "xyz-xazy\npass\n";
    Scanner scanner;
    Library booklibrary = new DummyBookLibrary();
    Library movielibrary = new DummyMovieLibrary();
    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private PrintStream out = new PrintStream(byteArrayOutputStream);
    private LibraryManager libraryManager = new LibraryManager(booklibrary, movielibrary, scanner, out);

    private void createLibraryManager(String inputForMenu) {
        scanner = new Scanner(new ByteArrayInputStream(inputForMenu.getBytes()));
        libraryManager = new LibraryManager(booklibrary, movielibrary, scanner, out);
    }

    @Test
    public void shouldCheckOutBookWhenBookIsAvailable() {
        String inputForMenu = validUserName + "valid checkout\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutBook();

        assertEquals(loginMessage + successfulBookCheckout, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldCheckOutMovieWhenMovieIsAvailable() {
        String inputForMenu = validUserName + "valid checkout\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutMovie();

        assertEquals(loginMessage + successfulMovieCheckout, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenBookIsAvailableButAlreadyCheckedOut() {
        String inputForMenu = validUserName + "invalid\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutBook();

        assertEquals(loginMessage + unsuccessfulBookCheckOut, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutMovieWhenCustomerIsInvalid() {
        String inputForMenu = "po\nghg\ninvalid\n";
        libraryManager = new LibraryManager(new DummyBookLibrary(), new Library(new ArrayList<Item>(), new ArrayList<Customer>()),
                new Scanner(new ByteArrayInputStream(inputForMenu.getBytes())), out);

        libraryManager.checkOutMovie();

        assertEquals(loginMessage + "Invalid Login\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenCustomerIsInvalid() {
        String inputForMenu = "po\nghg\ninvalid\n";
        libraryManager = new LibraryManager(new Library(new ArrayList<Item>(), new ArrayList<Customer>()), new DummyMovieLibrary(),
                new Scanner(new ByteArrayInputStream(inputForMenu.getBytes())), out);

        libraryManager.checkOutBook();

        assertEquals(loginMessage + "Invalid Login\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenBookIsNotAvailable() {
        String inputForMenu = validUserName + "Harry Potter\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutBook();

        assertEquals(loginMessage + unsuccessfulBookCheckOut, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenCustomerIsNotValid() {
        String inputForMenu = validUserName + "Harry Potter\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutBook();

        assertEquals(loginMessage + unsuccessfulBookCheckOut, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutMovieWhenMovieIsNotAvailable() {
        String inputForMenu = validUserName + "Harry Potter\n";
        createLibraryManager(inputForMenu);

        libraryManager.checkOutMovie();

        assertEquals(loginMessage + unsuccessfulMovieCheckOut, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnBookWhenBookIsCheckedOut() {
        String inputForMenu = validUserName + "valid return\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnBook();

        assertEquals(loginMessage + successfulBookReturn, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnMovieWhenMovieIsCheckedOut() {
        String inputForMenu = validUserName + "valid return\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnMovie();

        assertEquals(loginMessage + successfulMovieReturn, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReturnBookWhenBookIsAvailableInLibrary() {
        String inputForMenu = validUserName + "Harry\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnBook();

        assertEquals(loginMessage + unsuccessfulBookReturn, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReturnMovieWhenMovieIsAvailableInLibrary() {
        String inputForMenu = validUserName + "Harry\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnMovie();

        assertEquals(loginMessage + unsuccessfulMovieReturn, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReurnBookWhenBookIsNotInLibraryList() {
        String inputForMenu = validUserName + "Harry Potter\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnBook();

        assertEquals(loginMessage + unsuccessfulBookReturn, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReurnMovieWhenMovieIsNotInLibraryList() {
        String inputForMenu = validUserName + "Harry Potter\n";
        createLibraryManager(inputForMenu);

        libraryManager.returnMovie();

        assertEquals(loginMessage + unsuccessfulMovieReturn, byteArrayOutputStream.toString());
    }


    @Test
    public void shouldDisplayBookList() {
        String inputForMenu = "Harry Potter\n";
        createLibraryManager(inputForMenu);
        libraryManager.displayBook();
        String format = "%-30s%-30s%s\n";

        String expected =String.format(format,"Author","Book Name","Year Of Publication")+String.format(format,  "Harry Potter","J K Rowling", 1992);

        assertEquals(expected, byteArrayOutputStream.toString());

    }

    @Test
    public void shouldDisplayMovieList() {
        String inputForMenu = "Harry Potter\n";
        createLibraryManager(inputForMenu);
        libraryManager.displayMovie();
        String format = "%-30s%-30s%-30s%s\n";

        String expected =String.format(format,"Movie Name","Year Of Release","Director Name","Movie Rating")+String.format(format,"Kaho Na Pyar Hai", 1999, "Rakesh R", 6.1);

        assertEquals(expected, byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayCustomerList() {
        String inputForMenu = validUserName +"Harry Potter\n";
        createLibraryManager(inputForMenu);
        libraryManager.checkOutMovie();
        libraryManager.displayCurrentCustomer();
        String format = "%-30s%-30s%s\n";

        StringBuilder list = new StringBuilder(String.format(format,"name","email","phone"));
        list.append(String.format(format,"Random", "xyz@gmail.com", "1234567891"));

        assertEquals(loginMessage + unsuccessfulMovieCheckOut+list.toString(), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotDisplayCustomerListWhenCustomerIsNotLoggedIn() {
        String inputForMenu = validUserName +"Harry Potter\n";
        createLibraryManager(inputForMenu);
        libraryManager.displayCurrentCustomer();

        assertEquals("", byteArrayOutputStream.toString());
    }

}

