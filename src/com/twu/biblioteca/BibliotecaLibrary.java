package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

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
}
