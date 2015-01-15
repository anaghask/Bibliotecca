package com.twu.biblioteca;

public class Customer {
    public final String userName;
    public final String password;
    public final String name;
    public final String email;
    public final String phone;

    public Customer(String userName, String password, String name, String email, String phone) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public boolean isValidLogin(String userName, String password) {
        if (userName.equals(this.userName) && password.equals(this.password))
            return true;
        return false;
    }

}
