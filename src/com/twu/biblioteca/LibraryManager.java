package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManager {
    private final Library library;
    private final Library movieLibrary;
    private final Scanner scanner;
    private final PrintStream printStream;
    private Customer customer;

    public LibraryManager(Library booklibrary, Library movieLibrary, Scanner scanner, PrintStream printStream) {
        this.library = booklibrary;
        this.movieLibrary = movieLibrary;
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public void checkOutMovie() {
        if (!loginSuccess(movieLibrary)) return;
        printStream.println("Enter movie name for checkout");
        if (checkEligibilityForItemToBeCheckedOut(movieLibrary, scanner.nextLine()))
            printStream.println("Thank you! Enjoy the movie");
        else
            printStream.println("That movie is not available.");
    }

    public void checkOutBook() {
        if (!loginSuccess(library)) return;
        printStream.println("Enter book name for checkout");
        if (checkEligibilityForItemToBeCheckedOut(library, scanner.nextLine()))
            printStream.println("Thank you! Enjoy the book");
        else
            printStream.println("That book is not available.");

    }

    private boolean loginSuccess(Library library) {
        if (customer == null)
            if (!login(library)) {
                printStream.println("Invalid Login");
                return false;
            }
        return true;
    }

    private boolean checkEligibilityForItemToBeCheckedOut(Library library, String itemName) {
        Item item = library.Find(itemName);
        return item != null && library.checkOutItem(item);
    }

    private boolean checkEligibilityForItemToBeReturned(Library library, String itemName) {
        Item item = library.Find(itemName);
        return item != null && library.returnItem(item);

    }

    private boolean login(Library library) {
        printStream.println("Enter Library Number:");
        String userName = scanner.nextLine();
        printStream.println("Enter Password");
        String password = scanner.nextLine();

        customer = library.isValidCustomer(userName, password);
        return customer != null;

    }

    public void returnBook() {
        if (!loginSuccess(library)) return;
        printStream.println("Enter book name for return");
        if (checkEligibilityForItemToBeReturned(this.library, scanner.nextLine()))
            printStream.println("Thank you for returning the book");
        else
            printStream.println("That is not a valid book to return.");
    }

    public void returnMovie() {
        if (!loginSuccess(movieLibrary)) return;
        printStream.println("Enter movie name for return");
        if (checkEligibilityForItemToBeReturned(this.movieLibrary, scanner.nextLine()))
            printStream.println("Thank you for returning the movie");
        else
            printStream.println("That is not a valid movie to return.");
    }

    public boolean isLoggedIn(){
        return customer != null;
    }

    public void displayBook()
    {
        ArrayList<Item> bookList = library.getList();
        Item itemHeader = bookList.get(bookList.size() - 1);
        String []headerList = itemHeader.returnHeader();
        String format = "%-30s%-30s%s\n";
        StringBuilder list = new StringBuilder(String.format(format,headerList));
        for (Item item : bookList) {
            if (!item.checkOutStatus) {
                Book book = (Book) item;
               list.append(String.format(format, book.name, book.author, book.year));
            }
        }
        printStream.print(list.toString());
    }

    public void displayMovie() {
        ArrayList<Item> movieList = movieLibrary.getList();
        Item itemHeader = movieList.get(movieList.size() - 1);
        String []headerList = itemHeader.returnHeader();
        String format = "%-30s%-30s%-30s%s\n";
        StringBuilder list = new StringBuilder(String.format(format,headerList));
        for (Item item : movieList) {
            if (!item.checkOutStatus) {
                Movie movie = (Movie) item;
                list.append(String.format(format,movie.name, movie.year,movie.directorName,movie.movieRating));
            }
        }

        printStream.print(list);
    }

    public void displayCurrentCustomer() {
        String format = "%-30s%-30s%s\n";
        if(isLoggedIn()) {
            StringBuilder list = new StringBuilder(String.format(format, "name", "email", "phone"));
            list.append(String.format(format, customer.name, customer.email, customer.phone));
            printStream.print(list.toString());
        }
    }
}
