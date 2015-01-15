package com.twu.biblioteca;

import java.util.ArrayList;


class DummyBookLibrary extends Library {
    public DummyBookLibrary() {
        this(new ArrayList<Item>(), new ArrayList<Customer>());
    }

    public DummyBookLibrary(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        super(listOfItem, customers);
    }

    @Override
    public ArrayList<Item> getList() {
        return getBookCollection();
    }

    @Override
    public Item Find(String itemName) {
        if (itemName.equals("valid return"))
            return new Book("xyz", "valid", 1234, true);
        else if (itemName.equals("valid checkout"))
            return new Book("xyz", "valid", 1234, false);
        else
            return null;
    }

    @Override
    public Customer isValidCustomer(String userName, String password) {
        return new Customer(userName, password, "Random", "xyz@gmail.com", "1234567891");
    }

    private ArrayList<Item> getBookCollection() {
        Book validCheckOutBook = new Book("J K Rowling", "Harry Potter", 1992, false);
        ArrayList<Item> items = new ArrayList<Item>();
        items.add(validCheckOutBook);
        return items;
    }
}


