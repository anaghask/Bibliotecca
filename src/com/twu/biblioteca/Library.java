package com.twu.biblioteca;

import java.util.ArrayList;

public class Library {
    private final ArrayList<Item> listOfItem;
    private final ArrayList<Customer> customers;
    private boolean loggedIn;

    public Library(ArrayList<Item> listOfItem, ArrayList<Customer> customers) {
        this.listOfItem = listOfItem;
        this.customers = customers;
    }

    public String DisplayList() {
        Item itemHeader = listOfItem.get(listOfItem.size()-1);
        StringBuilder list = new StringBuilder(itemHeader.returnHeader()+"\n");
        for(Item item : listOfItem){
            if (!item.checkOutStatus)
                list.append(item.toString());
        }
        return list.toString();
    }


    public boolean returnItem(String itemName) {
        for (Item item : listOfItem){
            if(item.name.compareToIgnoreCase(itemName) == 0 && item.checkOutStatus){
                item.returnItem();
                return true;
            }
        }
        return false;
    }

    public boolean checkOutItem(String itemName) {
        for (Item item : listOfItem){
            if(item.name.compareToIgnoreCase(itemName) == 0 && !item.checkOutStatus){
                item.checkOutItem();
                return true;
            }
        }
        return false;
    }

    public void login(String userName, String password) {
        for (Customer customer :customers){
            if (customer.isValidLogin(userName, password)){
                loggedIn =true;
            }
        }
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }


}
