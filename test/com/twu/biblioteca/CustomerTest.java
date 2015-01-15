package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CustomerTest {

    @Test
    public void shouldValidateCustomerCredentials() {
        assertTrue(new Customer("123-1234", "password", "Random", "xyz@gmail.com", "1234567891").isValidLogin("123-1234", "password"));
    }

    @Test
    public void shouldNotValidateWrongCustomerCredentials() {
        assertFalse(new Customer("123-1234", "password", "Random", "xyz@gmail.com", "1234567891").isValidLogin("123-1234", "passwor"));
    }


}
