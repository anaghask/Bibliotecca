package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class LibraryTest{

    @Test
    public void shouldGetDisplayList() {

    }

    @Test
    public void shouldReturnItem(){

    }

    @Test
    public void shouldCheckOutItem() {


    }

    @Test
    public void shouldLogin() {

        Library library = new Library(getBookCollection(), getCustomerList());
        String userName="123-1234";
        String password ="password";
        library.login(userName,password);

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