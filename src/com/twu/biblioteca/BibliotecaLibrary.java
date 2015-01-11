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

    public void welcomeMessage(PrintStream printStream) {
        printStream.println("Welcome");
    }


    public void bookList(PrintStream printStream) {
        printStream.println("Author\t\tBook Name\t\tYear Of Publication");
        for(Book book :listOfBook){
            if (!book.checkOutStatus)
             printStream.println(book.toString());
        }
    }

    public void menuList(PrintStream printStream) {
        for (Menu menu :Menu.values()){
            printStream.println(menu.toString());
        }
    }

    public void selectOption(InputStream inputStream, PrintStream printStream){
        Scanner scanner = new Scanner(inputStream);
        String bookName;
        int option;
        menuList(printStream);
        while(scanner.hasNext()) {
            option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:
                    bookList(printStream);
                    break;
                case 2:
                    printStream.println("Enter book name for checkout");
                    bookName = scanner.nextLine();
                    this.checkOutBook(bookName);
                    break;
                case 3:
                    return;
                default:
                    printStream.println("Invalid Option");
            }
            menuList(printStream);
        }

    }

    private void checkOutBook(String bookName) {
        for (Book book : listOfBook){
            if(book.bookName.compareToIgnoreCase(bookName) == 0){
                book.checkOutBook();
            }
        }
    }
}

