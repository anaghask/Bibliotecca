package com.twu.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LibraryManagerTest {

    private ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    Scanner scanner;
    ArrayList<Item> bookList = new ArrayList<Item>();
    Library library = new Library(bookList,getCustomerList() );
    private PrintStream out = new PrintStream(byteArrayOutputStream);
    private LibraryManager libraryManager = new LibraryManager(library, scanner, out);

    private ByteArrayInputStream getByteArrayInputStream(String inputForMenu) {
        return new ByteArrayInputStream(inputForMenu.getBytes());
    }

    private ArrayList<Customer> getCustomerList() {
        Customer customer = new Customer("123-1234", "password");
        Customer customer1 = new Customer("123-1235", "password1");
        Customer customer2 = new Customer("123-1236", "password2");
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }

    @Test
    public void shouldCheckOutBookWhenBookIsAvailable(){
        bookList.add(new Book("J K","Harry",1234,false));
        String inputForMenu ="Harry\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.checkOut();

        assertEquals("Enter book name for checkout\nThank you! Enjoy the book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenBookIsAvailableButAlreadyCheckedOut(){
        bookList.add(new Book("J K","Harry",1234,true));
        String inputForMenu ="Harry\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.checkOut();

        assertEquals("Enter book name for checkout\nThat book is not available.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotCheckOutBookWhenBookIsNotAvailable(){
        bookList.add(new Book("J K","Harry",1234,false));
        String inputForMenu ="Harry Potter\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.checkOut();

        assertEquals("Enter book name for checkout\nThat book is not available.\n",byteArrayOutputStream.toString());
    }

    @Test
    public void shouldReturnBookWhenBookIsCheckedOut(){
        bookList.add(new Book("J K","Harry",1234,true));
        String inputForMenu ="Harry\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.returnItem();

        assertEquals("Enter book name for return\nThank you for returning the book\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReturnBookWhenBookIsAvailableInLibrary(){
        bookList.add(new Book("J K","Harry",1234,false));
        String inputForMenu ="Harry\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.returnItem();

        assertEquals("Enter book name for return\nThat is not a valid book to return.\n", byteArrayOutputStream.toString());
    }

    @Test
    public void shouldNotReurnBookWhenBookIsNotInLibraryList(){
        bookList.add(new Book("J K","Harry",1234,false));
        String inputForMenu ="Harry Potter\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.returnItem();

        assertEquals("Enter book name for return\nThat is not a valid book to return.\n",byteArrayOutputStream.toString());
    }

    @Test
    public void shouldDisplayBookList(){
        bookList.add(new Book("J K","Harry",1234,false));
        String inputForMenu ="Harry Potter\n";
        scanner = new Scanner(getByteArrayInputStream(inputForMenu));
        libraryManager = new LibraryManager(library, scanner, out);

        libraryManager.display();

        assertEquals("Author\t\tBook Name\t\tYear Of Publication\nJ K\tHarry\t1234\n",byteArrayOutputStream.toString());
    }


    @Test
    public void shouldLogin() {
        String inputMenu ="123-1234\npassword\n";

        libraryManager = new LibraryManager(library, scanner, out);
        libraryManager.login(getByteArrayInputStream(inputMenu));

        assertTrue(libraryManager.isLoggedIn());
    }

}
