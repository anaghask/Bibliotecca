package com.twu.biblioteca;

public enum Menu {
    DISPLAYBOOK(1, "Display Books") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.displayBook();
        }
    },
    DISPLAYMOVIE(2, "Display Movie") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.displayMovie();
        }
    },

    CHECKOUTBOOK(3, "CheckOut Book") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.checkOutBook();
        }
    },
    CHECKOUTMOVIE(4, "CheckOut Movie") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.checkOutMovie();
        }
    },

    RETURNBOOK(5, "Return Book") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.returnBook();
        }
    },

    RETURNMOVIE(6, "Return Movie") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            libraryManager.returnMovie();
        }
    },

    QUIT(7, "Quit") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
        }
    },

    DISPLAYCUSTOMERINFO(8, "Display User Information") {
        @Override
        public void executeMenu(LibraryManager libraryManager) {
            if(libraryManager.isLoggedIn())
            {
                libraryManager.displayCurrentCustomer();
            }
        }
    };

    public final int index;
    public String name;

    Menu(int Index, String name) {
        index = Index;
        this.name = name;
    }

    public static Menu getMenu(int option) {
        for (Menu menu : Menu.values()) {
            if (option == menu.index)
                return menu;
        }
        return null;
    }


    @Override
    public String toString() {
        return index + ":" + name;
    }

    public abstract void executeMenu(LibraryManager libraryManager);

}
