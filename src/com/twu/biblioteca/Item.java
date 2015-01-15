package com.twu.biblioteca;

public abstract class Item {
    public final int year;
    public String name;
    public boolean checkOutStatus;

    public Item(boolean checkOutStatus, int yearOfRelease, String movieName) {
        this.checkOutStatus = checkOutStatus;
        this.year = yearOfRelease;
        this.name = movieName;
    }

    public void checkOutItem() {
        this.checkOutStatus = true;
    }

    public abstract String[] returnHeader();

    public void returnItem() {
        this.checkOutStatus = false;
    }
}
