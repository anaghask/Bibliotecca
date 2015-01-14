package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class BibliotecaLibraryApp {
    private final LibraryManager libraryManager;

    public BibliotecaLibraryApp(LibraryManager libraryManager){
        this.libraryManager = libraryManager;
        welcomeMessage();
    }

    private void welcomeMessage() {
        System.out.println("Welcome");
    }

    public static void main(String[] args) {
        Library libraryBook = getBookCollection();
        Scanner scanner = new Scanner(System.in);

        LibraryManager libraryManager = new LibraryManager(libraryBook, scanner, System.out);
        new BibliotecaLibraryApp(libraryManager).selectOption(scanner);

        Library libraryMovie = getMovieCollection();

        libraryManager =new LibraryManager(libraryMovie, scanner, System.out);
        new BibliotecaLibraryApp(libraryManager).selectOption(scanner);

    }


    private void menuList() {
        for (Menu menu :Menu.values()){
            if(!(menu == Menu.INVALID))
                System.out.println(menu.toString());
        }
    }

    public void selectOption(Scanner scanner){
        menuList();
        int option;
        while(scanner.hasNext()) {
            option = Integer.parseInt(scanner.nextLine());
            if(!Menu.getMenu(option).executeMenu(libraryManager))
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

        library = new Library(items,getCustomerList() );
        return library;
    }

    private static Library getBookCollection() {
        Book book1 = new Book("J K Rowling","Harry Potter",1992, false);
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        ArrayList<Item> items = new ArrayList<Item>();

        items.add(book1);
        items.add(book2);

        return new Library(items, getCustomerList());
    }

    private static ArrayList<Customer> getCustomerList() {
        Customer customer = new Customer("123-1234", "password");
        Customer customer1 = new Customer("123-1235", "password1");
        Customer customer2 = new Customer("123-1236", "password2");
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(customer);
        customers.add(customer1);
        customers.add(customer2);
        return customers;
    }


}

