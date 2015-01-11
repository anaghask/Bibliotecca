package com.twu.biblioteca;

public class Book {
    private final String author;
    public final String bookName;
    private final int yearPublished;
    public boolean checkOutStatus;

    public Book(String author, String bookName, int yearPublished,boolean checkOut) {
        this.author = author;
        this.bookName = bookName;
        this.yearPublished = yearPublished;
        this.checkOutStatus = checkOut;
    }

    public void checkOutBook(){
        this.checkOutStatus = true;
    }

    public void checkInBook(){
        this.checkOutStatus = false;
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
