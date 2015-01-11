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

    public void menuList(PrintStream printStream) {
        for (Menu menu :Menu.values()){
            if(!(menu == Menu.INVALID))
            printStream.println(menu.toString());
        }
    }
    public void selectOption(InputStream inputStream, PrintStream printStream){
        Scanner scanner = new Scanner(inputStream);
        menuList(printStream);
        executeMenu(printStream, scanner);

    }
    private void executeMenu(PrintStream printStream, Scanner scanner) {
        int option;
        while(scanner.hasNext()) {
            option = Integer.parseInt(scanner.nextLine());
            Menu menu = Menu.getMenu(option);
            if(!menu.executeMenu(printStream, scanner, listOfBook))
                break;
            menuList(printStream);
        }
    }



}

