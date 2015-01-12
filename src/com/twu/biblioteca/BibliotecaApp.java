package com.twu.biblioteca;

import java.util.ArrayList;

public class BibliotecaApp {

    public static void main(String[] args) {
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(book1);
        items.add(book2);

        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary(items);
        bibliotecaLibrary.welcomeMessage(System.out);

        bibliotecaLibrary.selectOption(System.in, System.out);


        Movie movie1 = new Movie("Krish3", 2012, "Rakesh Roshan", 3.2, false);
        Movie movie2 = new Movie("Kaho Na Pyar Hai", 1999, "Rakesh R", 6.1, false);

        items = new ArrayList<Item>();

        items.add(movie1);
        items.add(movie2);

        bibliotecaLibrary = new BibliotecaLibrary(items);
        bibliotecaLibrary.welcomeMessage(System.out);

        bibliotecaLibrary.selectOption(System.in, System.out);



    }


}
