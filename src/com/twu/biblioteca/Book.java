package com.twu.biblioteca;

public class Book {
    private final String author;
    private final String bookName;
    private final int yearPublished;

    public Book(String author, String bookName, int yearPublished) {
        this.author = author;
        this.bookName = bookName;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return  author + "\t" +
                 bookName + "\t" +
                 yearPublished ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (bookName != null ? !bookName.equals(book.bookName) : book.bookName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return bookName != null ? bookName.hashCode() : 0;
    }
}
