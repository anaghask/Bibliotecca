package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DummyLibraryManager extends LibraryManager {
    public boolean flag;
    public boolean checkOutFlag;
    public boolean returnItem;
    public boolean displayFlag;

    public DummyLibraryManager() {
        this(new Library(new ArrayList<Item>(), new ArrayList<Customer>()), new Library(new ArrayList<Item>(), new ArrayList<Customer>()), new Scanner(System.in), System.out);
    }

    public DummyLibraryManager(Library library, Library movieLibrary, Scanner scanner, PrintStream printStream) {
        super(library, movieLibrary, scanner, printStream);
        flag = false;
    }

    @Override
    public void checkOutMovie() {
        this.checkOutFlag = true;
    }

    @Override
    public void checkOutBook() {
        this.checkOutFlag = true;

    }

    @Override
    public void returnBook() {
        this.returnItem = true;
    }

    @Override
    public void returnMovie() {
        this.returnItem = true;
    }

    @Override
    public void displayBook() {
        this.displayFlag = true;
    }

    @Override
    public void displayMovie() {
        this.displayFlag = true;
    }
}

