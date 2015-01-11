package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaLibrary {
    private final ArrayList<Book> listOfBook;

    public BibliotecaLibrary(ArrayList<Book> listOfBook){
        this.listOfBook = listOfBook;
    }

    public void WelcomeMessage(PrintStream printStream) {
        printStream.println("Welcome");
    }


    public void BookList(PrintStream printStream) {
        printStream.println("Author\t\tBook Name\t\tYear Of Publication");
        for(Book book :listOfBook){
            printStream.println(book.toString());
        }
    }

    public void MenuList(PrintStream printStream) {
        printStream.println("Menu");
        for (Menu menu :Menu.values()){
            printStream.println(menu.toString());
        }
    }

    public void SelectOption(InputStream inputStream, PrintStream printStream){
        Scanner scanner = new Scanner(inputStream);
        int option;
        while(scanner.hasNext()) {
            MenuList(printStream);
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    BookList(printStream);
                    break;
                default:
                    printStream.println("Invalid Option");
            }
        }

    }
}

