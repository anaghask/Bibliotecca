package com.twu.biblioteca;

public enum Menu {
    DISPLAYBOOK(1, "Display Books") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.displayBook();
            return true;
        }
    },
    DISPLAYMOVIE(2, "Display Movie") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.displayMovie();
            return true;
        }
    },

    CHECKOUTBOOK(3, "CheckOut Book") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.checkOutBook();
            return true;
        }
    },
    CHECKOUTMOVIE(4, "CheckOut Movie") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.checkOutMovie();
            return true;
        }
    },

    RETURNBOOK(5, "Return Book") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.returnBook();
            return true;
        }
    },

    RETURNMOVIE(6, "Return Movie") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            libraryManager.returnMovie();
            return true;
        }
    },

    QUIT(7, "Quit") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            return true;
        }
    },

    DISPLAYCUSTOMERINFO(8, "Display User Information") {
        @Override
        public boolean executeMenu(LibraryManager libraryManager) {
            if(libraryManager.isLoggedIn())
            {
                libraryManager.displayCurrentCustomer();
                return true;
            }
            return false;
        }
    },
    INVALID(9, "Invalid Option") {
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

    public static Menu getMenu(int option) {
        for (Menu menu : Menu.values()) {
            if (option == menu.index)
                return menu;
        }
        return Menu.INVALID;
    }


    @Override
    public String toString() {
        return index + ":" + name;
    }

    public abstract boolean executeMenu(LibraryManager libraryManager);

}
