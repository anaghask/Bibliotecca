package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaLibraryAppTest {
    private final DummyLibraryManager libraryManager;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private BibliotecaLibraryApp bibliotecaLibraryApp;
    private String inputForMenu;


    public BibliotecaLibraryAppTest() {
        libraryManager = new DummyLibraryManager();
        bibliotecaLibraryApp = new BibliotecaLibraryApp(libraryManager);
    }

    @Test
    public void shouldBeAbleToSelectFromMenu() {
        inputForMenu = "1";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        assertTrue(libraryManager.displayFlag);
    }


    @Test
    public void shouldBeAbleQuitOnMenuSelection() {
        String inputForMenu = "4";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        assertEquals("",byteArrayOutputStream.toString());
    }

    private Scanner getScanner(String inputForMenu) {
        return new Scanner(new ByteArrayInputStream(inputForMenu.getBytes()));
    }


}