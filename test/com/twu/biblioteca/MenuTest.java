package com.twu.biblioteca;

import org.junit.After;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertEquals;


public class MenuTest {

    private DummyLibraryManager libraryManager = new DummyLibraryManager();

    @After
    public void resetFlagOfDummyObject() {
        libraryManager.checkOutFlag = false;
        libraryManager.displayFlag = false;
        libraryManager.returnItem = false;
    }

    @Test
    public void shouldReturnProperMenu() {
        assertEquals(Menu.getMenu(1), Menu.DISPLAYBOOK);
    }

    @Test
    public void shouldDisplayBookList() {
        Menu.getMenu(1).executeMenu(libraryManager);
        assertTrue(libraryManager.displayFlag);
    }

    @Test
    public void shouldDisplayMenuList() {
        Menu.getMenu(2).executeMenu(libraryManager);
        assertTrue(libraryManager.displayFlag);
    }

    @Test
    public void shouldBeAbleToCheckoutBook() {
        Menu.getMenu(3).executeMenu(libraryManager);
        assertTrue(libraryManager.checkOutFlag);
    }

    @Test
    public void shouldBeAbleToCheckoutMovie() {
        Menu.getMenu(4).executeMenu(libraryManager);
        assertTrue(libraryManager.checkOutFlag);
    }

    @Test
    public void shouldNotBeAbleToCheckoutBookOnInvalidInput() {
        Menu.getMenu(3).executeMenu(libraryManager);
        assertTrue(libraryManager.checkOutFlag);
    }

    @Test
    public void shouldBeAbleToReturnBookOnValidInput() {
        Menu.getMenu(5).executeMenu(libraryManager);
        assertTrue(libraryManager.returnItem);
    }

    @Test
    public void shouldBeAbleToReturnMovieOnValidInput() {
        Menu.getMenu(6).executeMenu(libraryManager);
        assertTrue(libraryManager.returnItem);
    }

    @Test
    public void shouldNotBeAbleToReturnBookOnInValidInput() {
        Menu.getMenu(5).executeMenu(libraryManager);
        assertTrue(libraryManager.returnItem);
    }

}

