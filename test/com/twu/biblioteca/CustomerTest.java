package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {
    @Test
    public void shouldValidateCustomerForProperUserName(){
        assertTrue(new Customer("123-1234", "password").isValid("123-1234"));
    }

    @Test
    public void shouldNotValidateCustomerForProperUserName(){
        assertFalse(new Customer("123-1234", "password").isValid("112-111"));
    }

    @Test
    public void shouldValidateCustomerCredentials(){
        assertTrue(new Customer("123-1234","password").isValidLogin("123-1234", "password"));
    }

    @Test
    public void shouldNotValidateWrongCustomerCredentials(){
        assertFalse(new Customer("123-1234","password").isValidLogin("123-1234", "passwor"));
    }



}
