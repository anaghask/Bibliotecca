package com.twu.biblioteca;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BibliotecaLibraryTest {
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    private BibliotecaLibraryApp bibliotecaLibraryApp;
    private StringBuilder welcome = new StringBuilder("Welcome\n");
    private StringBuilder menuString =new StringBuilder("1:Display\n2:CheckOut\n3:Return\n4:Quit\n");
    private ArrayList<Item> listOfItem = new ArrayList<Item>();



    public BibliotecaLibraryTest(){
        Book book2 = new Book("Dan Brown","Angels and Demons",1245, false);
        listOfItem.add(book2);
    }

    @Before
    public void setPrintStream() {
        System.setOut(new PrintStream(byteArrayOutputStream));
        bibliotecaLibraryApp = new BibliotecaLibraryApp(new Library(listOfItem));
    }

    @After
    public void deletePrintStream() {
        byteArrayOutputStream.reset();
        byteArrayOutputStream = null;
    }

    @Test
    public void shouldBeAbleToSelectFromMenu(){
        String inputForMenu ="1";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());

        bibliotecaLibraryApp.selectOption(byteArrayInputStream);
        StringBuilder expectedOutput = welcome.append(menuString);
        expectedOutput.append("Author\t\tBook Name\t\tYear Of Publication\n" + "Dan Brown\tAngels and Demons\t1245\n").append(menuString);
        assertEquals(expectedOutput.toString(), byteArrayOutputStream.toString());
    }

    @Test
    public void shouldBeAbleQuitOnMenuSelection(){
        String inputForMenu ="4";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(inputForMenu.getBytes());

        bibliotecaLibraryApp.selectOption(byteArrayInputStream);

        assertEquals(welcome.append(menuString).toString(), byteArrayOutputStream.toString());
    }

}
