package com.twu.biblioteca;

import java.util.ArrayList;

class DummyMovieLibrary extends Library{
    public DummyMovieLibrary(){
        this(new ArrayList<Item>(),new ArrayList<Customer>());
    }
    public DummyMovieLibrary(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        super(listOfItem, customers);
    }

    @Override
    public String DisplayList() {
        return "DisplayList";
    }

    @Override
    public Item Find(String itemName) {
        if(itemName.equals("valid return"))
            return new Movie("valid",1234,"xyz",4.1,true);
        else
        if(itemName.equals("valid checkout"))
            return new Movie("valid",1234,"xyz",4.1,false);
        else
            return null;
    }

    @Override
    public Customer isValidCustomer(String userName, String password) {
        return new Customer(userName,password);
    }

}