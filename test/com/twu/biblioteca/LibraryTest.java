package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LibraryTest{

    private final ArrayList<Item> bookCollection;
    private Library library;

    public LibraryTest(){
        bookCollection = getBookCollection();
        library = new Library(bookCollection, getCustomerList());
    }

    @Test
    public void shouldGetDisplayList() {
        StringBuilder expectedOutput = new StringBuilder("Author\t\tBook Name\t\tYear Of Publication\n");
        for(Item book :bookCollection){
            expectedOutput.append(book.toString());
        }
        assertEquals(expectedOutput.toString(), library.DisplayList());
    }

    @Test
    public void shouldReturnItemIfValidNameIsProvided(){
        assertFalse(library.returnItem("Harry Potter"));
    }

    @Test
    public void shouldNotReturnItemIfInValidNameIsProvided(){
        assertFalse(library.returnItem("Harry Potter"));
    }

    @Test
    public void shouldCheckOutItemIfValidItemNameIsProvided() {
        assertTrue(library.checkOutItem("Harry Potter"));
    }

    @Test
    public void shouldNotCheckOutItemIfInvalidItemNameIsProvided() {
        bookCollection.add(new Book("J K","Harry",1992, true));
        assertFalse(library.checkOutItem("Harry"));
    }

    @Test
    public void shouldLogin() {

        String userName="123-1234";
        String password ="password";
        library.login(userName, password);

        assertTrue(library.isLoggedIn());
    }

    private ArrayList<Item> getBookCollection() {
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(book1);
        items.add(book2);

        return items;
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
    public void shouldCheckIfParticularCustomerIsLoggedIn() {

    }
}