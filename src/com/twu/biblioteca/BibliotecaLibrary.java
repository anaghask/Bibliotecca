package com.twu.biblioteca;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaLibrary {
    LibraryCollection libraryCollection;

    public BibliotecaLibrary(LibraryCollection libraryCollection){
        this.libraryCollection = libraryCollection;
        System.out.println("Welcome");
    }

    public static void main(String[] args) {
        LibraryCollection libraryCollection = getBookCollection();
        new BibliotecaLibrary(libraryCollection).selectOption(System.in);

        libraryCollection = getMovieCollection();
        new BibliotecaLibrary(libraryCollection).selectOption(System.in);

    }


    private void menuList() {
        for (Menu menu :Menu.values()){
            if(!(menu == Menu.INVALID))
                System.out.println(menu.toString());
        }
    }

    public void selectOption(InputStream inputStream){
        Scanner scanner = new Scanner(inputStream);
        menuList();
        executeMenu(scanner);

    }

    private void executeMenu(Scanner scanner) {
        int option;
        while(scanner.hasNext()) {
            option = Integer.parseInt(scanner.nextLine());
            Menu menu = Menu.getMenu(option);
            if(!menu.executeMenu(scanner,libraryCollection))
                break;
            menuList();
        }
    }

    private static LibraryCollection getMovieCollection() {
        ArrayList<Item> items;
        LibraryCollection libraryCollection;Movie movie1 = new Movie("Krish3", 2012, "Rakesh Roshan", 3.2, false);
        Movie movie2 = new Movie("Kaho Na Pyar Hai", 1999, "Rakesh R", 6.1, false);

        items = new ArrayList<Item>();

        items.add(movie1);
        items.add(movie2);

        libraryCollection = new LibraryCollection(items);
        return libraryCollection;
    }

    private static LibraryCollection getBookCollection() {
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(book1);
        items.add(book2);

        return new LibraryCollection(items);
    }

}

