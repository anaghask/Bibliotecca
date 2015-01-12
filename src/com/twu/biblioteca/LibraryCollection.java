package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryCollection {
    private final ArrayList<Item> listOfItem;

    public LibraryCollection(ArrayList<Item> listOfItem) {
        this.listOfItem = listOfItem;
    }

    public boolean DisplayList() {
        Item itemHeader = listOfItem.get(listOfItem.size()-1);
        System.out.println(itemHeader.returnHeader());
        for(Item item : listOfItem){
            if (!item.checkOutStatus)
                System.out.println(item.toString());
        }
        return true;
    }


    public boolean returnItem(Scanner scanner) {
        String itemName;
        System.out.println("Enter book name for return");
        itemName = scanner.nextLine();
        boolean flag = false;
        for (Item item : listOfItem){
            if(item.name.compareToIgnoreCase(itemName) == 0 && item.checkOutStatus){
                System.out.println("Thank you for returning the book");
                item.returnItem();
                flag =true;
                break;
            }
        }
        if(!flag){
            System.out.println("That is not a valid book to return.");
        }
        return true;
    }

    public boolean checkOutItem(Scanner scanner) {
        String itemName;
        System.out.println("Enter book name for checkout");
        boolean flag = false;
        itemName = scanner.nextLine();
        for (Item item : listOfItem){
            if(item.name.compareToIgnoreCase(itemName) == 0 && !item.checkOutStatus){
                item.checkOutItem();
                System.out.println("Thank you! Enjoy the book");
                flag = true;
                break;
            }
        }
        if (!flag){
            System.out.println("That book is not available.");
        }
        return true;
    }
}
