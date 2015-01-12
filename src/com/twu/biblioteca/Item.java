package com.twu.biblioteca;

public abstract class Item {
    protected final int year;
    protected boolean checkOutStatus;
    public String name;

    public Item(boolean checkOutStatus, int yearOfRelease, String movieName) {
        this.checkOutStatus = checkOutStatus;
        this.year = yearOfRelease;
        this.name = movieName;
    }

    public void checkOutItem(){
        this.checkOutStatus = true;
    }

    public abstract String toString();

    public abstract String returnHeader();
    public void returnItem() {
        this.checkOutStatus = false;
    }
}
