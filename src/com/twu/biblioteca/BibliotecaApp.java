package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        StringBuilder book1 = new StringBuilder("Harry Potter");
        StringBuilder book2 = new StringBuilder("Angels and Demons");
        ArrayList<StringBuilder> bookList = new ArrayList<StringBuilder>();

        bookList.add(book1);
        bookList.add(book2);

        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary(bookList);
        bibliotecaLibrary.WelcomeMessage(printStream);
        bibliotecaLibrary.BookList(printStream);

    }

}
