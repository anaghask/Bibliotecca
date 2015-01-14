package com.twu.biblioteca;


import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BibliotecaLibraryAppTest {
    private final DummyLibraryManager libraryManager;
    private final PrintStream printStream;
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private BibliotecaLibraryApp bibliotecaLibraryApp;
    private String inputForMenu;
    private String welComeString ="Welcome\n";
    private String menuString ="1:Display\n2:CheckOut\n3:Return\n4:Quit\n";


    public BibliotecaLibraryAppTest() {
        libraryManager = new DummyLibraryManager();
        printStream = new PrintStream(byteArrayOutputStream);
        bibliotecaLibraryApp = new BibliotecaLibraryApp(libraryManager, printStream);
    }

    @Test
    public void shouldBeAbleToSelectDisplayFromMenu() {
        inputForMenu = "1\n4\n";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        assertTrue(libraryManager.displayFlag);
    }

    @Test
    public void shouldBeAbleToSelectCheckOutFromMenu() {
        inputForMenu = "2\n4\n";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        assertTrue(libraryManager.checkOutFlag);
    }

    @Test
    public void shouldBeAbleToSelectReturnFromMenu() {
        inputForMenu = "3\n4\n";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        assertTrue(libraryManager.returnItem);
    }

    @Test
    public void shouldNotBeAbleToSelectWrongOptionFromMenu() {
        inputForMenu = "8\n4\n";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        String expected = welComeString + menuString + "Invalid Option\n" + menuString;
        assertEquals(expected, byteArrayOutputStream.toString());
    }


    @Test
    public void shouldBeAbleQuitOnMenuSelection() {
        String inputForMenu = "4\n";

        bibliotecaLibraryApp.selectOption(getScanner(inputForMenu));

        String expected = welComeString + menuString;
        assertEquals(expected,byteArrayOutputStream.toString());
    }

    private Scanner getScanner(String inputForMenu) {
        return new Scanner(new ByteArrayInputStream(inputForMenu.getBytes()));
    }


}