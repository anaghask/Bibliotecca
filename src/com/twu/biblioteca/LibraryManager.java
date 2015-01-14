package com.twu.biblioteca;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class LibraryManager {
    private final Library library;
    private final Scanner scanner;
    private final PrintStream printStream;

    public LibraryManager(Library library,Scanner scanner, PrintStream printStream) {
        this.library = library;
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public void checkOut() {
        String itemName;
        printStream.println("Enter book name for checkout");
        itemName = scanner.nextLine();
        if(library.checkOutItem(itemName))
            printStream.println("Thank you! Enjoy the book");
        else
            printStream.println("That book is not available.");
    }

    public void login(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);

        printStream.println("Enter Library Number:");
        String userName = scanner.nextLine();
        printStream.println("Enter Password");
        String password = scanner.nextLine();

        library.login(userName,password);

    }

    public boolean isLoggedIn() {
        return library.isLoggedIn();
    }

    public void returnItem() {
        String itemName;
        printStream.println("Enter book name for return");
        itemName = scanner.nextLine();
        if(library.returnItem(itemName))
            printStream.println("Thank you for returning the book");
        else
            printStream.println("That is not a valid book to return.");
    }

    public void display() {
        printStream.print(library.DisplayList());
    }
}
