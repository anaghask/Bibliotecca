package com.twu.biblioteca;

public enum Menu {
    DISPLAY(1,"Display"),
    QUIT(2,"Quit");

    private final int index;
    private final String name;

    Menu(int Index, String name) {
        index = Index;
        this.name = name;
    }

    @Override
    public String toString() {
        return index + ":" + name;
    }
}
