package com.twu.biblioteca;

public class Book extends Item {
    private final String author;

    public Book(String author, String bookName, int yearPublished, boolean checkOut) {
        super(checkOut, yearPublished, bookName);
        this.author = author;
    }

    @Override
    public String toString() {
        return author + "\t" + name + "\t" + year + "\n";
    }

    @Override
    public String returnHeader() {
        return "Author\t\tBook Name\t\tYear Of Publication";
    }


}
