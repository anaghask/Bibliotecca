package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Book book1 = new Book("J K Rowling","Harry Potter",1992);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245);
        ArrayList<Book> bookList = new ArrayList<Book>();

        bookList.add(book1);
        bookList.add(book2);

        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary(bookList);
        bibliotecaLibrary.WelcomeMessage(System.out);

        bibliotecaLibrary.MenuList(System.out);
        bibliotecaLibrary.SelectOption(System.in,System.out);

    }


}
