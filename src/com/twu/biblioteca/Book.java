package com.twu.biblioteca;

public class Book extends Item {
    public final String author;

    public Book(String author, String bookName, int yearPublished, boolean checkOut) {
        super(checkOut, yearPublished, bookName);
        this.author = author;
    }

    @Override
    public String[] returnHeader() {

        return new String[]{"Author","Book Name","Year Of Publication"};
    }


}
