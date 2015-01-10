package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaLibrary {
    private final ArrayList<StringBuilder> listOfBook;
    public BibliotecaLibrary(ArrayList<StringBuilder> listOfBook){
        this.listOfBook = listOfBook;
    }
    public void WelcomeMessage(PrintStream printStream) {
        printStream.println("Welcome");
    }

    public void BookList(PrintStream printStream) {
        for(StringBuilder book :listOfBook){
            printStream.println(book.toString());
        }
    }
}
