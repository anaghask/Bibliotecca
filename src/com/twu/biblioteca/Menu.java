package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public enum Menu {
    DISPLAY(1,"Display") {
        @Override
        public boolean executeMenu(PrintStream printStream, Scanner scanner, ArrayList<Book> listOfBook) {
            printStream.println("Author\t\tBook Name\t\tYear Of Publication");
            for(Book book1 : listOfBook){
                if (!book1.checkOutStatus)
                    printStream.println(book1.toString());
            }
            return true;
        }
    },

    CHECKOUT(2,"CheckOut Book") {
        @Override
        public boolean executeMenu(PrintStream printStream, Scanner scanner, ArrayList<Book> listOfBook) {
            String bookName;
            printStream.println("Enter book name for checkout");
            boolean flag = false;
            bookName = scanner.nextLine();
            for (Book book : listOfBook){
                if(book.bookName.compareToIgnoreCase(bookName) == 0 && !book.checkOutStatus){
                    book.checkOutBook();
                    printStream.println("Thank you! Enjoy the book");
                    flag = true;
                    break;
                }
            }
            if (!flag){
                    printStream.println("That book is not available.");
            }
            return true;
        }
    },

    QUIT(3,"Quit") {
        @Override
        public boolean executeMenu(PrintStream printStream, Scanner scanner, ArrayList<Book> listOfBook) {
        return false;
        }
    },

    INVALID(4,"Invalid Option") {
        @Override
        public boolean executeMenu(PrintStream printStream, Scanner scanner, ArrayList<Book> listOfBook) {
            printStream.println("Invalid Option");
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
        Menu invalid = Menu.INVALID;
        return invalid;
    }


    public abstract boolean executeMenu(PrintStream printStream, Scanner scanner, ArrayList<Book> listOfBook);

}
