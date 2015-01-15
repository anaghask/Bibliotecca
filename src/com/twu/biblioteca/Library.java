package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Item> listOfItem;
    private final ArrayList<Customer> customers;

    public Library(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        this.listOfItem = listOfItem;
        this.customers = customers;
    }

    public String DisplayList() {
        Item itemHeader = listOfItem.get(listOfItem.size() - 1);
        StringBuilder list = new StringBuilder(itemHeader.returnHeader() + "\n");
        for (Item item : listOfItem) {
            if (!item.checkOutStatus)
                list.append(item.toString());
        }
        return list.toString();
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
