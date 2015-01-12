package com.twu.biblioteca;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaLibraryApp {
    Library library;

    public BibliotecaLibraryApp(Library library){
        this.library = library;
        System.out.println("Welcome");
    }

    public static void main(String[] args) {
        Library library = getBookCollection();
        new BibliotecaLibraryApp(library).selectOption(System.in);

        library = getMovieCollection();
        new BibliotecaLibraryApp(library).selectOption(System.in);

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
            if(!menu.executeMenu(scanner, library))
                break;
            menuList();
        }
    }

    private static Library getMovieCollection() {
        ArrayList<Item> items;
        Library library;Movie movie1 = new Movie("Krish3", 2012, "Rakesh Roshan", 3.2, false);
        Movie movie2 = new Movie("Kaho Na Pyar Hai", 1999, "Rakesh R", 6.1, false);

        items = new ArrayList<Item>();

        items.add(movie1);
        items.add(movie2);

        library = new Library(items);
        return library;
    }

    private static Library getBookCollection() {
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(book1);
        items.add(book2);

        return new Library(items);
    }

}

