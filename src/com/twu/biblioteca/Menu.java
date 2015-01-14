package com.twu.biblioteca;

public enum Menu {
    DISPLAY(1,"Display") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.display();
            return true;
        }
    },

    CHECKOUT(2,"CheckOut") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.checkOut();
            return true;
        }
    },

    RETURN(3,"Return") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.returnItem();
            return true;
        }
    },

    QUIT(4,"Quit") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
        return true;
        }
    },

    INVALID(5,"Invalid Option") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            return false;
        }
    };

    public final int index;
    public String name;

    Menu(int Index, String name) {
        index = Index;
        this.name = name;
    }


    @Override
    public String toString() {
        return index + ":" + name;
    }

    public static Menu getMenu(int option) {
        for (Menu menu :Menu.values()){
            if(option == menu.index)
                return menu;
        }
        return Menu.INVALID;
    }

    public abstract boolean executeMenu(LibraryManager libraryManager);

}
