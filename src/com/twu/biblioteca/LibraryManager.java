package com.twu.biblioteca;

import java.io.PrintStream;
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
        if(checkEligibilityForItemToBeCheckedOut(movieLibrary,scanner.nextLine()))
            printStream.println("Thank you! Enjoy the movie");
        else
            printStream.println("That movie is not available.");
    }

    public void checkOutBook() {
        if (!loginSuccess(library)) return;
        printStream.println("Enter book name for checkout");
        if(checkEligibilityForItemToBeCheckedOut(library,scanner.nextLine()))
            printStream.println("Thank you! Enjoy the book");
        else
            printStream.println("That book is not available.");

    }

    private boolean loginSuccess(Library library) {
        if(customer == null )
            if (!login(library)) {
                printStream.println("Invalid Login");
                return false;
            }
        return true;
    }

    private boolean checkEligibilityForItemToBeCheckedOut(Library library, String itemName){
        Item item = library.Find(itemName);
        if(item!=null && library.checkOutItem(item))
                return true;
        return false;
    }
    private boolean checkEligibilityForItemToBeReturned(Library library, String itemName){
        Item item = library.Find(itemName);
        if(item!=null && library.returnItem(item))
                return true;

        return false;
    }

    private boolean login(Library library) {
        printStream.println("Enter Library Number:");
        String userName = scanner.nextLine();
        printStream.println("Enter Password");
        String password = scanner.nextLine();

        customer = library.isValidCustomer(userName, password);
        if (customer==null)
            return false;
        return true;

    }

    public void returnBook() {
        if (!loginSuccess(library)) return;
        printStream.println("Enter book name for return");
        if(checkEligibilityForItemToBeReturned(this.library , scanner.nextLine()))
            printStream.println("Thank you for returning the book");
        else
            printStream.println("That is not a valid book to return.");
    }

    public void returnMovie() {
        if (!loginSuccess(movieLibrary)) return;
        printStream.println("Enter movie name for return");
        if(checkEligibilityForItemToBeReturned(this.movieLibrary, scanner.nextLine()))
            printStream.println("Thank you for returning the movie");
        else
            printStream.println("That is not a valid movie to return.");
    }

    public void displayBook() {
        printStream.print(library.DisplayList());
    }
    public void displayMovie() {
        printStream.print(movieLibrary.DisplayList());
    }
}
