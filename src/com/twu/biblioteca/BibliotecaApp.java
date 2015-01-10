package com.twu.biblioteca;

import java.io.PrintStream;

public class BibliotecaApp {

    public static void main(String[] args) {
        PrintStream printStream = new PrintStream(System.out);
        BibliotecaLibrary bibliotecaLibrary = new BibliotecaLibrary();
        bibliotecaLibrary.WelcomeMessage(printStream);

    }

}
