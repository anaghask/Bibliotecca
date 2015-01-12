package com.twu.biblioteca;

import java.util.Scanner;

public enum Menu {
    DISPLAY(1,"Display") {
        @Override
        public boolean executeMenu(Scanner scanner, Library library) {
            return library.DisplayList();
        }
    },

    CHECKOUT(2,"CheckOut") {
        @Override
        public boolean executeMenu(Scanner scanner, Library library) {
            return library.checkOutItem(scanner);
        }
    },

    RETURN(3,"Return") {
        @Override
        public boolean executeMenu(Scanner scanner, Library library) {
            return library.returnItem(scanner);
        }
    },

    QUIT(4,"Quit") {
        @Override
        public boolean executeMenu(Scanner scanner, Library library) {
        return false;
        }
    },

    INVALID(5,"Invalid Option") {
        @Override
        public boolean executeMenu(Scanner scanner, Library library) {
            System.out.println("Invalid Option");
            return true;
        }
    };

    public final int index;
    public String name;

    Menu(int Index, String name) {
        index = Index;
        this.name = name;
    }


    @Override
    public String toString() {
        return index + ":" + name;
    }

    public static Menu getMenu(int option) {
        for (Menu menu :Menu.values()){
            if(option == menu.index)
                return menu;
        }
        return Menu.INVALID;
    }

    public abstract boolean executeMenu(Scanner scanner, Library library);

}
