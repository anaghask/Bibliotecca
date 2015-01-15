package com.twu.biblioteca;

import java.util.ArrayList;

class DummyMovieLibrary extends Library {
    public DummyMovieLibrary() {
        this(new ArrayList<Item>(), new ArrayList<Customer>());
    }

    public DummyMovieLibrary(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        super(listOfItem, customers);
    }

    @Override
    public ArrayList<Item> getList() {
        return getMovieCollection();
    }

    @Override
    public Item Find(String itemName) {
        if (itemName.equals("valid return"))
            return new Movie("valid", 1234, "xyz", 4.1, true);
        else if (itemName.equals("valid checkout"))
            return new Movie("valid", 1234, "xyz", 4.1, false);
        else
            return null;
    }

    @Override
    public Customer isValidCustomer(String userName, String password) {
        return new Customer(userName, password, "Random", "xyz@gmail.com", "1234567891");
    }

    private ArrayList<Item> getMovieCollection() {
        ArrayList<Item> items = new ArrayList<Item>();
        Movie movie2 = new Movie("Kaho Na Pyar Hai", 1999, "Rakesh R", 6.1, false);
        items.add(movie2);
        return items;
    }

}