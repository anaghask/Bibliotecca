package com.twu.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class DummyLibraryManager extends LibraryManager{
        public boolean flag;
        public boolean checkOutFlag;
        public boolean returnItem;
        public boolean displayFlag;

        public DummyLibraryManager(){
            this(new Library(new ArrayList<Item>(),new ArrayList<Customer>()),new Scanner(System.in),System.out);
        }
        public DummyLibraryManager(Library library, Scanner scanner, PrintStream printStream) {
            super(library, scanner, printStream);
            flag =false;
        }

        @Override
        public void checkOut() {
            checkOutFlag = true;
        }

        @Override
        public void returnItem() {
            returnItem = true;
        }

        @Override
        public void display() {
            displayFlag = true;
        }
}

