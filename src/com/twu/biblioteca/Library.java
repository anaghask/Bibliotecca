package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Item> listOfItem;
    private final ArrayList<Customer> customers;

    public Library(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        this.listOfItem = listOfItem;
        this.customers = customers;
    }

    public ArrayList<Item> getList() {
        return listOfItem;
    }


    public boolean returnItem(Item item) {
        if (item.checkOutStatus) {
            item.returnItem();
            return true;
        }
        return false;
    }

    public boolean checkOutItem(Item item) {
        if (!item.checkOutStatus) {
            item.checkOutItem();
            return true;
        }
        return false;
    }

    public Item Find(String itemName) {
        for (Item item : listOfItem) {
            if (item.name.compareToIgnoreCase(itemName) == 0) {
                return item;
            }
        }
        return null;

    }

    public Customer isValidCustomer(String userName, String password) {
        for (Customer customer : customers) {
            if (customer.isValidLogin(userName, password)) {
                return customer;
            }
        }
        return null;
    }


}
