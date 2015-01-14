package com.twu.biblioteca;

public class Customer {
    private final String userName;
    private final String password;
    private final String userNameFormat ="\\d{3}-\\d{4}";

    public Customer(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public boolean isValid(String userName) {
        if (userName.matches(userNameFormat))
            return true;
        return false;
    }

    public boolean isValidLogin(String userName, String password) {
        if (isValid(userName))
            if (userName.equals(this.userName) && password.equals(this.password))
                return true;
        return false;
    }

}
