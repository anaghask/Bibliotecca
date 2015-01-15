package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    private final ArrayList<Item> bookCollection;
    private Library library;
    private Book validCheckOutBook;
    private Book book1;
    private Book invalidBook;
    private Book validReturnableBook;

    public LibraryTest() {
        bookCollection = getBookCollection();
        library = new Library(bookCollection, getCustomerList());
        invalidBook = new Book("Dan", "Angels", 1245, false);

    }

    @Test
    public void shouldGetDisplayList() {
        StringBuilder expectedOutput = new StringBuilder("Author\t\tBook Name\t\tYear Of Publication\n");
        for (Item book : bookCollection) {
            expectedOutput.append(book.toString());
        }
        assertEquals(expectedOutput.toString(), library.DisplayList());
    }

    @Test
    public void shouldSuccessfullyReturnItemIfValidItemIsProvided() {
        assertTrue(library.returnItem(validReturnableBook));
    }

    @Test
    public void shouldNotReturnItemIfInValidItemIsProvided() {

        assertFalse(library.returnItem(this.invalidBook));
    }

    @Test
    public void shouldCheckOutItemIfValidItemNameIsProvided() {

        assertTrue(library.checkOutItem(validCheckOutBook));
    }

    @Test
    public void shouldNotCheckOutItemIfInvalidItemNameIsProvided() {
        assertFalse(library.checkOutItem(validReturnableBook));
    }

    @Test
    public void shouldBeAbleToFindItemOnValidItemName() {
        assertEquals(book1, library.Find("Angels and Demons"));
    }

    @Test
    public void shouldReturnNullOnInvalidItemName() {
        assertEquals(null, library.Find("Angels"));
    }

    @Test
    public void shouldBeAbleToValidateLogin() {
        String userName = "123-1234";
        String password = "password";
        assertNotEquals(null, library.isValidCustomer(userName, password));
    }

    @Test
    public void shouldNotValidateLoginIfUsernameIsWrong() {
        String userName = "123-123";
        String password = "password";
        assertEquals(null, library.isValidCustomer(userName, password));
    }

    private ArrayList<Item> getBookCollection() {
        validCheckOutBook = new Book("J K Rowling", "Harry Potter", 1992, false);
        book1 = new Book("Dan Brown", "Angels and Demons", 1245, false);
        validReturnableBook = new Book("Dan ", "Attend", 1245, true);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(validCheckOutBook);
        items.add(book1);

        return items;
    }

    private ArrayList<Customer> getCustomerList() {
        Customer customer = new Customer("123-1234", "password", "Random", "xyz@gmail.com", "1234567891");
        Customer customer1 = new Customer("123-1235", "password1", "Random", "xyz@gmail.com", "1234567891");
        Customer customer2 = new Customer("123-1236", "password2", "Random", "xyz@gmail.com", "1234567891");
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }

    @Test
    public void shouldCheckIfParticularCustomerIsLoggedIn() {

    }
}